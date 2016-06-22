package uitest;

import core.framework.enums.BrowserType;
import core.framework.testConfig.TestConfiguration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by pritesh on 6/16/16.
 */
public abstract class UIBaseTest {
    WebDriver driver;
    String serverUrl;
    BrowserType browserType;
    TestConfiguration testCfg;

    /**
     * Sets the the base test byt injecting configuration
     */
    public UIBaseTest() {
        // Special libray named "OWNER" is used to inject configuration
        // http://owner.aeonbits.org/docs/importing-properties/
        testCfg = ConfigFactory.create(TestConfiguration.class);

        this.serverUrl = testCfg.server();
        this.browserType = testCfg.browser();
    }

    /**
     * Sets up every thing for the test run
     */
    public void setUp() {
        setupDriver(testCfg.server());
    }

    /**
     * Tear down everything after the test run
     */
    public void tearDown() {
        driver.quit();
    }

    /**
     * Returns the current web driver object
     * @return
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Sets up the driver instance
     * @param serverUrl
     */
    public void setupDriver(String serverUrl) {
        DesiredCapabilities capability = DesiredCapabilities.firefox();
        if (testCfg.userGrid()) {
            URL u = null;
            try {
                u = new URL("http://localhost:4444/wd/hub");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            driver = new RemoteWebDriver(u, capability);
        } else {
            System.setProperty("webdriver.chrome.driver", "/work/automation/selenium/drivers/chromedriver");
            driver = new ChromeDriver();
        }
    }
}
