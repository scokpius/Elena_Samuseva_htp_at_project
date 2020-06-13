package skreens.booking;

import drivers.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utility.DetermineDate;
import skreens.AbstractPage;

import java.util.List;

public class BookingHomePage extends AbstractPage {
    @FindBy(id = "ss")
    private WebElement city_ID;
    @FindBy(xpath = "//ul[@data-list]//li[@data-i='0']")
    private WebElement citySearch_XPATH;
    @FindBy(xpath = "//*[@id='frm']/div[1]/div[2]")
    private WebElement checkInCheckOut_XPATH;
    @FindBy(xpath = "//*[@class='bui-calendar']")
    private WebElement calendar_XPATH;
    @FindBy(xpath = "//*[@data-bui-ref='calendar-prev']")
    private WebElement checkMonth_XPATH;
    @FindBy(xpath = "//*[@id='xp__guests__toggle']")
    private WebElement adultsChildrenRooms_XPATH;
    @FindBy(className = "sb-searchbox__button")
    private WebElement searchButton_XPATH;
    @FindBy(how = How.CLASS_NAME, using = "bui-stepper__input")
    private List<WebElement> accomodationInput;
    @FindBy(xpath = "//*[@id='b2indexPage']/div[14]/button")
    public WebElement buttonClosePopUpWindow_XPATH;
    @FindBy(xpath = "//*[@id='b2mysettingsPage']/div[9]/div/div")
    public WebElement bannerConfirmation_XPATH;
    public BookingBannerBlock bannerBlock = new BookingBannerBlock(Driver.getDriver());

    public BookingHomePage(WebDriver webDriver) {
        super(webDriver);
    }

    private void selectCity(String nameCity) throws InterruptedException {
        city_ID.clear();
        city_ID.sendKeys(nameCity);
        city_ID.click();
        Thread.sleep(2000);
        citySearch_XPATH.click();
    }

    public void clickCheckInOut() {
        checkInCheckOut_XPATH.click();
        DetermineDate.todayDate();
        String dateToday = "//*[@class='bui-calendar']//td[@data-date='" + DetermineDate.getDetermineDate() + "']";
        WebElement dateToday_XPATH = Driver.getDriver().findElement(By.xpath(dateToday));
        if (dateToday_XPATH.isDisplayed() == false) {
            checkMonth_XPATH.click();
        }

    }

    private void selectDateInOut(int dateIn, int difference) {
        DetermineDate.setDetermineDate(dateIn);
        String dateCheckIn = "//*[@class='bui-calendar']//td[@data-date='" + DetermineDate.getDetermineDate() + "']";
        WebElement dateCheckIn_XPATH = Driver.getDriver().findElement(By.xpath(dateCheckIn));
        dateCheckIn_XPATH.click();
        DetermineDate.setDetermineDate(dateIn + difference);
        String dateCheckOut = "//*[@class='bui-calendar']//td[@data-date='" + DetermineDate.getDetermineDate() + "']";
        WebElement dateCheckOut_XPATH = Driver.getDriver().findElement(By.xpath(dateCheckOut));
        dateCheckOut_XPATH.click();
    }

    private void selectAdultsChildrenRooms() {
        adultsChildrenRooms_XPATH.click();
    }

    private void setAdultsChildrenRoomsValue(int adults, int children, int rooms) {
        Driver.setElementAttributeValue(accomodationInput.get(0), adults);
        Driver.setElementAttributeValue(accomodationInput.get(1), children);
        Driver.setElementAttributeValue(accomodationInput.get(2), rooms);
    }

    public void enteringSearchData(String city, int date_in, int difference, int adults, int children, int rooms) throws InterruptedException {
        selectCity(city);
        if (calendar_XPATH.isDisplayed() == false){
            clickCheckInOut();
        }
        selectDateInOut(date_in, difference);
        selectAdultsChildrenRooms();
        setAdultsChildrenRoomsValue(adults, children, rooms);
        searchButton_XPATH.click();
    }

}
