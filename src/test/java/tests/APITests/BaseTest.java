package tests.APITests;

import API.AuthorizationAPI;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {

    private String accessToken;

    public String getAccessToken() {
        return accessToken;
    }

    @BeforeClass
    public void passAuthorization() {
        accessToken = AuthorizationAPI
                .initAuthorizationAPI()
                .getQuickAuthorization()
                .getRegisteredBearerTokenAndLogIn();
    }

    @AfterClass
    public void logOut() {
        AuthorizationAPI.initAuthorizationAPI().logOut(getAccessToken());
    }

}