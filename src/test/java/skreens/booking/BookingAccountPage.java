package skreens.booking;

import drivers.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import skreens.AbstractPage;

public class BookingAccountPage extends AbstractPage {
    @FindBy(id = "login_name_register")     // create account
    private WebElement emailAddress_ID;
    @FindBy(id = "username")               // current account
    private WebElement email_ID;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement button_XPATH;
//    private WebElement buttonGetStarted_XPATH;
    @FindBy(id = "password")
    private WebElement password_ID;
    @FindBy(id = "confirmed_password")
    private WebElement confirmedPassword_ID;


    public BookingAccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void setEmailAddressCreate(String email) throws InterruptedException {
        emailAddress_ID.clear();
        emailAddress_ID.sendKeys(email);
        button_XPATH.click();
    }

    public void setPasswordCreate(String password){
        password_ID.clear();
        password_ID.sendKeys(password);
        confirmedPassword_ID.clear();
        confirmedPassword_ID.sendKeys(password);
        button_XPATH.click();
    }

    public void setCurrentLoginPassword(String email, String password){
        Driver.setTimeouts();
        email_ID.clear();
        email_ID.sendKeys(email);
        button_XPATH.click();
     //   Driver.setTimeouts();
        password_ID.clear();
        password_ID.sendKeys(password);
        button_XPATH.click();
    }
}
