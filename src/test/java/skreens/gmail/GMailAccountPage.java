package skreens.gmail;

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


//    <input type="password" class="whsOnd zHQkBf" jsname="YPqjbf" autocomplete="current-password" spellcheck="false" tabindex="0" aria-label="Введите пароль" name="password" autocapitalize="off" dir="ltr" data-initial-dir="ltr" data-initial-value="">
//    <div jsname="YRMmle" class="AxOyFc snByac" aria-hidden="true">Введите пароль</div>



    public GMailAccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void setLoginGMail(String email) {
        loginGMail_ID.click();
        loginGMail_ID.clear();
        loginGMail_ID.sendKeys(email);
    }

    public void setPasswordGMail(String password){
        passwordGMail_ID.click();
        passwordGMail_ID.clear();
        passwordGMail_ID.sendKeys(password);
    }
}
