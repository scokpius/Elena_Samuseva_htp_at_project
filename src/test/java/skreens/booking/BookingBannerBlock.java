package skreens.booking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import skreens.AbstractPage;

public class BookingBannerBlock extends AbstractPage {
    @FindBy(id = "top")
    public WebElement blueBannerFirst_ID;
    @FindBy(id = "logo_no_globe_new_logo")
    public WebElement stringBookingCom_ID;
    @FindBy(xpath = "//*[@data-title='Выберите валюту']")
    public WebElement currencySelection_XPATH;
    @FindBy(xpath = "//*[@data-title='Выберите язык']")
    public WebElement languageSelection_XPATH;
    @FindBy(xpath = "//*[@data-title='Посмотреть ваши уведомления']")
    public WebElement notifications_XPATH;
    @FindBy(id = "notifications-list") //*[@id="notifications-list"]
    public WebElement notificationsList_ID;
    @FindBy(xpath = "//*[@data-type='confirm_primary_email']/div/a")
   // @FindBy(css = "li[data-type='confirm_primary_email'] div a") //*[@id="notification-5079481643"]/a
    public WebElement activationLetter_CSS;
    @FindBy(id = "//*[@data-title='Центр поддержки клиентов']")
    public WebElement customerSupportCenter_XPATH;
    @FindBy(id = "add_property_topbar ")
    public WebElement buttonRegisterObject_ID;
    @FindBy(id = "current_account_create")
    public WebElement buttonAccountCreate_ID;
    @FindBy(id = "current_account")
    public WebElement buttonCurrentAccount_ID;
    @FindBy(id = "cross-product-bar")
    public WebElement blueBannerSecond_ID;
    @FindBy(xpath = "//*[@id='cross-product-bar']/div/span")
    public WebElement housingTab_XPATH;
    @FindBy(xpath = "//*[@id='cross-product-bar']/div/a[1]")
    public WebElement flightsTab_XPATH;
    @FindBy(xpath = "//*[@id='cross-product-bar']/div/a[2]")
    public WebElement carRentalTab_XPATH;
    @FindBy(xpath = "//*[@id='cross-product-bar']/div/a[3]")
    public WebElement leisureTab_XPATH;
    @FindBy(xpath = "//*[@id='cross-product-bar']/div/a[4]")
    public WebElement taxiTab_XPATH;
    @FindBy(xpath = "//*[@id='profile-menu']/div[7]/a")
    public WebElement accountFavorites_XPATH;


    public BookingBannerBlock(WebDriver webDriver) {
        super(webDriver);
    }

}
