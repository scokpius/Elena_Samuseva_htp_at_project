package steps.cucumber.booking;

import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import cucumber.api.java.BeforeStep;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import drivers.ConfigDriver;
import drivers.Driver;
import drivers.URL;
import object.City;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import settings.GetPath;
import skreens.booking.BookingHomePage;
import skreens.booking.BookingSearchResultsHotelsPage;
import utility.JsonParser;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class BookingCityCucumberSteps {

    private BookingHomePage bookingHomePage;
    private BookingSearchResultsHotelsPage bookingHotels;
    private List<City> city;
    int priceMaxMin, priceMax, priceMinFirst, priceMin;
    private static final Logger LOGGER = LogManager.getLogger(BookingCityCucumberSteps.class);


    @Before
    public void properties() throws IOException {
        LOGGER.info("---------------------------Test started---------------------------");
    }

    @Given("I go to the Booking website")
    public void goToSite() {
        Driver.goToSite(URL.BOOKING);
        bookingHomePage = new BookingHomePage(Driver.getDriver());

    }

    @When("I create a list to search for the given parameters")
    public void getSearchParameters() throws IOException, URISyntaxException {
        city = JsonParser.parseGSONCity(GetPath.getPathTestData("data_test_city.json"));
    }

    @And("I set the parameters for {int} by test data")
    public void setSearchParameters(int index) throws InterruptedException {
        bookingHomePage.enteringSearchData(city.get(index).city, city.get(index).date_in,
                city.get(index).difference, city.get(index).adults,
                city.get(index).children, city.get(index).rooms);
        bookingHotels = new BookingSearchResultsHotelsPage(Driver.getDriver());
    }

    @Then("I select a test for {string} by {int}")
    public void setSearchParameters(String city, int index) throws InterruptedException {
        switch (city) {
            case "Paris": {
                compareMaximumPrices(index);
                break;
            }
            case "Moscow": {
                compareMinimumPrices(index);
                break;
            }
            case "Oslo": {
                сolorizeWebElement();
                break;
            }
        }
    }

    @And("I verify the fulfillment of the condition in {string}")
    public void verifyFulfillmentCondition(String city) {
        switch (city) {
            case "Paris": {
                assert priceMaxMin >= priceMax : "This is not true!";
                break;
            }
            case "Moscow": {
                assert priceMinFirst <= priceMin : "This is not true!";
                break;
            }
            case "Oslo": {
                assert bookingHotels.selectNameHotel(10).getAttribute("style").equals("color: red;") :
                        "Change of color name of Hotel doesn't work";
                break;
            }
        }
    }

    private void compareMaximumPrices(int index) throws InterruptedException {
        bookingHotels.selectPriceMax();
        priceMax = Integer.parseInt(bookingHotels.takingCostPriceMax().replaceAll("[^0-9]+", ""));
        System.out.println(String.format("Maximum price: %d", priceMax));
        bookingHotels.clickButtonSortingMin();
        Thread.sleep(5000);
        priceMaxMin = Integer.parseInt(bookingHotels.takingCostLivingFirstHotel().substring(4).replace(" ", "")) /
                city.get(index).difference;
        System.out.println(String.format("Minimum price of maximum: %d", priceMaxMin));
        Thread.sleep(5000);
    }

    private void compareMinimumPrices(int index) throws InterruptedException {
        bookingHotels.selectPriceMin();
        priceMin = Integer.parseInt(bookingHotels.takingCostPriceMin().replaceAll("[^0-9]+", ""));
        System.out.println(String.format("Maximum value of the minimum: %d", priceMin));
        Thread.sleep(5000);
        priceMinFirst = Integer.parseInt(bookingHotels.takingCostLivingFirstHotel().substring(4).replace(" ", "")) /
                city.get(index).difference;
        System.out.println(String.format("Cost of one night in hotels: %d", priceMinFirst));
        Thread.sleep(5000);
    }

    private void сolorizeWebElement() throws InterruptedException {
        bookingHotels.clickButtonCheckboxThreeStars();
        bookingHotels.clickButtonCheckboxFourStars();
        Thread.sleep(5000);
        bookingHotels.sсrollHotel(10);
        bookingHotels.changeBackgroundHotel(10, "lime");
        bookingHotels.changeColorNameHotel(10, "red");
    }

    @After
    public void finished() {
        LOGGER.info("---------------------------Test finished--------------------------");
    }


}
