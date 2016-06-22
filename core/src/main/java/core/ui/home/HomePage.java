package core.ui.home;

import core.ui.UIBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by pritesh on 6/11/16.
 */
public class HomePage extends UIBasePage {
    private WebDriver driver;

    /**
     * Sets up the local and base page's driver instance
     * Also initialize page elements
     * @param driver
     */
    public HomePage(WebDriver driver) {
        this.driver=driver;
        super.setDriver(driver);
        PageFactory.initElements(driver, this);
    }

    // Page url
    public static final String HOME_PAGE = "/";

    // Form Elements
    @FindBy(name = "q")
    WebElement BOX_SEARCH;

    /**
     * This returns the page url. It's a relative url path from the home page
     * @return
     */
    @Override
    protected String page() {
        return HOME_PAGE;
    }

    /**
     * This opens the page. Usually this should be used if you starting your test from this page
     */
    @Override
    public void openPage() {
        driver.get("http://" + super.getServerUrl() + page());
    }

    /**
     * Search for a particular token from the page
     * @param searchString
     */
    public void searchItem(String searchString) {
        consolePrint.appendInfo("Opening home page");
        openPage();

        consolePrint.appendInfo("Searching for :" + searchString);
        setText(BOX_SEARCH,searchString);

        consolePrint.appendInfo("Submitting the form");
        BOX_SEARCH.submit();
        consolePrint.appendInfo("Test Complete");
    }
}
