package pages;

public class SettingsPage extends Page {

    private final String ACCOUNT_SETTINGS_BTN_XPATH = "//button[@data-testid='user-settings-account-settings-link-edit-button']";

    public static SettingsPage initSettingsPage() {
        return new SettingsPage();
    }

    public AccountSettingsPage goToAccountSettings() {
        clickOnElementByLMB(ACCOUNT_SETTINGS_BTN_XPATH);
        return AccountSettingsPage.initAccountSettingsPage();
    }

}