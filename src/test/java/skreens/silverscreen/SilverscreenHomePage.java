package skreens.silverscreen;

import drivers.Driver;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import skreens.AbstractPage;

import java.security.Key;
import java.security.PublicKey;
import java.util.List;

public class SilverscreenHomePage extends AbstractPage {

    @FindBy(css = "div[class^='sc-hcmgZB']")
    public WebElement search_CSS;
    @FindBy(css = "div[class^='sc-hgRTRy'] input")
    private WebElement searchWord_CSS;
    @FindBy(css = "div[class^='sc-hpAzQi']")
    public WebElement listFilms_CSS;
    @FindBy(how = How.CSS, using = "div[class^='sc-iAjrqK'] a span") //Апгрейд
    private List<WebElement> resultSearchFilmName_CSS;
    @FindBy(css = "div[class^='sc-fyjhYU']")
    public WebElement loginPrivileges_CSS;
    @FindBy(css = "input[type^='email']")
    public WebElement login_CSS;
    @FindBy(css = "input[type^='password']")
    public WebElement password_CSS;
    @FindBy(css = "div[class^='sc-imABML'] button[class$='dfaqkm']")
    public WebElement buttonSignIn_CSS;
    @FindBy(css = "div[class^='sc-fyjhYU'] span")
    public WebElement level_CSS;
    @FindBy(css = "li[class] a[href='/']")
    public WebElement buttonExit_CSS;
    @FindBy(xpath = "//*[contains(text(),'Необходимо заполнить поле')]")
    public WebElement massage_XPATH;
    @FindBy(xpath = "//*[contains(text(),'Неверный пароль')]")
    public WebElement massagePassword_XPATH;


    private Actions actions = new Actions(Driver.getDriver());

    private static final Logger LOGGER = LogManager.getLogger(SilverscreenHomePage.class);

    public SilverscreenHomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void setWordInSearch(String word){
        searchWord_CSS.clear();
        searchWord_CSS.sendKeys(word);
        actions.moveToElement(searchWord_CSS).sendKeys(Keys.ENTER).build().perform();
        LOGGER.debug("Entering data to search.(searchWord_CSS)");

    }
    public boolean checkWordInList(String searchWord) {
        LOGGER.debug("Checking the presence of the word in the element.");
        for (int i=0; i<resultSearchFilmName_CSS.size(); i++) {
            if (false == resultSearchFilmName_CSS.get(i).getText().toLowerCase().contains(searchWord.toLowerCase())){
                return false;
            }
        }
        return true;
    }
    public void setLoginPassword(String login, String password) throws InterruptedException {
        actions.moveToElement(loginPrivileges_CSS).sendKeys(Keys.ENTER).build().perform();
        login_CSS.clear();
        login_CSS.sendKeys(login);
        password_CSS.clear();
        password_CSS.sendKeys(password);
        actions.moveToElement(buttonSignIn_CSS).sendKeys(Keys.ENTER).build().perform();
        LOGGER.debug("Filling in the email and password fields to enter the account.(login_CSS, password_CSS, buttonSignIn_CSS)");
    }

    public boolean checkLevel(String level){
        LOGGER.debug("Comparison of account level with a given.(level_CSS)");
        String[] levelParam = level_CSS.getText().split(" ");
        if (!levelParam[2].toLowerCase().contains(level.toLowerCase())){
            return false;
        } else {
            return true;
        }
    }

    public void logOutOfAccount (){
        LOGGER.debug("log out of account.(buttonExit_CSS)");
        actions.moveToElement(buttonExit_CSS).sendKeys(Keys.ENTER).build().perform();
    }

}
