package pages;

public class SettingsPage extends Page {

    private final String ACCOUNT_SETTINGS_BTN_XPATH = "//button[@data-testid='user-settings-account-settings-link-edit-button']";
    private final String CLOSE_SETTINGS_BTN_XPATH = "//button[@data-testid='user-settings-close-button'][2]";

    public static SettingsPage initSettingsPage() {
        return new SettingsPage();
    }

    public AccountSettingsPage goToAccountSettings() {
        clickOnElementByLMB(ACCOUNT_SETTINGS_BTN_XPATH);
        return AccountSettingsPage.initAccountSettingsPage();
    }

    public void goBackToShoppingList() {
        clickOnElementByLMB(CLOSE_SETTINGS_BTN_XPATH);
    }

}