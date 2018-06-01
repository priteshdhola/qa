package core.framework.testConfig;

import core.framework.enums.BrowserType;
import org.aeonbits.owner.Config;

@Config.Sources({"file:ui/src/resources/frontEndConfig.properties"})
public interface TestConfiguration extends Config{
    // Make sure to match the method name with the actual key name from property file
    @DefaultValue("www.google.com")
    String server(); // this matches with property "server=www.google.com"

    @DefaultValue("firefox") // This is how specify default value for a property
    BrowserType browser();

    @Key("use_grid") // This is how you bind a differently named property name and a variable
    @DefaultValue("true")
    boolean userGrid();

    @DefaultValue("apiServer") // This is how specify default value for a property
    String getApiServer();

    @DefaultValue("debug") // This is how specify default value for a property
    boolean getDebug();

}
