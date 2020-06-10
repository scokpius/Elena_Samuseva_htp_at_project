package steps;

import drivers.Driver;
import drivers.URL;
import skreens.gmail.GMailAccountPage;
import skreens.gmail.GMailHomePage;
import skreens.gmail.GMailMyPage;

import java.util.ArrayList;

public class OpenMyGMailSteps /*extends InitCloseDriverSteps*/ {
    private GMailHomePage gMailHomePage;
    private GMailAccountPage gMailAccountPage;
    private GMailMyPage gMailMyPage;

    public void OpenAndFindEmailMyGMail(String login, String password) throws InterruptedException {
        Driver.goToSite(URL.GMAIL);
        gMailHomePage = new GMailHomePage(Driver.getDriver());
        gMailHomePage.buttonToComeIn_XPATH.click();
        ArrayList<String> windowHandles = new ArrayList<String>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(windowHandles.get(1));
        loginGMail(login, password);
        gMailMyPage = new GMailMyPage(Driver.getDriver());
        Thread.sleep(8000); //надо
        gMailMyPage.firstEmail_XPATH.click();
        gMailMyPage.confirmationBooking();

    }

    private void loginGMail(String login, String password) {
        gMailAccountPage = new GMailAccountPage(Driver.getDriver());
        gMailAccountPage.setLoginGMail(login);
        gMailAccountPage.buttonLogin_ID.click();
        gMailAccountPage.setPasswordGMail(password);
        gMailAccountPage.buttonPassword_ID.click();
    }
}
