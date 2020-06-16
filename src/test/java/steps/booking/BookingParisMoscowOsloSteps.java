package steps.booking;

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
import skreens.booking.BookingHomePage;
import skreens.booking.BookingSearchResultsHotelsPage;
import steps.base_steps.BookingLoginPasswordSteps;
import utility.JsonParser;

import java.io.IOException;
import java.util.List;

public class BookingParisMoscowOsloSteps /*extends InitCloseDriverSteps*/{
    private BookingHomePage bookingHomePage;
    private BookingSearchResultsHotelsPage bookingHotels;
    private List<City> city;

    private static final Logger LOGGER = LogManager.getLogger(BookingParisMoscowOsloSteps .class);

    @Before
    public void properties() throws IOException {
        LOGGER.info("---------------------------Test started---------------------------");
        Driver.goToSite(URL.BOOKING);
        bookingHomePage = new BookingHomePage(Driver.getDriver());
        bookingHotels = new BookingSearchResultsHotelsPage(Driver.getDriver());
        city = JsonParser.parseGSONCity(GetPath.getPathTestData("data_test_city.json"));
    }

    @Test
    public void BookingParisSteps () throws InterruptedException, IOException {
        bookingHomePage.enteringSearchData(city.get(0).city, city.get(0).date_in, city.get(0).difference,
                city.get(0).adults, city.get(0).children, city.get(0).rooms);
        bookingHotels.selectPriceMax();
        int priceMax = Integer.parseInt(bookingHotels.takingCostPriceMax().replaceAll("[^0-9]+", ""));
        System.out.println(String.format("Maximum price: %d", priceMax));
        Thread.sleep(5000);
        bookingHotels.clickButtonSortingMin();
        Thread.sleep(5000);
        int priceMaxMin = Integer.parseInt(bookingHotels.takingCostLivingFirstHotel().substring(4).replace(" ",""))/
                city.get(0).difference;
        System.out.println(String.format("Minimum price of maximum: %d", priceMaxMin));
        Thread.sleep(5000);
        Assert.assertTrue("This is not true!", priceMaxMin >= priceMax);
    }

    @Test
    public void BookingMoscowSteps () throws InterruptedException, IOException {
        bookingHomePage.enteringSearchData(city.get(1).city, city.get(1).date_in, city.get(1).difference,
                city.get(1).adults, city.get(1).children, city.get(1).rooms);
        bookingHotels.selectPriceMin();
        int priceMin = Integer.parseInt(bookingHotels.takingCostPriceMin().replaceAll("[^0-9]+", ""));
        System.out.println(String.format("Maximum value of the minimum: %d", priceMin));
        Thread.sleep(5000);
        int priceMinFirst = Integer.parseInt(bookingHotels.takingCostLivingFirstHotel().substring(4).replace(" ",""))/
                city.get(1).difference;
        System.out.println(String.format("Cost of one night in hotels: %d", priceMinFirst));
        Thread.sleep(5000);
        Assert.assertTrue("This is not true!", priceMinFirst <= priceMin);
    }

    @Test
    public void BookingOsloSteps () throws InterruptedException {
        bookingHomePage.enteringSearchData(city.get(2).city, city.get(2).date_in, city.get(2).difference,
                city.get(2).adults, city.get(2).children, city.get(2).rooms);
        bookingHotels.clickButtonCheckboxThreeStars();
        bookingHotels.clickButtonCheckboxFourStars();
        Thread.sleep(5000);
        bookingHotels.sсrollHotel(10);
        bookingHotels.changeBackgroundHotel(10, "lime");
        bookingHotels.changeColorNameHotel(10, "red");
        Assert.assertEquals("Change of color name of Hotel doesn't work","color: red;",
                bookingHotels.selectNameHotel(10).getAttribute("style"));
    }

    @After
    public void finished(){
        LOGGER.info("---------------------------Test finished--------------------------");

    }

}
