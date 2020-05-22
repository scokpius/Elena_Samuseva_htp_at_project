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

public class BookingParisSteps /*extends BaseSteps*/{
    private BookingHomePage bookingHomePage;
    private BookingSearchResultsHotels bookingHotels;

    @Before
    public void propertis()  {
        ConfigProperties.setPathTestData("propertie.properties");
        Driver.goToSite();
        bookingHomePage = new BookingHomePage(Driver.getDriver());
        bookingHotels = new BookingSearchResultsHotels(Driver.getDriver());
    }
    @Test
    public void BookingParisSteps () throws InterruptedException, IOException {
        DataCity city = JsonParser.parseGSON(GetPath.getPathTestData("data_test_city.json"));
        bookingHomePage.selectCity(city.city[0].name);
        bookingHomePage.selectDateInOut(city.city[0].date_in, city.city[0].date_out);
        bookingHomePage.selectAdultsChildrenRooms();
        bookingHomePage.setAdultsChildrenRoomsValue(city.city[0].adults,
                city.city[0].children,city.city[0].rooms);
        bookingHomePage.clickButtonSearch();
        bookingHotels.selectPriceMax();
        int priceMax = Integer.parseInt(bookingHotels.takingCostPriceMax().replaceAll("[^0-9]+", ""));
        System.out.println(String.format("Maximum price: %d", priceMax));
        Thread.sleep(5000);
        bookingHotels.clickButtonSortingMin();
        Thread.sleep(5000);
        int priceMaxMin = Integer.parseInt(bookingHotels.takingCostLivingFirstHotel().substring(4).replace(" ",""))/
                (city.city[0].date_out - city.city[0].date_in);
        System.out.println(String.format("Minimum price of maximum: %d", priceMaxMin));
        Thread.sleep(5000);
        Assert.assertTrue("This is not true!", priceMaxMin >= priceMax);
    }


}
