package skreens.booking;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import skreens.AbstractPage;

import java.util.ArrayList;
import java.util.List;

public class BookingFavoriteHotelsPage extends AbstractPage {
    @FindBy(how = How.XPATH, using = "//*[@id='js-wishlist-carousel']/ul/li/div/div[3]/header/h1/a")
    public List<WebElement> listNameHotels;

    private static final Logger LOGGER = LogManager.getLogger(BookingFavoriteHotelsPage.class);

    public BookingFavoriteHotelsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public List<String> getlistNameHotels(){
        List<String> listName = new ArrayList<>();
        for (int i = 0; i < listNameHotels.size(); i++) {
            listName.add(listNameHotels.get(i).getText());
        }
        LOGGER.debug("Getting a list of hotels with a heart.(listNameHotels)");
        return listName;
    }
}
