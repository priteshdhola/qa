package uitest.home;

import company.ui.home.HomePage;
import org.testng.annotations.Test;

/**
 * Created by pritesh on 6/11/16.
 */
public class HomePageTest {
    HomePage homePage = new HomePage();

    @Test
    public void homePageTest() {
        homePage.homePageSetup();
    }
}
