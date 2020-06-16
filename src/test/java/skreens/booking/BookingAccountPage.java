package skreens.booking;

import drivers.Driver;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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
    @FindBy(id = "password")
    private WebElement password_ID;
    @FindBy(id = "confirmed_password")
    private WebElement confirmedPassword_ID;

    private static final Logger LOGGER = LogManager.getLogger(BookingAccountPage.class);


    public BookingAccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void setEmailAddressCreate(String email) throws InterruptedException {
        emailAddress_ID.clear();
        emailAddress_ID.sendKeys(email);
        button_XPATH.click();
        LOGGER.debug("Filling in the email field when creating an account.(emailAddress_ID)");
    }

    public void setPasswordCreate(String password){
        password_ID.clear();
        password_ID.sendKeys(password);
        confirmedPassword_ID.clear();
        confirmedPassword_ID.sendKeys(password);
        button_XPATH.click();
        LOGGER.debug("Filling in the password fields and confirmed password to create an account.(password_ID, confirmedPassword_ID)");
    }

    public void setCurrentLoginPassword(String email, String password){
        Driver.setTimeouts();
        email_ID.clear();
        email_ID.sendKeys(email);
        button_XPATH.click();
        password_ID.clear();
        password_ID.sendKeys(password);
        button_XPATH.click();
        LOGGER.debug("Filling in the email and password fields to enter the account.(email_ID, password_ID)");
    }
}
