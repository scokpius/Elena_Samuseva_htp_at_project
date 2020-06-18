package steps.junit4.booking;

import drivers.Driver;
import drivers.URL;
import object.City;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import settings.GetPath;
import skreens.booking.BookingFavoriteHotelsPage;
import skreens.booking.BookingHomePage;
import skreens.booking.BookingSearchResultsHotelsPage;
import steps.base_steps.BookingBaseSteps;
import utility.JsonParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookingFavoriteHotelsSelectionSteps /*extends InitCloseDriverSteps */{
    private BookingHomePage bookingHomePage;
    private BookingSearchResultsHotelsPage bookingHotels;
    private BookingFavoriteHotelsPage bookingFavoriteHotels;
    private List<City> city;

    private static final Logger LOGGER = LogManager.getLogger(BookingFavoriteHotelsSelectionSteps.class);

    @Before
    public void properties() throws IOException {
        LOGGER.info("---------------------------Test started---------------------------");
        Driver.goToSite(URL.BOOKING);
        bookingHomePage = new BookingHomePage(Driver.getDriver());
        bookingHotels = new BookingSearchResultsHotelsPage(Driver.getDriver());
        bookingFavoriteHotels = new BookingFavoriteHotelsPage(Driver.getDriver());
        city = JsonParser.parseGSONCity(GetPath.getPathTestData("data_test_city.json"));
    }

    @Test
    public void BookingFavoriteHotelsSelection() throws InterruptedException {
        BookingBaseSteps.currentAccount(bookingHomePage);
        bookingHomePage.enteringSearchData(city.get(3).city, city.get(3).date_in, city.get(3).difference,
                city.get(3).adults, city.get(3).children, city.get(3).rooms);
        Thread.sleep(5000);
        int lastHotelList = bookingHotels.getSizeListHotel();
        bookingHotels.selectFavoriteHotel(1);
        bookingHotels.selectFavoriteHotel(lastHotelList);
        Assert.assertEquals("Color heat is not red.", bookingHotels.getColorHeart(1), "rgb(204, 0, 0)");
        Assert.assertEquals("Color heat is not red.", bookingHotels.getColorHeart(lastHotelList), "rgb(204, 0, 0)");
        List<String> listNameFavoriteHotels = new ArrayList<String>();
        listNameFavoriteHotels.add(bookingHotels.selectNameHotel(1).getText());
        listNameFavoriteHotels.add(bookingHotels.selectNameHotel(lastHotelList).getText());
        bookingHotels.bannerBlock.buttonCurrentAccount_ID.click();
        bookingHotels.bannerBlock.accountFavorites_XPATH.click();
        Driver.setTimeouts();
        int count = BookingBaseSteps.hotelPresenceOnList(listNameFavoriteHotels);
        Assert.assertTrue("Not all hotels listed.", count == 2);
    }

    @After
    public void finished(){
        BookingBaseSteps.signOut(bookingHomePage);
        LOGGER.info("---------------------------Test finished--------------------------");
    }
}
