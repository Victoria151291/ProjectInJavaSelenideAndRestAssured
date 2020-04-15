package helpers.webDriverProviders;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static helpers.Paths.*;

public class ChromeDriverProvider implements WebDriverProvider {

    private static WebDriver chromeDriver;
    private static final String CHROME_DRIVER_PROPERTY_NAME = "webdriver.chrome.driver";

    private static void initPropertiesForChromeDriver() {
        String operSystem = System.getProperty("os.name");
        if (operSystem.contains("Windows")) {
            System.setProperty(CHROME_DRIVER_PROPERTY_NAME, PATH_TO_CHROME_DRIVER_WINDOWS);
        } else if (operSystem.contains("Linux")) {
            System.setProperty(CHROME_DRIVER_PROPERTY_NAME, PATH_TO_CHROME_DRIVER_LINUX);
        } else if (operSystem.contains("Mac OS X")) {
            System.setProperty(CHROME_DRIVER_PROPERTY_NAME, PATH_TO_CHROME_DRIVER_MAC_OS);
        }
    }

    private static ChromeOptions initChromeOptions() {
        ChromeOptions opts = new ChromeOptions();
        opts.addArguments("--incognito", "--window-size=1280,1024");
        return opts;
    }

    private static WebDriver getChromeDriver(ChromeOptions chromeOptions) {
        if (chromeDriver == null) {
            chromeDriver = new ChromeDriver(chromeOptions);
        }
        return chromeDriver;
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities capabilities) {
        initPropertiesForChromeDriver();
        return getChromeDriver(initChromeOptions());
    }
}