package drivers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import settings.ConfigProperties;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver;

    public Driver() throws IllegalAccessError{
        throw new IllegalAccessError("Utility class");
    }

    public static void initDriver(ConfigDriver configDriver) {
        if (driver==null){
            driver = DriverManager.getDriver(configDriver);
        }
    }
    public static WebDriver getDriver(){
        if (driver==null){
            driver = DriverManager.getDriver(ConfigDriver.CHROME);
        }
        return driver;
    }
    public static void goToSite (String url) {
        //driver.navigate().to(url);
        driver.get(url);
    }

    public static void maximize() {
        driver.manage().window().maximize();
    }

    public static void setTimeouts() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
    }

    public static void removeTimeouts() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(0, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(0, TimeUnit.SECONDS);
    }

    public static void destroy(){
        driver.close();
        driver.quit();
    }

    public static void scrollElement(WebElement element){
         ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", element);
    }

    public static void colorBackgroundElement(WebElement element, String color){
        ((JavascriptExecutor)driver).executeScript(
                String.format("arguments[0].style.backgroundColor = '%s'",color), element);
    }
    public static void colorElement(WebElement element, String color){
        ((JavascriptExecutor)driver).executeScript(
                String.format("arguments[0].style.color = '%s'",color), element);

    }

    public static void setElementAttributeValue(WebElement element, int number){
        ((JavascriptExecutor)driver).executeScript(
                String.format("arguments[0].setAttribute('value', %d);", number), element);

    }

    public static String getElementAttributeHref(WebElement element){
        return (String) ((JavascriptExecutor)driver).executeScript(
                "return arguments[0].getAttribute('href')", element);


    }

    public static void clickElement(WebElement element){
        ((JavascriptExecutor)driver).executeScript(
                String.format("arguments[0].click()"), element);

    }
/*
     // parametrized WebDriver singleton for multithreading
     public class Driver {
     private static ThreadLocal <WebDriver> webDriver = new ThreadLocal<>();
     public static WebDriver getDriver(){
        if (webDriver.get() == null){
            webDriver.set(DriverManager.getDriver(Config.CHROME));
        }
        return webDriver.get();
     }
     }

*/
}
