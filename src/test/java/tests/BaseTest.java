package tests;

import helpers.webDriverProviders.WebDriverFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.AccountSettingsPage;
import pages.AuthPage;
import testData.DataForTests;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Configuration.browserSize;
import static helpers.webDriverProviders.WebDriverFactory.chrome;

public class BaseTest {

    @BeforeClass
    public static void initSettings() {
        browserSize = "1280x1024";
        browser = WebDriverFactory.getWebDriver(chrome);    //type 'chrome' or 'firefox' to choose the web browser for running tests
        AuthPage
                .initAuthPage()
                .openAuthPage();
    }

    @BeforeMethod
    public void authAndLogIn() {
        AuthPage
                .initAuthPage()
                .authAndLogIn(DataForTests.initDataForTests().getRandomTestUserEmail());
    }

    @AfterClass
    public void tearDown() {
        AccountSettingsPage
                .initAccountSettingsPage()
                .deleteTestUser();
    }

}