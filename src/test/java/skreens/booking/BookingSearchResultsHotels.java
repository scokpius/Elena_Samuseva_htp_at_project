package skreens.booking;

import drivers.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import skreens.AbstractPage;

import java.util.List;

public class BookingSearchResultsHotels extends AbstractPage {

//    @FindBy(how = How.XPATH, using = "//*[@id='hotellist_inner']//button[@aria-label='Этот вариант сохранен в 1 ваших списках']")
//    private List<WebElement> heartRed_XPATH;

   private WebElement checkboxPriceMax_XPATH;
    private WebElement checkboxPriceMin_XPATH;
    private WebElement sortingMin_XPATH;
    private WebElement priceOneFirstHotel_XPATH;
    private WebElement checkboxThreeStars_XPATH;
    private WebElement checkboxFourStars_XPATH;
    private WebElement hotel_XPATH;
    private WebElement nameHotel_XPATH;
    private WebElement favoriteHotel_XPATH;
    private WebElement heartRedFirst_XPATH;
    private WebElement heartRedLast_XPATH;

    public BookingSearchResultsHotels(WebDriver webDriver) {
        super(webDriver);
    }

    public void selectPriceMax (){
        checkboxPriceMax_XPATH = Driver.getDriver().findElement(By.xpath("//*[@id='filter_price']//a[5]"));
        checkboxPriceMax_XPATH.click();
    }
    public void selectPriceMin (){
        checkboxPriceMin_XPATH = Driver.getDriver().findElement(By.xpath("//*[@id='filter_price']//a[1]"));
        checkboxPriceMin_XPATH.click();
    }
    public void clickButtonSortingMin () {
        sortingMin_XPATH = Driver.getDriver().findElement(By.xpath("//*[@id='sort_by']/ul/li[3]/a"));
        sortingMin_XPATH.click();
    }
    public String takingCostPriceMax(){
        return  checkboxPriceMax_XPATH.getText();
    }
    public String takingCostPriceMin(){
        return  checkboxPriceMin_XPATH.getText();
    }
    public String takingCostLivingFirstHotel(){
        priceOneFirstHotel_XPATH = Driver.getDriver().findElement(
                By.xpath("//*[@id='hotellist_inner']/div[1]//div[@aria-hidden='true']"));
        return  priceOneFirstHotel_XPATH.getText();
    }
    public void clickButtonCheckboxThreeStars (){
        checkboxThreeStars_XPATH = Driver.getDriver().findElement(By.xpath("//*[@id='filter_class']/div[2]/a[1]"));
        checkboxThreeStars_XPATH.click();
    }
    public void clickButtonCheckboxFourStars (){
        checkboxFourStars_XPATH = Driver.getDriver().findElement(By.xpath("//*[@id='filter_class']/div[2]/a[2]"));
        checkboxFourStars_XPATH.click();
    }
    private WebElement selectHotelIOrder(String numberInOrder){
        return hotel_XPATH = Driver.getDriver().findElement(
                By.xpath(String.format("//*[@id='hotellist_inner']/div[@data-hotelid][%s]", numberInOrder)));
    }

    public void sсrollHotel(String numberInOrder){
        Driver.scrollElement(selectHotelIOrder(numberInOrder));
    }
    public void changeBackgroundHotel (String numberInOrder, String color){
        Driver.colorBackgroundElement(selectHotelIOrder(numberInOrder), color);

    }
    public boolean selectHeartRed(){

        heartRedFirst_XPATH = Driver.getDriver().findElement(By.xpath("//*[@id='hotellist_inner']/div[1]//button[@aria-label='Этот вариант сохранен в 1 ваших списках']"));
        heartRedLast_XPATH  = Driver.getDriver().findElement(By.xpath("//*[@id='hotellist_inner']/div[26]//button[@aria-label='Этот вариант сохранен в 1 ваших списках']"));
        String string = "Этот вариант сохранен в 1 ваших списках";
        if ((heartRedFirst_XPATH.getAttribute("aria-label") == string) && (heartRedLast_XPATH.getAttribute("aria-label") == string)){
            return true;
        }
        else return false;
//        return heartRed_XPATH.isDisplayed();
    }

    public void selectFavoriteHotel(String numberInOrder){
        sсrollHotel(numberInOrder);
        favoriteHotel_XPATH = Driver.getDriver().findElement(
                By.xpath(String.format("//*[@id='hotellist_inner']/div[@data-hotelid][%s]//button", numberInOrder)));
        favoriteHotel_XPATH.click();

    }
    public WebElement selectNameHotel(String numberInOrder){
        return nameHotel_XPATH = Driver.getDriver().findElement(
                By.xpath(String.format("//*[@id='hotellist_inner']/div[@data-hotelid][%s]//span[@data-et-click]", numberInOrder)));
    }

    public void changeColorNameHotel (String numberInOrder, String color){
        Driver.colorElement(selectNameHotel(numberInOrder), color);
    }

}
