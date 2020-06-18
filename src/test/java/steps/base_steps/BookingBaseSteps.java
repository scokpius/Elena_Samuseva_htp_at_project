package steps.base_steps;

import drivers.Driver;
import drivers.URL;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import settings.GetPath;
import skreens.booking.BookingAccountPage;
import skreens.booking.BookingFavoriteHotelsPage;
import skreens.booking.BookingHomePage;
import skreens.trashmail.TrashMailAddressManagerPage;
import skreens.trashmail.TrashMailHomePage;
import utility.MyRandom;
import utility.WriteReadFail;

import java.util.List;

public class BookingBaseSteps {
    private static BookingAccountPage bookingAccountCreatePage;
    private static BookingAccountPage bookingAccountPage;
    private static TrashMailHomePage trashMailHomePage;
    private static TrashMailAddressManagerPage trashMailAddressManagerPage;
    private static String passwordBooking;
    private static BookingFavoriteHotelsPage bookingFavoriteHotels;

    private static final Logger LOGGER = LogManager.getLogger(BookingBaseSteps.class);

    public static String getPasswordBooking() {
        return passwordBooking;
    }

    public static void createAccount(BookingHomePage bookingHomePage, String login) throws InterruptedException {
        LOGGER.info("Registration and login to the site account.");
        bookingHomePage.bannerBlock.buttonAccountCreate_ID.click();
        bookingAccountCreatePage = new BookingAccountPage(Driver.getDriver());
        bookingAccountCreatePage.setEmailAddressCreate(login);
        passwordBooking = MyRandom.randomPassword(19);
        bookingAccountCreatePage.setPasswordCreate(passwordBooking);
    }

    public static void currentAccount(BookingHomePage bookingHomePage) {
        LOGGER.info("Login to the site account.");
        bookingAccountPage = new BookingAccountPage(Driver.getDriver());
        bookingHomePage.bannerBlock.buttonCurrentAccount_ID.click();
        String resultFile = GetPath.getPathProperties("login_password_Boking.txt");
        String[] loginPassword = WriteReadFail.readInFileToStringBuilder(resultFile).split(" ");
        bookingAccountPage.setCurrentLoginPassword(loginPassword[0], loginPassword[1]);
    }

    public static void signOut(BookingHomePage bookingHomePage) {
        LOGGER.info("Log out of the site account.");
        bookingHomePage.bannerBlock.buttonCurrentAccount_ID.click();
        bookingHomePage.bannerBlock.buttonExit_XPATH.click();
    }

    public static String  gettingDisposableEmailAddress(String login, String password) throws InterruptedException {
        LOGGER.debug("Getting disposable email address.(trashMailAddressManagerPage.AddButton_ID)");
        Driver.goToSite(URL.TRASHMAIL);
        trashMailHomePage = new TrashMailHomePage(Driver.getDriver());
        trashMailAddressManagerPage = new TrashMailAddressManagerPage(Driver.getDriver());
        trashMailHomePage.sendInTrashMail(login, password);
        trashMailAddressManagerPage.AddButton_ID.click();
        trashMailAddressManagerPage.SaveButton_ID.click();
        Thread.sleep(3000);
        return trashMailAddressManagerPage.getDisposableDomain();
    }
    public static int hotelPresenceOnList(List<String> listNameFavoriteHotels) {
        bookingFavoriteHotels = new BookingFavoriteHotelsPage(Driver.getDriver());
        int count = 0;
        for (int i = 0; i < listNameFavoriteHotels.size(); i++) {
            for (int j = 0; j < bookingFavoriteHotels.getlistNameHotels().size(); j++) {
                if (listNameFavoriteHotels.get(i).equals(bookingFavoriteHotels.getlistNameHotels().get(j))) {
                    count++;
                }
            }
        }
        LOGGER.debug("Checking the availability of the hotel in the 'My next trip' list");
        return count;
    }
    public static void checkIfTheItemIsDisplayed(WebElement element, String nameElement) {
        try{
            Assert.assertTrue(element.isDisplayed());
            LOGGER.debug( "This item was found on the page: " + nameElement+".");
//        }catch (NoSuchElementException e){
        }catch (Exception e){
            LOGGER.debug( "This item was not found on the page: " + nameElement+".");
        }
    }

}
