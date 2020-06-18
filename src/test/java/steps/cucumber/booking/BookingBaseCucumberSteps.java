package steps.cucumber.booking;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import drivers.ConfigDriver;
import drivers.Driver;

import java.io.IOException;

public class BookingBaseCucumberSteps {
    @Before
    public void initDriver() throws IOException {
        Driver.initDriver(ConfigDriver.CHROME);
        Driver.maximize();
        Driver.setTimeouts();
    }
    @After
    public void finished() {
        Driver.destroy();

    }
}
