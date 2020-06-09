package skreens.trashmail;

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

    }

}
