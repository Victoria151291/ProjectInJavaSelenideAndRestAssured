package pages;

import static com.codeborne.selenide.Selenide.open;
import static helpers.URLs.BASE_URL;

public class AuthPage extends Page {

    private final String LOGIN_FIELD_XPATH = "//input[@placeholder='Email or phone number']";
    private final String LOGIN_BTN_XPATH = "//button[@data-testid='auth-continue-button']";

    public static AuthPage initAuthPage() {
        return new AuthPage();
    }

    /**
     * open the URL of the auth page
     */
    public void openAuthPage() {
        open(BASE_URL);
    }

    /**
     * * auth and log in the shopping list
     */
    public void authAndLogIn(String testUserEmail) {
        clearAndSetValueIntoField(LOGIN_FIELD_XPATH, testUserEmail)
                .clickOnElementByLMB(LOGIN_BTN_XPATH);
        ShoppingListPage.initShoppingListPage();
    }

}