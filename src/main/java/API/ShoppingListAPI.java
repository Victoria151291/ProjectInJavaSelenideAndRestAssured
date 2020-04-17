package API;

import helpers.ForCookies;
import io.restassured.http.Cookies;

import java.util.List;

import static helpers.URLs.Paths.*;
import static helpers.URLs.URLs.BASE_URL;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;
import static resourcesClasses.BodiesForShoppingList.*;

public class ShoppingListAPI {

    private Cookies cookies;
    private String listId;
    private String itemId;

    public static ShoppingListAPI initShoppingListAPI() {
        return new ShoppingListAPI();
    }

    private ShoppingListAPI() {
        cookies = ForCookies.initForCookies().getCookies();
    }

    /**
     * creates the new list of items
     *
     * @param token - the registered Bearer token
     */
    public ShoppingListAPI createNewListOfItems(String token) {
        listId = given()
                .accept(JSON)
                .contentType(JSON)
                .body(getBodyFroNewList())
                .header("authorization", "Bearer " + token)
                .cookies(cookies)
                .cookie("dev.whisk.USER_TOKEN", token)
                .when().log().ifValidationFails()
                .post(BASE_URL + WORK_WITH_LIST_ENDPOINT)
                .then()
                .log().ifValidationFails().statusCode(200)
                .body("id", notNullValue()).extract().path("id");
        return this;
    }

    /**
     * gets all of lists of items
     *
     * @param token - the registered Bearer token
     */
    private List<String> getAllListsOfItems(String token) {
        return given()
                .accept(JSON)
                .contentType(JSON)
                .header("authorization", "Bearer " + token)
                .cookies(cookies)
                .cookie("dev.whisk.USER_TOKEN", token)
                .when().log().ifValidationFails()
                .get(BASE_URL + WORK_WITH_LIST_ENDPOINT)
                .then()
                .contentType(JSON)
                .log().ifValidationFails().statusCode(200)
                .extract().response().jsonPath().getList("id");
    }

    /**
     * checks if the created list exists
     *
     * @param token - the registered Bearer token
     */
    public ShoppingListAPI checkThatCreatedListExists(String token) {
        assertThat(getAllListsOfItems(token), hasItem(listId));
        return this;
    }

    /**
     * adds the item to the list
     *
     * @param token - the registered Bearer token
     */
    public ShoppingListAPI addItemToList(String token) {
        itemId = given()
                .accept(JSON)
                .contentType(JSON)
                .body(getBodyForItem())
                .header("authorization", "Bearer " + token)
                .cookies(cookies)
                .cookie("dev.whisk.USER_TOKEN", token)
                .when().log().all()
                .post(BASE_URL + WORK_WITH_ITEMS_ENDPOINT.replace("{list_id}", listId))
                .then()
                .contentType(JSON)
                .statusCode(200).log().all()
                .extract().jsonPath().get("items.id").toString();
        return this;
    }

    /**
     * gets all items of the list
     *
     * @param token - the registered Bearer token
     */
    private List<String> getAllItems(String token) {
        return given()
                .accept(JSON)
                .contentType(JSON)
                .header("authorization", "Bearer " + token)
                .cookies(cookies)
                .cookie("dev.whisk.USER_TOKEN", token)
                .when().log().all()
                .get(BASE_URL + GET_LIST_INFO_ENDPOINT.replace("{list_id}", listId))
                .then()
                .contentType(JSON)
                .statusCode(200).log().all()
                .extract().jsonPath().getList("items.id");
    }

    /**
     * checks if the created item exists
     *
     * @param token - the registered Bearer token
     */
    public ShoppingListAPI checkThatCreatedItemExists(String token) {
        assertEquals(getAllItems(token).toString(), itemId);
        return this;
    }

    /**
     * deletes the item from the list
     *
     * @param token - the registered Bearer token
     */
    public ShoppingListAPI deleteItem(String token) {
        given()
                .accept(JSON)
                .contentType(JSON)
                .body(getBodyToDeleteItem(getAllItems(token).get(0)))
                .header("authorization", "Bearer " + token)
                .cookies(cookies)
                .cookie("dev.whisk.USER_TOKEN", token)
                .when().log().all()
                .post(BASE_URL + WORK_WITH_ITEMS_ENDPOINT.replace("{list_id}", listId))
                .then()
                .contentType(JSON)
                .statusCode(200).log().all();
        return this;
    }

    /**
     * checks if the list is empty
     * @param token - the registered Bearer token
     */
    public boolean checkThatListIsEmpty(String token) {
        return given()
                .accept(JSON)
                .contentType(JSON)
                .header("authorization", "Bearer " + token)
                .cookies(cookies)
                .cookie("dev.whisk.USER_TOKEN", token)
                .when().log().all()
                .get(BASE_URL + GET_LIST_INFO_ENDPOINT.replace("{list_id}", listId))
                .then()
                .contentType(JSON)
                .statusCode(200).log().all()
                .extract().jsonPath().getList("items.id").isEmpty();
    }
}