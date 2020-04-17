package tests.UITests.RegistrationTestsVariant1;

import helpers.webDriverProviders.WebDriverFactory;
import org.testng.annotations.*;
import UI.pages.AuthPage;
import UI.pages.ShoppingListPage;
import testData.DataForTests;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Configuration.browserSize;
import static helpers.webDriverProviders.WebDriverFactory.chrome;

public class BaseTest {

    @BeforeSuite
    public static void initSettings() {
        browserSize = "1280x1024";
        browser = WebDriverFactory.getWebDriver(chrome);    //type 'chrome' or 'firefox' to choose the web browser for running tests
        AuthPage
                .initAuthPage()
                .openAuthPage();
    }

    /**
     * this part of registration of an account is in @BeforeClass because registration is implemented in the same way as authorization
     */
    @BeforeClass
    public void authAndLogIn() {
        AuthPage
                .initAuthPage()
                .authAndLogIn(DataForTests.initDataForTests().getRandomTestAccountEmail());
    }

    /**
     * deletes test data after running main tests
     */
    @AfterSuite
    public void tearDown() {
        ShoppingListPage
                .initShoppingListPage()
                .goToSettings()
                .goToAccountSettings()
                .deleteTestAccount();
    }

}