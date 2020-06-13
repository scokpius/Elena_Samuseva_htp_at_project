package skreens.booking;

import com.google.common.collect.Lists;
import drivers.Driver;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import skreens.AbstractPage;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class BookingSearchResultsHotelsPage extends AbstractPage {

    @FindBy(how = How.XPATH, using = "//*[@id='hotellist_inner']/div[@data-hotelid]")
    private List<WebElement> listHotell;
    private WebElement checkboxPriceMax_XPATH;
    private WebElement checkboxPriceMin_XPATH;
    private WebElement sortingMin_XPATH;
    private WebElement priceOneFirstHotel_XPATH;
    private WebElement checkboxThreeStars_XPATH;
    private WebElement checkboxFourStars_XPATH;
    private WebElement hotel_XPATH;
    private WebElement nameHotel_XPATH;
    private WebElement favoriteHotel_XPATH;
    private WebElement heartColor_XPATH;

    public BookingBannerBlock bannerBlock = new BookingBannerBlock(Driver.getDriver());

    public BookingSearchResultsHotelsPage(WebDriver webDriver) {
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


    private WebElement selectHotelInOrder(int numberInOrder){
       return listHotell.get(numberInOrder-1);
    }

    public int getSizeListHotel(){
         return listHotell.size();
    }


    public void sсrollHotel(int numberInOrder){
        Driver.scrollElement(selectHotelInOrder(numberInOrder));
    }

    public void changeBackgroundHotel (int numberInOrder, String color){
        Driver.colorBackgroundElement(selectHotelInOrder(numberInOrder), color);

    }
    public String getColorHeart(int numberInOrderHotel){
        heartColor_XPATH = Driver.getDriver().findElement(By.xpath(
                String.format("//*[@id='hotellist_inner']/div[@data-hotelid][%d]//button/*[1]",
                        numberInOrderHotel)));
        sсrollHotel(numberInOrderHotel);
       return heartColor_XPATH.getCssValue("fill");
    }

    public void selectFavoriteHotel(int numberInOrderHotel){
        sсrollHotel(numberInOrderHotel);
        Driver.setTimeouts();
        favoriteHotel_XPATH = Driver.getDriver().findElement(
                By.xpath(String.format("//*[@id='hotellist_inner']/div[@data-hotelid][%d]//button", numberInOrderHotel)));
        favoriteHotel_XPATH.click();

    }
    public WebElement selectNameHotel(int numberInOrder){
        return nameHotel_XPATH = Driver.getDriver().findElement(
                By.xpath(String.format("//*[@id='hotellist_inner']/div[@data-hotelid][%d]//span[@data-et-click]", numberInOrder)));
    }

    public void changeColorNameHotel (int numberInOrder, String color){
        Driver.colorElement(selectNameHotel(numberInOrder), color);
    }

}
