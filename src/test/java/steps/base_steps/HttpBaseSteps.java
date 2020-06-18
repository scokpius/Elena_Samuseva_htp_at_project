package steps.base_steps;


import com.google.gson.Gson;
import drivers.URL;
import object.MyUser;
import object.Search;
import object.WebServisObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import utility.JsonParser;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class HttpBaseSteps {

    private static final Logger LOGGER = LogManager.getLogger(HttpBaseSteps.class);

    public static String searchWebServis(Search search) throws URISyntaxException, IOException {
        LOGGER.debug("Getting a response from WebService");
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder builder = new URIBuilder(URL.WS);
        HttpPost request = new HttpPost(builder.build());
        request.setEntity(new StringEntity(JsonParser.fromGSON(search)));
        HttpResponse response = client.execute(request);
        return EntityUtils.toString(response.getEntity());
    }
    public static int equalsUser(WebServisObject webServisObject, List<MyUser> result) {
        LOGGER.debug("Comparing the list of objects of class USER when there are more than one");
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

}
