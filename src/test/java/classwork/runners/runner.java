package classwork.runners;

import org.xml.sax.SAXException;
import classwork.utility.JsonParser;

import java.io.IOException;
import java.net.URISyntaxException;

public class runner {
    static JsonParser jsonParser = new JsonParser();

    public static void main(String[] args) throws IOException, SAXException, URISyntaxException {
//        jsonParser.parserJSON();
//        jsonParser.parseGSON();
//        jsonParser.parseJackson();
        jsonParser.fromGSON();

    }
}
