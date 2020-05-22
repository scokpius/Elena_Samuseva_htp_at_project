package skreens.booking;

import drivers.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import skreens.AbstractPage;

public class BookingSearchResultsHotels extends AbstractPage {

   private WebElement checkboxPriceMax_XPATH;
    private WebElement checkboxPriceMin_XPATH;
    private WebElement sortingMin_XPATH;
    private WebElement priceOneFirstHotel_XPATH;
   // private WebElement checkboxStars_XPATH = Driver.getDriver().findElement(By.xpath("//*[@id='filter_class']"));
    private WebElement checkboxThreeStars_XPATH;
    private WebElement checkboxFourStars_XPATH;
    private WebElement hotelTen_XPATH;
    private WebElement nameTenHotel_XPATH;

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
    public WebElement selectHotelIOrder(String numberInOrder){
        return hotelTen_XPATH = Driver.getDriver().findElement(
                By.xpath(String.format("//*[@id='hotellist_inner']/div[@data-hotelid][%s]", numberInOrder)));
    }

    public void sсrollHotel(String numberInOrder){
        Driver.scrollElement(selectHotelIOrder(numberInOrder));
    }
    public void changeBackgroundHotel (String numberInOrder, String color){
        Driver.colorBackgroundElement(selectHotelIOrder(numberInOrder), color);

    }
    public WebElement selectNameHotel(String numberInOrder){
        return nameTenHotel_XPATH = Driver.getDriver().findElement(
                By.xpath(String.format("//*[@id='hotellist_inner']/div[@data-hotelid][%s]//span[@data-et-click]", numberInOrder)));
    }

    public void changeColorNameHotel (String numberInOrder, String color){
        Driver.colorElement(selectNameHotel(numberInOrder), color);
    }

}
