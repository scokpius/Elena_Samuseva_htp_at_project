package steps;

import drivers.ConfigDriver;
import drivers.Driver;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class BaseSteps {
    @BeforeClass
    public static void initDriver(){
        Driver.initDriver(ConfigDriver.CHROME);
        Driver.maximize();
        Driver.setTimeouts();

    }
    @AfterClass
    public static void closeDriver(){
        Driver.destroy();
    }
}
