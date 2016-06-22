package core.utils;

import org.testng.Assert;

/**
 * Created by pritesh on 6/20/16.
 */
public class ConsoleLog {
    StringBuffer sBuffer;
    boolean print = true;

    public ConsoleLog() {
        sBuffer = new StringBuffer();
    }

    /**
     * Log the info messages
     * @param str
     * @return
     */
    public ConsoleLog appendInfo(String str) {
        sBuffer.append(str);
        if (print) {
            this.write();
        }
        return this;
    }

    /**
     * Log the test failure with stack trace
     * @param str
     * @param th
     */
    public void appendErrorWithFail(String str, Throwable th) {
        String fullError = str + " - " + th.getLocalizedMessage();
        Assert.fail(fullError);
    }

    /**
     * Write the buffer to standard out
     */
    public void write() {
        if (sBuffer != null && sBuffer.length() > 0) {
            System.out.println(sBuffer.toString());
            sBuffer = new StringBuffer();
        }
    }
}
