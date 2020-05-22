package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    /**
     * Method selects which driver will be connected and returns it.
     * @param configDriver determines the name of the driver
     */
    public static WebDriver getDriver(ConfigDriver configDriver) {

        switch (configDriver){
            case CHROME:
                return getChromeDriver();
            case FIREFOX:
                return getFirefoxDriver();
            default:
                throw null;

        }

    }

    private static WebDriver getFirefoxDriver() {
        return new FirefoxDriver();
    }

    private static WebDriver getChromeDriver() {
        return new ChromeDriver();
    }


}
