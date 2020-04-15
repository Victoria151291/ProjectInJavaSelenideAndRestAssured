package tests.UITests;

import org.testng.annotations.Test;
import pages.ShoppingListPage;
import tests.BaseTest;

public class RegistrationTests extends BaseTest {

    @Test(description = "Registration of a new test user")
    public void registerNewTestUser() {
        ShoppingListPage
                .initShoppingListPage()
                .checkThatSignUpWelcomeMsgExists()
                .goToSettings()
                .goToAccountSettings()
                .checkPasswordDefaultValue()
                .changePassword();
    }

}