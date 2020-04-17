package tests.APITests;

import API.ShoppingListAPI;
import org.testng.annotations.Test;

public class ShoppingListAPITests extends BaseTest  {

    /**
     * this test creates the shopping list, adds the item to this list and deletes the item
     */
    @Test
    public void ShoppingListTest() {
        ShoppingListAPI
                .initShoppingListAPI()
                .createNewListOfItems(getAccessToken())
                .checkThatCreatedListExists(getAccessToken())
                .addItemToList(getAccessToken())
                .checkThatCreatedItemExists(getAccessToken())
                .deleteItem(getAccessToken())
                .checkThatListIsEmpty(getAccessToken());
    }
}