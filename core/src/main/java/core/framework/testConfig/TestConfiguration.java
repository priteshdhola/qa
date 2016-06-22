package core.framework.testConfig;

import core.framework.enums.BrowserType;
import org.aeonbits.owner.Config;

/**
 * Created by pritesh on 6/16/16.
 * This is the core logic for importing configuration from a property file
 */
@Config.Sources({"file:ui/src/resources/FrontEndConfig.properties"})
public interface TestConfiguration extends Config{
    // Make sure to match the method name with the actual key name from property file
    String server(); // this matches with property "server=www.google.com"

    @DefaultValue("googlechrome") // This is how specify default value for a property
    BrowserType browser();

    @Key("use_grid") // This is how you bind a differently named property name and a variable
    boolean userGrid();
}
