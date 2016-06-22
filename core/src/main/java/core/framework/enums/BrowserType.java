package core.framework.enums;

/**
 * Created by pritesh on 6/16/16.
 */
public enum BrowserType {
    firefox("firefox"),
    googlechrome("googlechrome"),
    safari("safari");

    private final String browser;

    BrowserType(String browser) {
        this.browser = browser;
    }

    public String getBrowserName() {
        return browser;
    }
}
