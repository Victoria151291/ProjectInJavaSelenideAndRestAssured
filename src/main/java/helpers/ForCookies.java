package helpers;

import io.restassured.http.Cookies;

import static helpers.URLs.URLs.BASE_URL;
import static io.restassured.RestAssured.given;

public class ForCookies {

    public static ForCookies initForCookies() {
        return new ForCookies();
    }

    public Cookies getCookies() {
        return given()
                .when()
                .get(BASE_URL)
                .then()
                .statusCode(200)
                .extract()
                .response()
                .getDetailedCookies();
    }

}