package pages;

public class ShoppingListPage extends Page {

    private final String ACCOUNT_BTN_XPATH = "//button[@data-testid='avatar-button']";
    private final String SETTINGS_BTN_XPATH = "//button[@data-testid='desktop-settings-button']";
    private final String LOGOUT_BTN_XPATH = "//button[@data-testid='desktop-logout-button']";
    private final String SIGN_UP_WELCOME_MSG_XPATH = "//span[text()='Welcome! Thanks for signing up.']";

    public static ShoppingListPage initShoppingListPage() {
        return new ShoppingListPage();
    }

    /**
     * checks that the welcome message exists after signing in
     */
    public ShoppingListPage checkThatSignUpWelcomeMsgExists() {
        checkThatElementExists(SIGN_UP_WELCOME_MSG_XPATH);
        return this;
    }

    /**
     * opens settings
     */
    public SettingsPage goToSettings() {
        selectDropDownItem(ACCOUNT_BTN_XPATH, SETTINGS_BTN_XPATH);
        return SettingsPage.initSettingsPage();
    }


}