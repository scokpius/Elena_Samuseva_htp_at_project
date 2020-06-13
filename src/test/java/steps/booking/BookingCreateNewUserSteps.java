package steps.booking;

import drivers.Driver;
import drivers.URL;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import settings.ConfigProperties;
import settings.GetPath;
import skreens.booking.BookingAccountPage;
import skreens.booking.BookingHomePage;
import skreens.trashmail.TrashMailAddressManagerPage;
import skreens.trashmail.TrashMailHomePage;
import steps.InitCloseDriverSteps;
import steps.OpenMyGMailSteps;
import utility.WriteReadFail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class BookingCreateNewUserSteps extends InitCloseDriverSteps {
    private TrashMailHomePage trashMailHomePage;
    private TrashMailAddressManagerPage trashMailAddressManagerPage;
    private BookingHomePage bookingHomePage;
    private BookingAccountPage bookingAccountCreatePage;
    private BookingAccountPage bookingAccountPage;
    private String disposableEmail, passwordBooking;
    private Random random = new Random();

    @Before
    public void properties() throws IOException, InterruptedException {
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
        bookingHomePage.bannerBlock.buttonAccountCreate_ID.click();
        bookingAccountCreatePage = new BookingAccountPage(Driver.getDriver());
        bookingAccountCreatePage.setEmailAddressCreate(disposableEmail);
        passwordBooking = randomPassword(19);
        bookingAccountCreatePage.setPasswordCreate(passwordBooking);
        bookingHomePage.buttonClosePopUpWindow_XPATH.click();
        bookingHomePage.bannerBlock.notifications_XPATH.click();
        bookingHomePage.bannerBlock.activationLetter_CSS.click();
        new OpenMyGMailSteps().OpenAndFindEmailMyGMail(ConfigProperties.read("GMAIL_USERNAME"),
                ConfigProperties.read("GMAIL_PASSWORD"));
        ArrayList<String> windowHandles = new ArrayList<String>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(windowHandles.get(2));
     //   bookingAccountPage = new BookingAccountPage(Driver.getDriver());
        bookingHomePage = new BookingHomePage(Driver.getDriver());
      //  bookingHomePage.bannerBlock.notifications_XPATH.click();
        String resultFile = GetPath.getPathProperties("login_password_Boking.txt");
        WriteReadFail.writerToFile(resultFile, disposableEmail, passwordBooking);
        Assert.assertTrue("Account not activated", bookingHomePage.bannerConfirmation_XPATH.isDisplayed());
    }

    public String  gettingDisposableEmailAddress(String login, String password) throws InterruptedException {
        trashMailHomePage.sendInTrashMail(login, password);
        trashMailAddressManagerPage.AddButton_ID.click();
        trashMailAddressManagerPage.SaveButton_ID.click();
        Thread.sleep(3000);
        return trashMailAddressManagerPage.getDisposableDomain();
    }

    private String randomPassword(final int length) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < length; i++) {
            char c = (char)(random.nextInt((int)(Character.MAX_VALUE)));
            sb.append(c);
        }
        return sb.toString();
    }



}

