package uitest.home;

import core.ui.home.HomePage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uitest.UIBaseTest;

/**
 * Created by pritesh on 6/11/16.
 */
public class HomePageTest extends UIBaseTest{
    HomePage homePage;

    @BeforeClass
    public void setup() {
        super.setUp();
        homePage = new HomePage(super.getDriver());
    }

    @Test(timeOut = 30000,groups = {"p1", "sanity"})
    public void homePageSearchTest() {

        homePage.searchItem("chicken");
    }

    @AfterClass
    public void tearDown() {
        super.tearDown();
    }
}
