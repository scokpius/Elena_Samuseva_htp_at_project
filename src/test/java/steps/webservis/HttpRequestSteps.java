package steps.webservis;




import com.google.gson.Gson;
import drivers.URL;
import object.MyUser;
import object.WebServisObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
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

    @Before
    public void precondition() throws FileNotFoundException {
        search = JsonParser.getSearchData(new Gson(), fileNameSearch);
        result = JsonParser.getResultData(new Gson(), fileNameResult);
    }

    @Test
    public void searchUserByFullNameShort() throws IOException, URISyntaxException {
        webServisObject = JsonParser.getWebServisData(new Gson(), searchWebServis(search[0]));
        Assert.assertEquals("Objects are not the same.", webServisObject.data[0], result.get(0));
    }
    @Test
    public void searchUserByFullNameLong() throws IOException, URISyntaxException {
        webServisObject = JsonParser.getWebServisData(new Gson(), searchWebServis(search[1]));
        Assert.assertEquals("Objects are not the same.", webServisObject.data[0], result.get(1));
    }
    @Test //дописать
    public void searchUserByPartialNameShort() throws IOException, URISyntaxException {
        webServisObject = JsonParser.getWebServisData(new Gson(), searchWebServis(search[2]));
        Assert.assertEquals("Objects are not the same.", equalsUser(webServisObject,result),
                webServisObject.data.length);
    }
    @Test
    public void searchUserByPartialNameLong() throws IOException, URISyntaxException {
        webServisObject = JsonParser.getWebServisData(new Gson(), searchWebServis(search[3]));
        Assert.assertEquals("Objects are not the same.", webServisObject.data[0], result.get(5));
    }
    @Test//дописать
    public void searchAllUser() throws IOException, URISyntaxException {
        webServisObject = JsonParser.getWebServisData(new Gson(), searchWebServis(search[4]));
        Assert.assertEquals("Objects are not the same.", equalsUser(webServisObject,result),
                webServisObject.data.length);
    }

    private int equalsUser(WebServisObject webServisObject, List<MyUser> result) {
        int count = 0;
        for (int i = 0; i < webServisObject.data.length; i++) {
            for (int j = 0; j < result.size() ; j++) {
                if (result.get(j).equals(webServisObject.data[i])) {
                    count++;
                    break;
                }
            }

        }
        return count;
    }

    public static String searchWebServis(Search search) throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder builder = new URIBuilder(URL.WS);
        HttpPost request = new HttpPost(builder.build());
        request.setEntity(new StringEntity(JsonParser.fromGSON(search)));
        HttpResponse response = client.execute(request);
        return EntityUtils.toString(response.getEntity());
    }

}
