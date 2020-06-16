package steps.trashmail;

import drivers.Driver;
import drivers.URL;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import settings.ConfigProperties;
import skreens.trashmail.TrashMailHomePage;
import steps.base_steps.InitCloseDriverSteps;

public class TrashMailUserCreateSteps extends InitCloseDriverSteps {

    private TrashMailHomePage trashMailHomePage;

    private static final Logger LOGGER = LogManager.getLogger(TrashMailUserCreateSteps.class);

    @Before
    public void properties(){
        LOGGER.info("---------------------------Test started---------------------------");
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

    @After
    public void finished(){
        LOGGER.info("---------------------------Test finished--------------------------");
    }
}
