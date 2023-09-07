package gb.dzhumaev.autotester;

import java.time.Duration;

public class Configuration {
    public static final String BROWSER_NAME = "chrome";
    public static final Duration EXPLICIT_TIMEOUT = Duration.ofSeconds(5);
    public static final Duration TIMEOUT_AFTER_ACTION = Duration.ofSeconds(1);
}
