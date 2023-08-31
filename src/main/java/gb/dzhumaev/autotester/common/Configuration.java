package gb.dzhumaev.autotester.common;

import org.openqa.selenium.Point;

public class Configuration {
    public static final String PLATFORM_AND_BROWSER = "WINDOWS_FIREFOX";
    public static final Boolean CLEAR_COOKIES = true;
    public static final Point WINDOW_POSITION = new Point(1366, 0);
    public static final int EXPLICIT_WAIT = 10;
    public static final int OPEN_PAGE_TIMEOUT_MS = 3000;
}
