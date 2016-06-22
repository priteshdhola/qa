package core.ui;

import core.framework.testConfig.TestConfiguration;
import core.utils.ConsoleLog;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;

/**
 * Created by pritesh on 6/11/16.
 */
public abstract class UIBasePage {
    protected WebDriver driver;
    protected WebDriverWait testWait;
    protected abstract String page();
    protected abstract void openPage();
    protected ConsoleLog consolePrint = new ConsoleLog();
    TestConfiguration testCfg = ConfigFactory.create(TestConfiguration.class);

    /**
     * Returns the server url
     * @return
     */
    public String getServerUrl() {
        return testCfg.server();
    }

    /**
     * Set's the web driver instance
     * @param driver
     */
    protected void setDriver(WebDriver driver) {
        this.driver = driver;
        testWait = new WebDriverWait(driver, 30);
    }

    /**
     * Custom setText method
     * @param element
     * @param text
     */
    protected void setText(WebElement element, String text) {
        try {
            testWait.until(isElementDisplayed(element));
            element.clear();
            element.sendKeys(text);
            assertEquals(element.getAttribute("value"), text);
            consolePrint.appendInfo("Set text as: " + text);
        } catch (NoSuchElementException e) {
            consolePrint.appendErrorWithFail("Unable to find element for input text: '" + text + "'.", e);
        } catch (AssertionError e1) {
            consolePrint.appendErrorWithFail("Text was not properly set.", e1);
        }
    }

    /**
     * This one waits for a element to be displayed for a given amount of time.
     * @param element
     * @return
     */
    protected ExpectedCondition<Boolean> isElementDisplayed(final WebElement element) {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return element.isDisplayed();
                } catch (NoSuchElementException e) {
                    // Returns false because the element is not present in DOM. The
                    // try block checks if the element is present but is invisible.
                    return false;
                } catch (StaleElementReferenceException e) {
                    // Returns false because stale element reference implies that element
                    // is no longer visible.
                    return false;
                }
            }

            @Override
            public String toString() {
                return "element to be visible: " + element;
            }
        };
    }
}
