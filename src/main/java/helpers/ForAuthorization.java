package helpers;

import org.json.JSONObject;

import static helpers.URLs.Paths.CREATE_BEARER_TOKEN_ENDPOINT;
import static helpers.URLs.URLs.BASE_URL;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class ForAuthorization {

    private String body;

    public static ForAuthorization initForAuthorization() {
        return new ForAuthorization();
    }

    private ForAuthorization(){
        body = getJSONForUnregisteredSession();
    }

    private String getJSONForUnregisteredSession() {
        JSONObject json = new JSONObject();
        json.put("clientId", "WCqJWnpNatcf3LUCxZmq94pR30sj2OOdBbMoGO8NGrMgUMk6Ogl4EMvLqcykNuGf");
        json.put("language", "en-US");
        json.put("locate", "true");
        return json.toString();
    }

    public String getUnregisteredBearerToken() {
        return given()
                .accept(JSON)
                .contentType(JSON)
                .body(body)
                .when().log().ifValidationFails()
                .post(BASE_URL + CREATE_BEARER_TOKEN_ENDPOINT)
                .then()
                .statusCode(200).log().ifValidationFails()
                .extract().path("token.access_token");
    }

    public void killRegisteredBearerToken(String token) {
        given()
                .accept(JSON)
                .contentType(JSON)
                .body(body)
                .cookie("dev.whisk.USER_TOKEN", token)
                .when().log().ifValidationFails()
                .post(BASE_URL + CREATE_BEARER_TOKEN_ENDPOINT)
                .then()
                .statusCode(200).log().ifValidationFails();
    }

}