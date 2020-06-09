package skreens.trashmail;

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

    public TrashMailAddressManagerBlock(WebDriver webDriver) {
        super(webDriver);
    }

    public void setAddressManagerLoginPassword (String user, String password){
        userName_XPATH.click();
        userName_XPATH.sendKeys(user);
        password_XPATH.click();
        password_XPATH.sendKeys(password);
    }


}
