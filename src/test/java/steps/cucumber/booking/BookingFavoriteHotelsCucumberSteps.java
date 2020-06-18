package steps.cucumber.booking;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import drivers.Driver;
import drivers.URL;
import object.City;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import settings.GetPath;
import skreens.booking.BookingAccountPage;
import skreens.booking.BookingFavoriteHotelsPage;
import skreens.booking.BookingHomePage;
import skreens.booking.BookingSearchResultsHotelsPage;
import steps.base_steps.BookingBaseSteps;
import utility.JsonParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookingFavoriteHotelsCucumberSteps {
    private BookingHomePage bookingHomePage;
    private BookingSearchResultsHotelsPage bookingHotels;
    private BookingFavoriteHotelsPage bookingFavoriteHotels;
    private List<String> listNameFavoriteHotels;
    private int lastHotelList;

    private static final Logger LOGGER = LogManager.getLogger(BookingFavoriteHotelsCucumberSteps.class);

    @And("Sign in current account")
    public void signInCurrentAccount() {
        bookingHomePage = new BookingHomePage(Driver.getDriver());
        BookingBaseSteps.currentAccount(bookingHomePage);
    }

    @And("Choosing the first and last hotel")
    public void choosingHotel() throws InterruptedException {
        bookingHotels = new BookingSearchResultsHotelsPage(Driver.getDriver());
        Thread.sleep(5000);
        lastHotelList = bookingHotels.getSizeListHotel();
        bookingHotels.selectFavoriteHotel(1);
        bookingHotels.selectFavoriteHotel(lastHotelList);
    }

    @Then("Check what color is the heart")
    public void checkColorHeart() {
        String color = "rgb(204, 0, 0)";
        String massege = "Color heat is not red.";
        assert bookingHotels.getColorHeart(1).equals(color): massege;
//        assert bookingHotels.getColorHeart(lastHotelList).equals(color): massege;
    }


    @When("Write the names of the selected hotels to the list")
    public void setSelectHotelsList() {
        listNameFavoriteHotels = new ArrayList<String>();
        listNameFavoriteHotels.add(bookingHotels.selectNameHotel(1).getText());
        listNameFavoriteHotels.add(bookingHotels.selectNameHotel(lastHotelList).getText());
    }
    @And("Go to 'My next trips' list")
    public void goToMyNextTripsList() {
        bookingHotels.bannerBlock.buttonCurrentAccount_ID.click();
        bookingHotels.bannerBlock.accountFavorites_XPATH.click();
        Driver.setTimeouts();
    }

    @Then("Check availability of selected hotels")
    public void BookingFavoriteHotelsSelection() throws InterruptedException {
       // bookingFavoriteHotels = new BookingFavoriteHotelsPage(Driver.getDriver());
        System.out.println(listNameFavoriteHotels);
        int count = BookingBaseSteps.hotelPresenceOnList(listNameFavoriteHotels);
        assert count == listNameFavoriteHotels.size() : "Not all hotels listed.";

    }

}
