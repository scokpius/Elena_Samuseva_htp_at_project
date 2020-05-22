package utility;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import object.DataCity;

import java.io.*;

public class JsonParser {


    public static DataCity parseGSON(String path) throws IOException{
        Gson gson = new Gson();
        DataCity city = gson.fromJson(new JsonReader(new FileReader(path)), DataCity.class);
        return city;
    }


}
