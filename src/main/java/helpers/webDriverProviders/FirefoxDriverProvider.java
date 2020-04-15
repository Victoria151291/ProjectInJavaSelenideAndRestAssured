package helpers.webDriverProviders;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static helpers.Paths.*;

public class FirefoxDriverProvider implements WebDriverProvider {

    private static WebDriver firefoxDriver;
    private static final String FIREFOX_DRIVER_PROPERTY_NAME = "webdriver.gecko.driver";

    private static void initPropertiesForFireFoxDriver() {
        String operSystem = System.getProperty("os.name");
        if (operSystem.contains("Windows")) {
            System.setProperty(FIREFOX_DRIVER_PROPERTY_NAME, PATH_TO_FIREFOX_DRIVER_WINDOWS);
        } else if (operSystem.contains("Linux")) {
            System.setProperty(FIREFOX_DRIVER_PROPERTY_NAME, PATH_TO_FIREFOX_DRIVER_LINUX);
        } else if (operSystem.contains("Mac OS X")) {
            System.setProperty(FIREFOX_DRIVER_PROPERTY_NAME, PATH_TO_FIREFOX_DRIVER_MAC_OS);
        }
    }

    private static FirefoxOptions initFireFoxOptions() {
        FirefoxOptions opts = new FirefoxOptions();
        opts.addArguments("-private", "--window-size=1280,1024");
        return opts;
    }

    private static WebDriver getFireFoxDriver(FirefoxOptions firefoxOptions) {
        if (firefoxDriver == null) {
            firefoxDriver = new FirefoxDriver(firefoxOptions);
        }
        return firefoxDriver;
    }


    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        initPropertiesForFireFoxDriver();
        return getFireFoxDriver(initFireFoxOptions());
    }
}
