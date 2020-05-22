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

public class BookingMoscowSteps /*extends BaseSteps*/{
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
    public void BookingMoscowSteps () throws InterruptedException, IOException {
        DataCity city = JsonParser.parseGSON(GetPath.getPathTestData("data_test_city.json"));
        bookingHomePage.selectCity(city.city[1].name);
        bookingHomePage.clickCheckInOut();
        bookingHomePage.selectDateInOut(city.city[1].date_in, city.city[1].date_out);
        bookingHomePage.selectAdultsChildrenRooms();
        bookingHomePage.setAdultsChildrenRoomsValue(city.city[1].adults,
                city.city[0].children, city.city[1].rooms);
        bookingHomePage.clickButtonSearch();
        bookingHotels.selectPriceMin();
        int priceMin = Integer.parseInt(bookingHotels.takingCostPriceMin().replaceAll("[^0-9]+", ""));
        System.out.println(String.format("Maximum value of the minimum: %d", priceMin));
        Thread.sleep(5000);
        int priceMinFirst = Integer.parseInt(bookingHotels.takingCostLivingFirstHotel().substring(4).replace(" ",""))/
                (city.city[1].date_out - city.city[1].date_in);
        System.out.println(String.format("Cost of one night in hotels: %d", priceMinFirst));
        Thread.sleep(5000);
        Assert.assertTrue("This is not true!", priceMinFirst <= priceMin);
    }

}
