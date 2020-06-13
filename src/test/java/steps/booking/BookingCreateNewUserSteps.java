package steps.booking;

import drivers.Driver;
import drivers.URL;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import settings.ConfigProperties;
import settings.GetPath;
import skreens.booking.BookingHomePage;
import skreens.trashmail.TrashMailAddressManagerPage;
import skreens.trashmail.TrashMailHomePage;
import steps.base_steps.BookingLoginPasswordSteps;
import steps.base_steps.InitCloseDriverSteps;
import steps.base_steps.OpenMyGMailSteps;
import utility.WriteReadFail;

import java.util.ArrayList;

public class BookingCreateNewUserSteps extends InitCloseDriverSteps {
    private TrashMailHomePage trashMailHomePage;
    private TrashMailAddressManagerPage trashMailAddressManagerPage;
    private BookingHomePage bookingHomePage;
    private String disposableEmail;

    @Before
    public void properties() throws InterruptedException {
        Driver.goToSite(URL.TRASHMAIL);
        trashMailHomePage = new TrashMailHomePage(Driver.getDriver());
        ConfigProperties.setPathProperties("propertie_login.properties");
        trashMailAddressManagerPage = new TrashMailAddressManagerPage(Driver.getDriver());
        Driver.setTimeouts();
        disposableEmail = gettingDisposableEmailAddress(ConfigProperties.read("TRASHMAIL_USERNAME"),
                ConfigProperties.read("TRASHMAIL_PASSWORD"));
    }
    @Test
    public void CreateNewUser() throws InterruptedException {
        Driver.goToSite(URL.BOOKING);
        bookingHomePage = new BookingHomePage(Driver.getDriver());
        BookingLoginPasswordSteps.createAccount(bookingHomePage, disposableEmail);
        bookingHomePage.buttonClosePopUpWindow_XPATH.click();
        bookingHomePage.bannerBlock.notifications_XPATH.click();
        bookingHomePage.bannerBlock.activationLetter_XPATH.click();
        new OpenMyGMailSteps().OpenAndFindEmailMyGMail(ConfigProperties.read("GMAIL_USERNAME"),
                ConfigProperties.read("GMAIL_PASSWORD"));
        ArrayList<String> windowHandles = new ArrayList<String>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(windowHandles.get(2));
        bookingHomePage = new BookingHomePage(Driver.getDriver());
        String resultFile = GetPath.getPathProperties("login_password_Boking.txt");
        WriteReadFail.writerToFile(resultFile, disposableEmail, BookingLoginPasswordSteps.getPasswordBooking());
        Assert.assertTrue("Account not activated", bookingHomePage.bannerConfirmation_XPATH.isDisplayed());
    }

    public String  gettingDisposableEmailAddress(String login, String password) throws InterruptedException {
        trashMailHomePage.sendInTrashMail(login, password);
        trashMailAddressManagerPage.AddButton_ID.click();
        trashMailAddressManagerPage.SaveButton_ID.click();
        Thread.sleep(3000);
        return trashMailAddressManagerPage.getDisposableDomain();
    }

}

