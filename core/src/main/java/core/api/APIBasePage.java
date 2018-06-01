package core.api;

import core.framework.testConfig.TestConfiguration;
import org.aeonbits.owner.ConfigFactory;

public abstract class APIBasePage {
    private TestConfiguration testCfg = ConfigFactory.create(TestConfiguration.class);

    protected String getApiHostUrl() {
        return "https://" + testCfg.server();
    }
    protected boolean isDebug() {
        return testCfg.getDebug();
    }
}
