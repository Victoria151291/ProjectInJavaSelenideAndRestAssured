package API;

import helpers.ForCookies;
import helpers.ForAuthorization;
import io.restassured.http.Cookies;
import org.json.JSONObject;
import testData.DataForTests;

import static helpers.URLs.Paths.*;
import static helpers.URLs.URLs.AUTH_URL;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.*;

public class AuthorizationAPI {

    private Cookies cookies;
    private String unregisteredBearerToken;

    public static AuthorizationAPI initAuthorizationAPI() {
        return new AuthorizationAPI();
    }

    private AuthorizationAPI() {
        cookies = ForCookies.initForCookies().getCookies();
        unregisteredBearerToken = ForAuthorization.initForAuthorization().getUnregisteredBearerToken();
    }

    /**
     * passes quick authorization with email
     */
    public AuthorizationAPI getQuickAuthorization() {
        given()
                .accept(JSON)
                .contentType(JSON)
                .body(new JSONObject().put("email", DataForTests.initDataForTests().getJSONForAuth().getString("email")).toString())
                .header("authorization", "Bearer " + unregisteredBearerToken)
                .cookies(cookies)
                .cookie("dev.whisk.USER_TOKEN", unregisteredBearerToken)
                .when().log().ifValidationFails()
                .post(AUTH_URL + QUICK_AUTH_ENDPOINT)
                .then()
                .log().ifValidationFails().statusCode(200)
                .body("status", equalTo("loginRequired"));

        return this;
    }

    /**
     * gets registered Bearer token and logs in after it
     */
    public String getRegisteredBearerTokenAndLogIn() {
        return given()
                .accept(JSON)
                .contentType(JSON)
                .body(DataForTests.initDataForTests().getJSONForAuth().toString())
                .header("authorization", "Bearer " + unregisteredBearerToken)
                .cookies(cookies)
                .cookie("dev.whisk.USER_TOKEN", unregisteredBearerToken)
                .when().log().ifValidationFails()
                .post(AUTH_URL + LOGIN_ENDPOINT)
                .then()
                .log().ifValidationFails().statusCode(200)
                .extract().path("token.access_token");
    }

    /**
     * logs out
     *
     * @param token - the registered Bearer token
     */
    public void logOut(String token) {
        ForAuthorization.initForAuthorization().killRegisteredBearerToken(token);
    }
}