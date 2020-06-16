package steps.base_steps;

import drivers.Driver;
import drivers.URL;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import skreens.gmail.GMailAccountPage;
import skreens.gmail.GMailHomePage;
import skreens.gmail.GMailMyPage;

import java.util.ArrayList;

public class OpenMyGMailSteps {
    private GMailHomePage gMailHomePage;
    private GMailAccountPage gMailAccountPage;
    private GMailMyPage gMailMyPage;

    private static final Logger LOGGER = LogManager.getLogger(BookingLoginPasswordSteps.class);

    public void OpenAndFindEmailMyGMail(String login, String password) throws InterruptedException {
        LOGGER.info("Transition to Gmail.com to confirm registration at booking.com");
        Driver.goToSite(URL.GMAIL);
        gMailHomePage = new GMailHomePage(Driver.getDriver());
        gMailHomePage.buttonToComeIn_XPATH.click();
        ArrayList<String> windowHandles = new ArrayList<String>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(windowHandles.get(1));
        loginGMail(login, password);
        gMailMyPage = new GMailMyPage(Driver.getDriver());
        Thread.sleep(8000);
        gMailMyPage.firstEmail_XPATH.click();
        gMailMyPage.confirmationBooking();

    }
    private void loginGMail(String login, String password) {
        gMailAccountPage = new GMailAccountPage(Driver.getDriver());
        gMailAccountPage.setLoginGMail(login);
        gMailAccountPage.buttonLogin_ID.click();
        gMailAccountPage.setPasswordGMail(password);
        gMailAccountPage.buttonPassword_ID.click();
        LOGGER.info("Filling in the login fields and password to enter the account.");
    }
}
