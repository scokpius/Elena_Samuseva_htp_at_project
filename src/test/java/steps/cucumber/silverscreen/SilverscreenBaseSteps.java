package steps.cucumber.silverscreen;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import drivers.Driver;
import drivers.URL;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import settings.ConfigProperties;
import skreens.silverscreen.SilverscreenHomePage;

import java.io.IOException;

public class SilverscreenBaseSteps {
    private SilverscreenHomePage silverscreenHomePage;

    private static final Logger LOGGER = LogManager.getLogger(SilverscreenBaseSteps.class);

    @Before
    public void properties() throws IOException {
        LOGGER.info("---------------------------Test started---------------------------");
    }

    @Given("I open an app")
    public void openAnApp() {
        Driver.goToSite(URL.SILVERSCREEN);
        silverscreenHomePage = new SilverscreenHomePage(Driver.getDriver());
    }

    @When("I search for {string} word")
    public void searchForSearchWord(String searchWord) {
        silverscreenHomePage.search_CSS.click();
        silverscreenHomePage.setWordInSearch(searchWord);
    }

    @Then("I see the list of movie items")
    public void visibleListMovieItems() {
        assert silverscreenHomePage.listFilms_CSS.isDisplayed() : "The search has not given any results";
    }

    @And("each item name or description contains {string}")
    public void checkWordAvailability(String searchWord) {
        assert silverscreenHomePage.checkWordInList(searchWord) : String.format("The item doesn't contain %s", searchWord);
    }


    @When("I login with {string} and {string}")
    public void loginPassword(String login, String password) throws InterruptedException {
        silverscreenHomePage.setLoginPassword(login, password);
    }

    @Then("I can see Red Carpet Club {string} in upper right corner")
    public void checkLevelElements(String level) {
        assert silverscreenHomePage.checkLevel(level);
    }

    @When("I left blank {string} field")
    public void blankLoginField(String field) throws InterruptedException {
        ConfigProperties.setPathProperties("propertie_login.properties");
        switch (field) {
            case "login": {
                silverscreenHomePage.setLoginPassword("", ConfigProperties.read("GMAIL_PASSWORD"));

            }
            case "password": {
                silverscreenHomePage.setLoginPassword(ConfigProperties.read("EMAIL"), "");
                break;
            }
        }
    }

    @Then("I see {string} message")
    public void getMessage(String message) {
        assert silverscreenHomePage.massage_XPATH.getText().contains(message) : "No message on display.";

    }

//    @When("I login with {string} and {string}")
//    public void loginPasswordField(String login, String password) throws InterruptedException {
//        silverscreenHomePage.setLoginPassword(login, password);
//    }

    @Then("Now I see {string} message")
    public void messagePassword(String message) {
        assert silverscreenHomePage.massagePassword_XPATH.getText().contains(message);

    }

    @After
    public void finished() {
        LOGGER.info("---------------------------Test finished--------------------------");
    }
}
