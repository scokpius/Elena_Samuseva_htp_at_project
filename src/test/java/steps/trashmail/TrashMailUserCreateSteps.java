package steps.trashmail;

import drivers.Driver;
import drivers.URL;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import settings.ConfigProperties;
import skreens.trashmail.TrashMailHomePage;
import steps.base_steps.InitCloseDriverSteps;

public class TrashMailUserCreateSteps extends InitCloseDriverSteps {

    private TrashMailHomePage trashMailHomePage;

    @Before
    public void properties(){
        Driver.goToSite(URL.TRASHMAIL);
        trashMailHomePage = new TrashMailHomePage(Driver.getDriver());
        ConfigProperties.setPathProperties("propertie_login.properties");
    }

    @Test
    public void CreateUser() throws InterruptedException {
        trashMailHomePage.createNewUser(ConfigProperties.read("TRASHMAIL_USERNAME"),
                ConfigProperties.read("TRASHMAIL_PASSWORD"), ConfigProperties.read("EMAIL"));
        Assert.assertTrue("Registration is failed.", trashMailHomePage.registrationTextMessageIsDisplayed());
    }





}
