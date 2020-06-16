package skreens.trashmail;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import skreens.AbstractPage;

public class TrashMailAddressManagerBlock extends AbstractPage{

    @FindBy (xpath = "//*[@id='tab-mob-manager']/form/div[1]/input")
    private WebElement userName_XPATH;
    @FindBy (xpath = "//*[@id='tab-mob-manager']/form/div[2]/input")
    private WebElement password_XPATH;
    @FindBy (xpath = "//*[@id='tab-mob-manager']//div[4]/button")
    public WebElement singInButton_XPATH;

    private static final Logger LOGGER = LogManager.getLogger(TrashMailAddressManagerBlock.class);

    public TrashMailAddressManagerBlock(WebDriver webDriver) {
        super(webDriver);
    }

    public void setAddressManagerLoginPassword (String user, String password){
        userName_XPATH.click();
        userName_XPATH.sendKeys(user);
        password_XPATH.click();
        password_XPATH.sendKeys(password);
        LOGGER.debug("Filling in the user and password fields to enter the account.(userName_XPATH, password_XPATH)");
    }


}
