package pages;

import testData.DataForTests;

import static testData.DataForTests.initDataForTests;

public class AccountSettingsPage extends Page {

    private final String PASSWORD_FIELD_XPATH = "//div[@data-testid='user-settings-password-value']";
    private final String PASSWORD_INPUT_XPATH = "//input[@name='password']";
    private final String CREATE_PASSWORD_BTN_XPATH = "//button[@data-testid='create-password-button']";
    private final String DELETE_ACCOUNT_BTN_XPATH = "//button[text()='Delete Account']";
    private final String TEXT_VALUE_TO_DELETE_ACCOUNT_FIELD_XPATH = "//input[@data-testid='UI_KIT_INPUT']";
    private final String DELETE_ACCOUNT_FOREVER_BTN_XPATH = "//button[@type='submit']";
    private final String BACK_TO_SETTINGS_BTN_XPATH = "//button[@data-testid='user-settings-account-settings-go-back-button'][2]";
    private final String DELETE_ACCOUNT_SUCCESS_MSG_XPATH = "//span[text()='Your account has been deleted.']";

    private final String PASSWORD_FIELD_DEFAULT_VALUE = "Set a password";
    private final String TEXT_VALUE_TO_DELETE_ACCOUNT = "delete";

    public static AccountSettingsPage initAccountSettingsPage() {
        return new AccountSettingsPage();
    }

    /**
     * checks if the text of the web element equals the specific value
     */
    public AccountSettingsPage checkPasswordDefaultValue() {
        getVisibleTextAndAssertIt(PASSWORD_FIELD_XPATH, PASSWORD_FIELD_DEFAULT_VALUE);
        return this;
    }

    /**
     * changes the password after registration of an account
     */
    public AccountSettingsPage changePassword() {
        clickOnElementByLMB(PASSWORD_FIELD_XPATH);
        clickOnElementByLMB(PASSWORD_INPUT_XPATH);
        clearAndSetValueIntoField(PASSWORD_INPUT_XPATH, DataForTests.initDataForTests().getRandomTestAccountPassword());
        clickOnElementByLMB(CREATE_PASSWORD_BTN_XPATH);
        return this;
    }

    /**
     * deletes the account from account settings
     */
    public void deleteTestAccount() {
        clickOnElementByLMB(DELETE_ACCOUNT_BTN_XPATH);
        clearAndSetValueIntoField(TEXT_VALUE_TO_DELETE_ACCOUNT_FIELD_XPATH, TEXT_VALUE_TO_DELETE_ACCOUNT);
        clickOnElementByLMB(DELETE_ACCOUNT_FOREVER_BTN_XPATH);
        checkThatElementExists(DELETE_ACCOUNT_SUCCESS_MSG_XPATH);
    }

    /**
     * goes back to settings from account settings
     */
    public SettingsPage goBackToSettings() {
        clickOnElementByLMB(BACK_TO_SETTINGS_BTN_XPATH);
        return SettingsPage.initSettingsPage();
    }

}