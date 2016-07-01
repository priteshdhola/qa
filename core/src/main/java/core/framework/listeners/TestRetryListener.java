package core.framework.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Created by pritesh on 6/30/16.
 */
public class TestRetryListener implements IRetryAnalyzer {
    private int count = 2;

    @Override
    public boolean retry(ITestResult result) {
        if (count > 1) { // set your count to re-run test
            count--;
            return true;
        }
        return false;
    }
}
