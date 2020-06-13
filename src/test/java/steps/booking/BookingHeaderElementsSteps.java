package steps.booking;

import drivers.Driver;
import drivers.URL;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import skreens.booking.BookingHomePage;
import steps.base_steps.BookingLoginPasswordSteps;
import steps.base_steps.InitCloseDriverSteps;


import java.util.NoSuchElementException;

public class BookingHeaderElementsSteps extends InitCloseDriverSteps {
    private BookingHomePage bookingHomePage;

    @Before
    public void properties(){
        Driver.goToSite(URL.BOOKING);
        bookingHomePage = new BookingHomePage(Driver.getDriver());
    }

    @Test
    public void BookingHeaderElements() throws InterruptedException {
        BookingLoginPasswordSteps.currentAccount(bookingHomePage);

        checkIfTheItemIsDisplayed(bookingHomePage.bannerBlock.blueBannerFirst_ID, "blueBannerFirst_ID");
        checkIfTheItemIsDisplayed(bookingHomePage.bannerBlock.stringBookingCom_ID, "stringBookingCom_ID");
        checkIfTheItemIsDisplayed(bookingHomePage.bannerBlock.currencySelection_XPATH, "currencySelection_XPATH");
        checkIfTheItemIsDisplayed(bookingHomePage.bannerBlock.languageSelection_XPATH, "languageSelection_XPATH");
        checkIfTheItemIsDisplayed(bookingHomePage.bannerBlock.notifications_XPATH,"notifications_XPATH");
        checkIfTheItemIsDisplayed(bookingHomePage.bannerBlock.customerSupportCenter_XPATH,"customerSupportCenter_XPATH");
        checkIfTheItemIsDisplayed(bookingHomePage.bannerBlock.buttonRegisterObject_ID,"buttonRegisterObject_ID");
        checkIfTheItemIsDisplayed(bookingHomePage.bannerBlock.buttonAccountCreate_ID,"buttonAccountCreate_ID");
        checkIfTheItemIsDisplayed(bookingHomePage.bannerBlock.buttonCurrentAccount_ID,"buttonCurrentAccount_ID");
        checkIfTheItemIsDisplayed(bookingHomePage.bannerBlock.blueBannerSecond_ID,"blueBannerSecond_ID");
        checkIfTheItemIsDisplayed(bookingHomePage.bannerBlock.housingTab_XPATH,"housingTab_XPATH");
        checkIfTheItemIsDisplayed(bookingHomePage.bannerBlock.flightsTab_XPATH,"flightsTab_XPATH");
        checkIfTheItemIsDisplayed(bookingHomePage.bannerBlock.carRentalTab_XPATH,"carRentalTab_XPATH");
        checkIfTheItemIsDisplayed(bookingHomePage.bannerBlock.leisureTab_XPATH,"leisureTab_XPATH");
        checkIfTheItemIsDisplayed(bookingHomePage.bannerBlock.taxiTab_XPATH,"taxiTab_XPATH");

    }

    public void checkIfTheItemIsDisplayed(WebElement element, String nameElement) {
        try{
            Assert.assertTrue(element.isDisplayed());
            System.out.println( "This item was found on the page: " + nameElement+".");
//        }catch (NoSuchElementException e){
        }catch (Exception e){
            System.err.println( "This item was not found on the page: " + nameElement+".");
        }
    }
}
