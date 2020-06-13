package skreens.booking;

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

    public BookingFavoriteHotelsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public List<String> getlistNameHotels(){
        List<String> listName = new ArrayList<>();
        for (int i = 0; i < listNameHotels.size(); i++) {
            listName.add(listNameHotels.get(i).getText());
        }
        return listName;
    }
}
