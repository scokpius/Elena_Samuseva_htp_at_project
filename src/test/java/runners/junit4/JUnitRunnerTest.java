package runners.junit4;

import drivers.ConfigDriver;
import drivers.Driver;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import steps.booking.BookingCreateNewUserSteps;
import steps.booking.BookingFavoriteHotelsSelectionSteps;
import steps.booking.BookingHeaderElementsSteps;
import steps.booking.BookingParisMoscowOsloSteps;


@RunWith(Suite.class)
@Suite.SuiteClasses({BookingParisMoscowOsloSteps.class, BookingCreateNewUserSteps.class,
                        BookingFavoriteHotelsSelectionSteps.class, BookingHeaderElementsSteps.class})
public class JUnitRunnerTest {

  //  private static final Logger LOGGER = LogManager.getLogger(JUnitRunnerBookingTest.class);
    @BeforeClass
    public static void initDriver(){
//        LOGGER.info("---------------------------Started all test---------------------------");
        Driver.initDriver(ConfigDriver.CHROME);
        Driver.maximize();
        Driver.setTimeouts();
    }
    @AfterClass
    public static void closeDriver(){
        Driver.destroy();
//        LOGGER.info("---------------------------Finished all test---------------------------");
    }
}
