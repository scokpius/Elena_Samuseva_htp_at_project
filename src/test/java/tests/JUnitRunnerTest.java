package tests;

import drivers.ConfigDriver;
import drivers.Driver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import steps.BookingMoscowSteps;
import steps.BookingOsloSteps;
import steps.BookingParisSteps;


@RunWith(Suite.class)
@Suite.SuiteClasses({BookingParisSteps.class, BookingOsloSteps.class, BookingMoscowSteps.class})
public class JUnitRunnerTest {
    @BeforeClass
    public static void initDriver(){
        Driver.initDriver(ConfigDriver.CHROME);
        Driver.maximize();
        Driver.setTimeouts();
    }
    @AfterClass
    public static void closeDriver(){
        Driver.destroy();}
}
