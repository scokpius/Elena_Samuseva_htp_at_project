package skreens.trashmail;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import skreens.AbstractPage;


public class TrashMailNewUserBlock extends AbstractPage {

    @FindBy (xpath = "//*[@id='tab-mob-register']/form/div[1]/input")
    private WebElement userName_XPATH;
    @FindBy (xpath = "//*[@id='tab-mob-register']/form/div[2]/input")
    private WebElement password_XPATH;
    @FindBy (xpath = "//*[@id='tab-mob-register']/form/div[3]/input")
    private WebElement confirmPassword_XPATH;
    @FindBy (xpath = "//*[@id='tab-mob-register']/form/div[4]/input")
    private WebElement realEmail_XPATH;
    @FindBy (xpath = "//*[@id='tab-mob-register']//button")
    public WebElement registerButton_XPATH;

    private static final Logger LOGGER = LogManager.getLogger(TrashMailNewUserBlock.class);

    public TrashMailNewUserBlock(WebDriver webDriver) {
        super(webDriver);
    }

    public void setNewUserLoginPasswordEmail(String user, String password, String email){
        userName_XPATH.click();
        userName_XPATH.sendKeys(user);
        password_XPATH.click();
        password_XPATH.sendKeys(password);
        confirmPassword_XPATH.click();
        confirmPassword_XPATH.sendKeys(password);
        realEmail_XPATH.click();
        realEmail_XPATH.sendKeys(email);
        LOGGER.debug("Filling in the username fields, password, confirmed password and real email to create an account.(userName_XPATH, password_XPATH, confirmPassword_XPATH, realEmail_XPATH)");
    }

}
