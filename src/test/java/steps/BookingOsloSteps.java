package steps;

import drivers.Driver;
import object.DataCity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import settings.ConfigProperties;
import settings.GetPath;
import skreens.booking.BookingHomePage;
import skreens.booking.BookingSearchResultsHotels;
import utility.JsonParser;

import java.io.IOException;

public class BookingOsloSteps /*extends BaseSteps*/{
    private BookingHomePage bookingHomePage;
    private BookingSearchResultsHotels bookingHotels;

    @Before
    public void propertis(){
        ConfigProperties.setPathTestData("propertie.properties");
        Driver.goToSite();
        bookingHomePage = new BookingHomePage(Driver.getDriver());
        bookingHotels = new BookingSearchResultsHotels(Driver.getDriver());
    }
    @Test
    public void BookingOsloSteps () throws InterruptedException, IOException {
        DataCity city = JsonParser.parseGSON(GetPath.getPathTestData("data_test_city.json"));
        bookingHomePage.selectCity(city.city[2].name);
        bookingHomePage.clickCheckInOut();
        bookingHomePage.selectDateInOut(city.city[2].date_in, city.city[2].date_out);
        bookingHomePage.selectAdultsChildrenRooms();
        bookingHomePage.setAdultsChildrenRoomsValue(city.city[2].adults,
                city.city[2].children, city.city[2].rooms);
        bookingHomePage.clickButtonSearch();
        bookingHotels.clickButtonCheckboxThreeStars();
        bookingHotels.clickButtonCheckboxFourStars();
        Thread.sleep(5000);
        bookingHotels.sсrollHotel("10");
        bookingHotels.changeBackgroundHotel("10", "lime");
        bookingHotels.changeColorNameHotel("10", "red");
        Assert.assertEquals("Change of color name of Hotel doesn't work","color: red;",
                bookingHotels.selectNameHotel("10").getAttribute("style"));
    }


}
