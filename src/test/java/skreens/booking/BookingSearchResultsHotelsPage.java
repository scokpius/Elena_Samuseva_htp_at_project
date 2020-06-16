package skreens.booking;


import drivers.Driver;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import skreens.AbstractPage;


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
    private static final Logger LOGGER = LogManager.getLogger(BookingSearchResultsHotelsPage.class);

    public BookingSearchResultsHotelsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void selectPriceMax (){
        checkboxPriceMax_XPATH = Driver.getDriver().findElement(By.xpath("//*[@id='filter_price']//a[5]"));
        checkboxPriceMax_XPATH.click();
        LOGGER.debug("Max price selection.(checkboxPriceMax_XPATH)");
    }
    public void selectPriceMin (){
        checkboxPriceMin_XPATH = Driver.getDriver().findElement(By.xpath("//*[@id='filter_price']//a[1]"));
        checkboxPriceMin_XPATH.click();
        LOGGER.debug("Min price selection.(checkboxPriceMax_XPATH)");
    }
    public void clickButtonSortingMin () {
        sortingMin_XPATH = Driver.getDriver().findElement(By.xpath("//*[@id='sort_by']/ul/li[3]/a"));
        sortingMin_XPATH.click();
        LOGGER.debug("Click on the button the lowest price at the beginning.(sortingMin_XPATH)");
    }
    public String takingCostPriceMax(){
        LOGGER.debug("Getting the maximum price.(checkboxPriceMax_XPATH)");
        return  checkboxPriceMax_XPATH.getText();
    }
    public String takingCostPriceMin(){
        LOGGER.debug("Getting the minimum price.(checkboxPriceMin_XPATH)");
        return  checkboxPriceMin_XPATH.getText();
    }
    public String takingCostLivingFirstHotel(){
        priceOneFirstHotel_XPATH = Driver.getDriver().findElement(
                By.xpath("//*[@id='hotellist_inner']/div[1]//div[@aria-hidden='true']"));
        LOGGER.debug("Getting the price of the first hotel on the list.(priceOneFirstHotel_XPATH)");
        return  priceOneFirstHotel_XPATH.getText();
    }
    public void clickButtonCheckboxThreeStars (){
        checkboxThreeStars_XPATH = Driver.getDriver().findElement(By.xpath("//*[@id='filter_class']/div[2]/a[1]"));
        checkboxThreeStars_XPATH.click();
        LOGGER.debug("Put a checkmark in the checkbox three stars.(checkboxThreeStars_XPATH)");
    }
    public void clickButtonCheckboxFourStars (){
        checkboxFourStars_XPATH = Driver.getDriver().findElement(By.xpath("//*[@id='filter_class']/div[2]/a[2]"));
        checkboxFourStars_XPATH.click();
        LOGGER.debug("Put a checkmark in the checkbox four stars.(checkboxFourStars_XPATH)");
    }

    private WebElement selectHotelInOrder(int numberInOrder){
        LOGGER.debug("Select a hotel from the list by index.(listHotell)");
        return listHotell.get(numberInOrder-1);
    }

    public int getSizeListHotel(){
        LOGGER.debug("Getting size list of hotels.(listHotell)");
         return listHotell.size();
    }

    public void sсrollHotel(int numberInOrder){
        Driver.scrollElement(selectHotelInOrder(numberInOrder));
        LOGGER.debug("Scrolling to a hotel with an index.");
    }

    public void changeBackgroundHotel (int numberInOrder, String color){
        Driver.colorBackgroundElement(selectHotelInOrder(numberInOrder), color);
        LOGGER.debug("To color the background of the hotel.");
    }

    public String getColorHeart(int numberInOrderHotel){
        sсrollHotel(numberInOrderHotel);
        heartColor_XPATH = Driver.getDriver().findElement(By.xpath(
                String.format("//*[@id='hotellist_inner']/div[@data-hotelid][%d]//button/*[1]",
                        numberInOrderHotel)));
        LOGGER.debug("Getting heart fill color.(heartColor_XPATH)");
       return heartColor_XPATH.getCssValue("fill");
    }

    public void selectFavoriteHotel(int numberInOrderHotel){
        sсrollHotel(numberInOrderHotel);
        Driver.setTimeouts();
        favoriteHotel_XPATH = Driver.getDriver().findElement(
                By.xpath(String.format("//*[@id='hotellist_inner']/div[@data-hotelid][%d]//button", numberInOrderHotel)));
        favoriteHotel_XPATH.click();
        LOGGER.debug("Favorite hotel selection.(favoriteHotel_XPATH)");
    }
    public WebElement selectNameHotel(int numberInOrder){
        LOGGER.debug("Get hotel name locator.(nameHotel_XPATH)");
        return nameHotel_XPATH = Driver.getDriver().findElement(
                By.xpath(String.format("//*[@id='hotellist_inner']/div[@data-hotelid][%d]//span[@data-et-click]", numberInOrder)));
    }

    public void changeColorNameHotel (int numberInOrder, String color){
        Driver.colorElement(selectNameHotel(numberInOrder), color);
        LOGGER.debug("Change color hotel name.");
    }

}
