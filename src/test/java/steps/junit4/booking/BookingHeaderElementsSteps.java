package steps.junit4.booking;

import drivers.Driver;
import drivers.URL;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import skreens.booking.BookingHomePage;
import steps.base_steps.BookingBaseSteps;


public class BookingHeaderElementsSteps /*extends InitCloseDriverSteps */{
    private BookingHomePage bookingHomePage;

    private static final Logger LOGGER = LogManager.getLogger(BookingHeaderElementsSteps.class);

    @Before
    public void properties(){
        LOGGER.info("---------------------------Test started---------------------------");
        Driver.goToSite(URL.BOOKING);
        bookingHomePage = new BookingHomePage(Driver.getDriver());
    }

    @Test
    public void BookingHeaderElements(){
        BookingBaseSteps.currentAccount(bookingHomePage);
        BookingBaseSteps.checkIfTheItemIsDisplayed(bookingHomePage.bannerBlock.blueBannerFirst_ID, "blueBannerFirst_ID");
        BookingBaseSteps.checkIfTheItemIsDisplayed(bookingHomePage.bannerBlock.stringBookingCom_ID, "stringBookingCom_ID");
        BookingBaseSteps.checkIfTheItemIsDisplayed(bookingHomePage.bannerBlock.currencySelection_XPATH, "currencySelection_XPATH");
        BookingBaseSteps.checkIfTheItemIsDisplayed(bookingHomePage.bannerBlock.languageSelection_XPATH, "languageSelection_XPATH");
        BookingBaseSteps.checkIfTheItemIsDisplayed(bookingHomePage.bannerBlock.notifications_XPATH,"notifications_XPATH");
        BookingBaseSteps.checkIfTheItemIsDisplayed(bookingHomePage.bannerBlock.customerSupportCenter_XPATH,"customerSupportCenter_XPATH");
        BookingBaseSteps.checkIfTheItemIsDisplayed(bookingHomePage.bannerBlock.buttonRegisterObject_ID,"buttonRegisterObject_ID");
        BookingBaseSteps.checkIfTheItemIsDisplayed(bookingHomePage.bannerBlock.buttonAccountCreate_ID,"buttonAccountCreate_ID");
        BookingBaseSteps.checkIfTheItemIsDisplayed(bookingHomePage.bannerBlock.buttonCurrentAccount_ID,"buttonCurrentAccount_ID");
        BookingBaseSteps.checkIfTheItemIsDisplayed(bookingHomePage.bannerBlock.blueBannerSecond_ID,"blueBannerSecond_ID");
        BookingBaseSteps.checkIfTheItemIsDisplayed(bookingHomePage.bannerBlock.housingTab_XPATH,"housingTab_XPATH");
        BookingBaseSteps.checkIfTheItemIsDisplayed(bookingHomePage.bannerBlock.flightsTab_XPATH,"flightsTab_XPATH");
        BookingBaseSteps.checkIfTheItemIsDisplayed(bookingHomePage.bannerBlock.carRentalTab_XPATH,"carRentalTab_XPATH");
        BookingBaseSteps.checkIfTheItemIsDisplayed(bookingHomePage.bannerBlock.leisureTab_XPATH,"leisureTab_XPATH");
        BookingBaseSteps.checkIfTheItemIsDisplayed(bookingHomePage.bannerBlock.taxiTab_XPATH,"taxiTab_XPATH");
    }

    @After
    public void finished(){
        BookingBaseSteps.signOut(bookingHomePage);
        LOGGER.info("---------------------------Test finished--------------------------");
    }
}
