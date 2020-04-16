package pages;

public class ShoppingListPage extends Page {

    private final String ACCOUNT_BTN_XPATH = "//button[@data-testid='avatar-button']";
    private final String SETTINGS_BTN_XPATH = "//button[@data-testid='desktop-settings-button']";
    private final String SIGN_UP_WELCOME_MSG_XPATH = "//span[text()='Welcome! Thanks for signing up.']";
    private final String ADD_ITEM_FIELD_XPATH = "//input[@placeholder='Add item']";
    private final String SHOPPING_LIST_NAME_XPATH = "//div[@data-testid='shopping-list-name']";
    private final String TOMATOES_ITEM_XPATH = "//div[text()='Tomatoes']";
    private final String CUCUMBER_ITEM_XPATH = "//div[text()='Cucumber']";
    private final String SHOPPING_LIST_ITEM_XPATH = "//div[@data-testid='shopping-list-item']";

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

    /**
     * adds the item to the shopping list
     */
    public ShoppingListPage addItemToShoppingList() {
        selectDropDownItem(ADD_ITEM_FIELD_XPATH, TOMATOES_ITEM_XPATH);
        clickOnElementByLMB(CUCUMBER_ITEM_XPATH);
        return this;
    }

    /**
     * closes the list of items
     */
    public void closeListOfItems() {
        clickOnElementByLMB(SHOPPING_LIST_NAME_XPATH);
    }

    /**
     * deletes the item from the shopping list
     */
    public void deleteItemFromShoppingList() {
        dragAndDrop(SHOPPING_LIST_ITEM_XPATH, 200, 0);
    }

}