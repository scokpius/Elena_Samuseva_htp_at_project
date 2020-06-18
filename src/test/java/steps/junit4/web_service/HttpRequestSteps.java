package steps.junit4.web_service;




import com.google.gson.Gson;
import object.MyUser;
import object.WebServisObject;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import steps.base_steps.HttpBaseSteps;
import utility.JsonParser;
import object.Search;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class HttpRequestSteps {
    private final String fileNameSearch = "data_test_WS.json";
    private final String fileNameResult = "data_test_result_WS.json";
    private Search[] search;
    private WebServisObject webServisObject;
    private List<MyUser> result;

    private static final Logger LOGGER = LogManager.getLogger(HttpRequestSteps.class);

    @Before
    public void precondition() throws FileNotFoundException {
        LOGGER.info("---------------------------Test finished--------------------------");
        search = JsonParser.getSearchData(new Gson(), fileNameSearch);
        result = JsonParser.getResultData(new Gson(), fileNameResult);
    }

    @Test
    public void searchUserByFullNameShort() throws IOException, URISyntaxException {
        webServisObject = JsonParser.getWebServisData(new Gson(), HttpBaseSteps.searchWebServis(search[0]));
        Assert.assertEquals("Objects are not the same.", webServisObject.data[0], result.get(0));
    }
    @Test
    public void searchUserByFullNameLong() throws IOException, URISyntaxException {
        webServisObject = JsonParser.getWebServisData(new Gson(), HttpBaseSteps.searchWebServis(search[1]));
        Assert.assertEquals("Objects are not the same.", webServisObject.data[0], result.get(1));
    }
    @Test
    public void searchUserByPartialNameShort() throws IOException, URISyntaxException {
        webServisObject = JsonParser.getWebServisData(new Gson(), HttpBaseSteps.searchWebServis(search[2]));
        Assert.assertEquals("Objects are not the same.", HttpBaseSteps.equalsUser(webServisObject,result),
                webServisObject.data.length);
    }
    @Test
    public void searchUserByPartialNameLong() throws IOException, URISyntaxException {
        webServisObject = JsonParser.getWebServisData(new Gson(), HttpBaseSteps.searchWebServis(search[3]));
        Assert.assertEquals("Objects are not the same.", webServisObject.data[0], result.get(5));
    }
    @Test
    public void searchAllUser() throws IOException, URISyntaxException {
        webServisObject = JsonParser.getWebServisData(new Gson(), HttpBaseSteps.searchWebServis(search[4]));
        Assert.assertEquals("Objects are not the same.", HttpBaseSteps.equalsUser(webServisObject,result),
                webServisObject.data.length);
    }

    @After
    public void finished(){
        LOGGER.info("---------------------------Test finished--------------------------");
    }
}
