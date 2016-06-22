package core.framework.testConfig;

import junitx.util.PropertyManager;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by pritesh on 6/16/16.
 * This is not used right now. But it will be useful when jenkins is used to run CI
 */
public class PropertyFileParser {
    public HashMap<String, String> testConfig = new HashMap<String, String>();
    public HashMap<String, String> sysEnvConfig = new HashMap<String, String>();
    public HashMap<String, String> sysPropConfig = new HashMap<String, String>();

    List<String> parameters = Arrays.asList(
            "GRID_SERVER",
            "LOG_RESULTS",
            "TEST_PLAN_ID",
            "BROWSER",
            "SERVER",
            "USE_GRID",
            "API_SERVER",
            "DB_SERVER",
            "DB_PASSWORD",
            "DB_USERNAME",
            "DEBUG",
            "TIMEOUT",
            "LOCALE",
            "IPA_FILE_NAME",
            "APK_FILE_NAME",
            "UDID",
            "DEVICE_NAME",
            "DEVICE_OS"
    );

    /**
     * Reads the property file first
     * 1. Creates a map of properties read from the property file which is passed by maven using.
     *    For example : -DPropertyManager.file=src/test/resources/local.properties
     * 2. Creates a map of properties set by CI system like jenkins
     * 3. Creates a map of properties passed via maven commands. These are usually used in the test and keeps changing.
     *    For example : api versions, locales,etc
     */
    public PropertyFileParser() {
        for (String param : parameters) {
            // Parameters set by the local.properties file
            try {
                if (PropertyManager.getProperty(param) != null)
                    testConfig.put(param, PropertyManager.getProperty(param));
            }catch(NullPointerException ignored){
                //Do nothing
            }

            // Parameters set by CI system like jenkins. They usually show up as env variables
            if (System.getenv(param) != null)
                sysEnvConfig.put(param, System.getenv(param));

            // Other variables which can be passed in via Maven command line. EXAMPLE: -DAPI_VERSION=v5
            if (System.getProperty(param) != null)
                sysPropConfig.put(param, System.getProperty(param));
        }
    }

    /**
     * Method returns the current env conf map
     *
     * @return
     */
    public HashMap<String, String> getTestConfig() {
        return testConfig;
    }

    /**
     * Returns System properties
     * @return
     */
    public HashMap<String, String> getSystempPropConfig() {
        return sysPropConfig;
    }

    /**
     * This Returns back a entry from the environment configuration
     *
     * @param key
     * @return
     */
    public String getTestConfigByName(String key) {
        try {
            if (testConfig.containsKey(key))
                return testConfig.get(key);
        } catch (Exception e) {
            System.err.println("Key does not exist");
            System.err.println(e.getMessage());
        }
        return null;
    }

    /**
     * This Returns back a entry from the SYSTEM environment configuration
     *
     * @param key
     * @return
     */
    public String getSysEnvConfigByName(String key) {
        try {
            if (sysEnvConfig.containsKey(key))
                return sysEnvConfig.get(key);
        } catch (Exception e) {
            System.err.println("Key does not exist");
            System.err.println(e.getMessage());
        }
        return null;
    }
}
