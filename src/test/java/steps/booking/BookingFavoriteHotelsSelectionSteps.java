package steps.booking;

import drivers.Driver;
import drivers.URL;
import object.City;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import settings.GetPath;
import skreens.booking.BookingAccountPage;
import skreens.booking.BookingFavoriteHotelsPage;
import skreens.booking.BookingHomePage;
import skreens.booking.BookingSearchResultsHotelsPage;
import steps.InitCloseDriverSteps;
import utility.JsonParser;
import utility.WriteReadFail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookingFavoriteHotelsSelectionSteps extends InitCloseDriverSteps {
    private BookingHomePage bookingHomePage;
    private BookingAccountPage bookingAccountPage;
    private BookingSearchResultsHotelsPage bookingHotels;
    private BookingFavoriteHotelsPage bookingFavoriteHotels;
    private List<City> city;

    @Before
    public void properties() throws IOException {
        Driver.goToSite(URL.BOOKING);
        bookingHomePage = new BookingHomePage(Driver.getDriver());
        bookingAccountPage = new BookingAccountPage(Driver.getDriver());
        bookingHotels = new BookingSearchResultsHotelsPage(Driver.getDriver());
        bookingFavoriteHotels = new BookingFavoriteHotelsPage(Driver.getDriver());
        city = JsonParser.parseGSONCity(GetPath.getPathTestData("data_test_city.json"));
    }

    @Test
    public void BookingFavoriteHotelsSelection() throws InterruptedException {
        currentAccount();
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
        int count = hotelPresenceOnLlist(listNameFavoriteHotels);
        Assert.assertTrue("Not all hotels listed.", count == 2);
    }

    private int hotelPresenceOnLlist(List<String> listNameFavoriteHotels) {
        int count = 0;
        for (int i = 0; i < listNameFavoriteHotels.size(); i++) {
            for (int j = 0; j < bookingFavoriteHotels.getlistNameHotels().size(); j++) {
                if (listNameFavoriteHotels.get(i).equals(bookingFavoriteHotels.getlistNameHotels().get(j))){
                    count++;
                }
            }
        }
        return count;
    }

    private void currentAccount() {
        bookingHomePage.bannerBlock.buttonCurrentAccount_ID.click();
        String resultFile = GetPath.getPathProperties("login_password_Boking.txt");
        String[] loginPassword = WriteReadFail.readInFileToStringBuilder(resultFile).split(" ");
        bookingAccountPage.setCurrentLoginPassword(loginPassword[0], loginPassword[1]);
    }


}
