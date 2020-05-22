package classwork.objeсt;



import classwork.objeсt.Search;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import classwork.utility.JsonParser;

import java.io.IOException;
import java.net.URISyntaxException;

public class MyHttpClient {
//    public static void main(String[] args) throws URISyntaxException, IOException {
//        HttpClient client = HttpClientBuilder.create().build();
//        URIBuilder builder = new URIBuilder("http://www.nbrb.by/api/exrates/currencies/1");
//        HttpGet request = new HttpGet(builder.build());
//        HttpResponse response = client.execute(request);
//        System.out.println(EntityUtils.toString(response.getEntity()));
//    }
    public static void search(Search search) throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder builder = new URIBuilder("http://178.124.206.46:8001/app/ws/");
        HttpPost request = new HttpPost(builder.build());
        request.setEntity(new StringEntity(JsonParser.fromGSON(search)));
        HttpResponse response = client.execute(request);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        Search search = new Search("a",true);
        search(search);
    }
}
