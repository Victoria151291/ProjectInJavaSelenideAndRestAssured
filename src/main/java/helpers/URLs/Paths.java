package helpers.URLs;

public class Paths {

    /**
     * paths to web drivers files
     */
    public static final String PATH_TO_CHROME_DRIVER_WINDOWS = "src/test/resources/drivers/windows/chromedriver.exe";
    public static final String PATH_TO_CHROME_DRIVER_LINUX = "src/test/resources/drivers/linux/chromedriver";
    public static final String PATH_TO_CHROME_DRIVER_MAC_OS = "src/test/resources/drivers/macOS/chromedriver";

    public static final String PATH_TO_FIREFOX_DRIVER_WINDOWS = "src/test/resources/drivers/windows/geckodriver.exe";
    public static final String PATH_TO_FIREFOX_DRIVER_LINUX = "src/test/resources/drivers/linux/geckodriver";
    public static final String PATH_TO_FIREFOX_DRIVER_MAC_OS = "src/test/resources/drivers/macOS/geckodriver";

    /**
     * endpoints
     */
    public static final String CREATE_BEARER_TOKEN_ENDPOINT = "/api/graph/auth/anonymous/create";
    public static final String QUICK_AUTH_ENDPOINT = "/auth/create/quick";
    public static final String LOGIN_ENDPOINT = "/auth/login";
    public static final String WORK_WITH_LIST_ENDPOINT = "/api/graph/v1beta/lists";
    public static final String WORK_WITH_ITEMS_ENDPOINT = "/api/graph/v1beta/{list_id}/items";
    public static final String GET_LIST_INFO_ENDPOINT = "/api/graph/v1beta/{list_id}";

}