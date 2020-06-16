package steps.base_steps;

import drivers.ConfigDriver;
import drivers.Driver;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class InitCloseDriverSteps {
    private static final Logger LOGGER = LogManager.getLogger(BookingLoginPasswordSteps.class);
    @BeforeClass
    public static void initDriver(){
        LOGGER.info("---------------------------Test started---------------------------");
        Driver.initDriver(ConfigDriver.CHROME);
        Driver.maximize();
        Driver.setTimeouts();

    }
    @AfterClass
    public static void closeDriver(){
        Driver.destroy();
        LOGGER.info("---------------------------Test finished--------------------------");
    }
}
