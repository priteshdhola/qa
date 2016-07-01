package data;

import org.testng.annotations.DataProvider;

/**
 * Created by pritesh on 6/30/16.
 */
public class SearchData {
    @DataProvider(name = "searchTokens")
    public static Object[][] includeOccasion() {
        return new Object[][]{
                {"brexit"},
                {"apple"},
                {"nba"}
        };
    }
}
