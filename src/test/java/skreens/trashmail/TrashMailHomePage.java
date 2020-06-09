package skreens.trashmail;

import drivers.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import skreens.AbstractPage;

public class TrashMailHomePage extends AbstractPage {
    @FindBy(xpath = "//*[@id='tab-mob-create']/li[2]/a")
    public WebElement addressManagerTab_XPATH;
    @FindBy(xpath = "//*[@id='tab-mob-create']/li[3]/a")
    public WebElement newUserTab_XPATH;
    @FindBy(xpath = "//div[@class='alert ng-scope top am-fade alert-info']")
    private WebElement registrationMessage_XPATH;



    private TrashMailAddressManagerBlock addressManager = new TrashMailAddressManagerBlock(Driver.getDriver());
    private TrashMailNewUserBlock newUser = new TrashMailNewUserBlock(Driver.getDriver());

    public TrashMailHomePage(WebDriver webDriver) {
        super(webDriver);
    }
    public boolean registrationTextMessageIsDisplayed() {
        if(registrationMessage_XPATH.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public void createNewUser(String user, String password, String email) throws InterruptedException {
        newUserTab_XPATH.click();
        newUser.setNewUserLoginPasswordEmail(user, password, email);
        newUser.registerButton_XPATH.click();
    }

    public void sendInTrashMail(String user, String password){
        addressManagerTab_XPATH.click();
        addressManager.setAddressManagerLoginPassword(user, password);
        addressManager.singInButton_XPATH.click();
    }
//
//    public void createDisposableEmailAddress (){
//        quickTab_XPATH.click();
//
//    }

}
