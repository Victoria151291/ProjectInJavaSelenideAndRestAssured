package tests.UITests.RegistrationTestsVariant2;

import UI.pages.AuthPage;
import org.testng.annotations.Test;
import testData.DataForTests;

public class RegistrationTests extends BaseTest {

    /**
     * the register (auth) method is the part of the test here
     */
    @Test(description = "Registration of a new account with changing a password")
    public void registerNewAccount() {
        AuthPage
                .initAuthPage()
                .authAndLogIn(DataForTests.initDataForTests().getRandomTestAccountEmail())
                .checkThatSignUpWelcomeMsgExists()
                .goToSettings()
                .goToAccountSettings()
                .checkPasswordDefaultValue()
                .changePassword()
                .goBackToSettings()
                .goBackToShoppingList();
    }

}