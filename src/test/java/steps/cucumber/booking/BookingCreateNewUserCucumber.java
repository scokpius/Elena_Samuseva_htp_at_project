package steps.cucumber.booking;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import drivers.Driver;
import drivers.URL;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import settings.ConfigProperties;
import settings.GetPath;
import skreens.booking.BookingHomePage;
import skreens.trashmail.TrashMailAddressManagerPage;
import skreens.trashmail.TrashMailHomePage;
import steps.base_steps.BookingBaseSteps;
import steps.base_steps.OpenMyGMailSteps;
import utility.WriteReadFail;

import java.util.ArrayList;

public class BookingCreateNewUserCucumber {
    private TrashMailHomePage trashMailHomePage;
    private TrashMailAddressManagerPage trashMailAddressManagerPage;
    private BookingHomePage bookingHomePage;
    private String disposableEmail;

    private static final Logger LOGGER = LogManager.getLogger(BookingCreateNewUserCucumber .class);

    @Given("I get a temporary mail and go to booking.com")
    public void goToSite() throws InterruptedException {
        ConfigProperties.setPathProperties("propertie_login.properties");
        Driver.setTimeouts();
        disposableEmail =  new BookingBaseSteps().gettingDisposableEmailAddress(ConfigProperties.read("TRASHMAIL_USERNAME"),
                ConfigProperties.read("TRASHMAIL_PASSWORD"));
        Driver.goToSite(URL.BOOKING);
        bookingHomePage = new BookingHomePage(Driver.getDriver());
    }

    @And("I fill in the login and password fields")
    public void setLoginPassword() throws InterruptedException {
        BookingBaseSteps.createAccount(bookingHomePage, disposableEmail);
    }

    @When("I confirm registration on booking.com")
    public void confirmRegistration() throws InterruptedException {
        bookingHomePage.buttonClosePopUpWindow_XPATH.click();
        bookingHomePage.bannerBlock.notifications_XPATH.click();
        bookingHomePage.bannerBlock.activationLetter_XPATH.click();
        new OpenMyGMailSteps().OpenAndFindEmailMyGMail(ConfigProperties.read("GMAIL_USERNAME"),
                ConfigProperties.read("GMAIL_PASSWORD"));
    }
    @And("I return to booking.com to check in the registration")
    public void returnBooking() throws InterruptedException {
        ArrayList<String> windowHandles = new ArrayList<String>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(windowHandles.get(2));
        bookingHomePage = new BookingHomePage(Driver.getDriver());
    }

    @And("I write the login and password of my booking.com account to a file")
    public void writeFail() throws InterruptedException {
        String resultFile = GetPath.getPathProperties("login_password_Boking.txt");
        WriteReadFail.writerToFile(resultFile, disposableEmail, BookingBaseSteps.getPasswordBooking());
    }

    @Then("Checking registration on booking.com")
    public void checkRegistration() {
        assert bookingHomePage.bannerConfirmation_XPATH.isDisplayed() : "Account not activated";
    }

    @And("I log out of my booking.com account")
    public void finished(){
        bookingHomePage = new BookingHomePage(Driver.getDriver());
        BookingBaseSteps.signOut(bookingHomePage);
    }

}
