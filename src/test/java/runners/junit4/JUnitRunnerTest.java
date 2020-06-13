package runners.junit4;

import drivers.ConfigDriver;
import drivers.Driver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import steps.booking.BookingParisMoscowOsloSteps;


@RunWith(Suite.class)
@Suite.SuiteClasses({BookingParisMoscowOsloSteps.class})
public class JUnitRunnerTest {
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
