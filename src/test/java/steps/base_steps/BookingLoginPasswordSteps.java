package steps.base_steps;

import drivers.Driver;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import settings.GetPath;
import skreens.booking.BookingAccountPage;
import skreens.booking.BookingHomePage;
import utility.MyRandom;
import utility.WriteReadFail;

public class BookingLoginPasswordSteps{
    private static BookingAccountPage bookingAccountCreatePage;
    private static BookingAccountPage bookingAccountPage;
    private static String passwordBooking;

    private static final Logger LOGGER = LogManager.getLogger(BookingLoginPasswordSteps.class);

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
}
