package tests.UITests.RegistrationTestsVariant2;

import UI.pages.AuthPage;
import UI.pages.ShoppingListPage;
import helpers.webDriverProviders.WebDriverFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Configuration.browserSize;
import static helpers.webDriverProviders.WebDriverFactory.chrome;

public abstract class BaseTest {

    @BeforeSuite
    public static void initSettings() {
        browserSize = "1280x1024";
        browser = WebDriverFactory.getWebDriver(chrome);    //type 'chrome' or 'firefox' to choose the web browser for running tests
        AuthPage
                .initAuthPage()
                .openAuthPage();
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