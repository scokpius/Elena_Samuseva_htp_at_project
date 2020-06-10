package utility;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import object.City;
import object.Search;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class JsonParser {

    public static List<City> parseGSONCity(String path) throws IOException{
        Gson gson = new Gson();
        City[] cityArray = gson.fromJson(new JsonReader(new FileReader(path)), City[].class);
        List<City> cityList =  Arrays.asList(cityArray);
        return cityList;
    }

    public static String fromGSON(Search search){
        Gson gson= new Gson();
        return gson.toJson(search);

    }



}
