package uitest.home;

import core.framework.listeners.TestRetryListener;
import core.ui.home.HomePage;
import data.SearchData;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uitest.UIBaseTest;

/**
 * Created by pritesh on 6/11/16.
 */
public class HomePageTest extends UIBaseTest{
    HomePage homePage;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        super.setUp();
        homePage = new HomePage(super.getDriver());
    }

    // This will run three test cases as there are 3 different values in search tokens data provider
    @Test(timeOut = 30000,groups = {"p1", "sanity"},dataProvider = "searchTokens",dataProviderClass = SearchData.class, retryAnalyzer = TestRetryListener.class)
    public void homePageSearchTest(String searchToken) {

        homePage.searchItem(searchToken);
        super.testSleeps(1000);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        super.tearDown();
    }
}
