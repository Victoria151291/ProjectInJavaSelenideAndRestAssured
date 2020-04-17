package tests.UITests.RegistrationTestsVariant1;

import org.testng.annotations.Test;
import UI.pages.ShoppingListPage;

public class RegistrationTests extends BaseTest {

    /**
     * the register (auth) method is not the part of the test here
     */
    @Test(description = "Registration of a new account with changing a password")
    public void registerNewAccountAndChangePassword() {
        ShoppingListPage
                .initShoppingListPage()
                .checkThatSignUpWelcomeMsgExists()
                .goToSettings()
                .goToAccountSettings()
                .checkPasswordDefaultValue()
                .changePassword()
                .goBackToSettings()
                .goBackToShoppingList();
    }

}