package drivers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Driver {
    // parametrized WebDriver singleton for multithreading

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver(ConfigDriver configDriver) {
        if (driver.get() == null) {
            try {
                driver.set(DriverManager.getDriver(configDriver));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            try {
                driver.set(DriverManager.getDriver(ConfigDriver.CHROME));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return driver.get();
    }


    public Driver() throws IllegalAccessError {
        throw new IllegalAccessError("Utility class");
    }

    public static void goToSite(String url) {
        driver.get().get(url);
    }

    public static void maximize() {
        driver.get().manage().window().maximize();
    }

    public static void setTimeouts() {
        driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.get().manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
    }

    public static void removeTimeouts() {
        driver.get().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        driver.get().manage().timeouts().pageLoadTimeout(0, TimeUnit.SECONDS);
        driver.get().manage().timeouts().setScriptTimeout(0, TimeUnit.SECONDS);
    }

    public static void destroy() {
        driver.get().close();
        driver.get().quit();
        driver.remove();
    }

    public static void scrollElement(WebElement element) {
        ((JavascriptExecutor) driver.get()).executeScript("arguments[0].scrollIntoView(true)", element);
    }

    public static void colorBackgroundElement(WebElement element, String color) {
        ((JavascriptExecutor) driver.get()).executeScript(
                String.format("arguments[0].style.backgroundColor = '%s'", color), element);
    }

    public static void colorElement(WebElement element, String color) {
        ((JavascriptExecutor) driver.get()).executeScript(
                String.format("arguments[0].style.color = '%s'", color), element);

    }

    public static void setElementAttributeValue(WebElement element, int number) {
        ((JavascriptExecutor) driver.get()).executeScript(
                String.format("arguments[0].setAttribute('value', %d);", number), element);

    }

}



