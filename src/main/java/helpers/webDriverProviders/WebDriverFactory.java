package helpers.webDriverProviders;

public class WebDriverFactory {

    public static final String chrome = "chrome";
    public static final String firefox = "firefox";

    public static String getWebDriver(String browserName) {
        if (browserName.equals(chrome)) {
            return ChromeDriverProvider.class.getName();
        } else if (browserName.equals(firefox)) {
            return FirefoxDriverProvider.class.getName();
        } else {
            return "\nSet the Chrome web browser or the Firefox web browser for running tests\n";
        }
    }

}