package core.framework.listeners;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

/**
 * Logger class
 */
public class testResultsListener extends TestListenerAdapter {
    private int m_count = 0;

    @Override
    public void onTestFailure(ITestResult tr) {
        log(tr.getName()+ " -- Test failed\n");
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        log(tr.getName()+ " -- Test skipped\n");
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        log(tr.getName()+ " -- Test passed\n");
    }

    private void log(String string) {
        System.out.print(string);
        if (++m_count % 40 == 0) {
            System.out.println();
        }
    }

}
