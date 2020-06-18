package steps.cucumber.web_service;

import com.google.gson.Gson;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import object.MyUser;
import object.Search;
import object.WebServisObject;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import steps.base_steps.HttpBaseSteps;
import utility.JsonParser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class WebServiceCucumberSteps {
    private final String fileNameSearch = "data_test_WS.json";
    private final String fileNameResult = "data_test_result_WS.json";
    private Search[] search;
    private WebServisObject webServisObject;
    private List<MyUser> result;
    public static final String massege = "Web service response for search% s does not match expected";
    private static final Logger LOGGER = LogManager.getLogger(WebServiceCucumberSteps.class);

    @Before
    public void precondition() throws FileNotFoundException {
        LOGGER.info("---------------------------Test started--------------------------");
        result = JsonParser.getResultData(new Gson(), fileNameResult);
    }

    @Given("I get a list of searches for the web service")
    public void getSearchArray() throws IOException, URISyntaxException {
        search = JsonParser.getSearchData(new Gson(), fileNameSearch);
    }

    @When("I get a response from web service {int} with test data order")
    public void getResponseFromWebService(int index) throws IOException, URISyntaxException {
        webServisObject = JsonParser.getWebServisData(new Gson(), HttpBaseSteps.searchWebServis(search[index]));
    }

    @And("I get a list of expected results")
    public void getListExpectedResult() throws IOException, URISyntaxException {
        search = JsonParser.getSearchData(new Gson(), fileNameSearch);
    }

    @Then("I verify expected result equals actual {int} for {string} test")
    public void equalsExpectedAndActual(int index, String testType) {
        if (index != -1){
            assert webServisObject.data[0].equals(result.get(index)) : String.format(massege, testType);
        } else {
            assert HttpBaseSteps.equalsUser(webServisObject, result) == webServisObject.data.length :
                    String.format(massege, testType);
        }
    }

    @After
    public void finished() {
        LOGGER.info("---------------------------Test finished--------------------------");
    }
}


