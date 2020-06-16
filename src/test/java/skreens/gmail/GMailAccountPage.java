package skreens.gmail;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import skreens.AbstractPage;

public class GMailAccountPage extends AbstractPage {
    @FindBy(id = "identifierId")
    private WebElement loginGMail_ID;
    @FindBy (id = "identifierNext")
    public WebElement buttonLogin_ID;
    @FindBy(xpath  = "//*[@autocomplete='current-password']")
    private WebElement passwordGMail_ID;
    @FindBy (id = "passwordNext")
    public WebElement buttonPassword_ID;

    private static final Logger LOGGER = LogManager.getLogger(GMailAccountPage.class);

    public GMailAccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void setLoginGMail(String email) {
        loginGMail_ID.click();
        loginGMail_ID.clear();
        loginGMail_ID.sendKeys(email);
        LOGGER.debug("Filling in the login field to enter the account.(loginGMail_ID)");
    }

    public void setPasswordGMail(String password){
        passwordGMail_ID.click();
        passwordGMail_ID.clear();
        passwordGMail_ID.sendKeys(password);
        LOGGER.debug("Filling in the password field to enter the account.(loginGMail_ID)");
    }
}
