package utility;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import object.City;
import object.Search;
import object.MyUser;
import object.WebServisObject;
import org.apache.http.util.EntityUtils;
import settings.GetPath;

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

    public static Search[] getSearchData(Gson gson, String fileName) throws FileNotFoundException {
        Search[] searchData = gson.fromJson(new JsonReader(new FileReader(
                GetPath.getPathTestData(fileName))), Search[].class);
        return searchData;
    }
    public static List<MyUser> getResultData(Gson gson, String fileName) throws FileNotFoundException {
        MyUser[] userArray = gson.fromJson(new JsonReader(new FileReader(
                GetPath.getPathTestData(fileName))), MyUser[].class);
        List<MyUser> myUserList = Arrays.asList(userArray);
        return myUserList;
    }
    public static WebServisObject getWebServisData(Gson gson, String search) {
        WebServisObject webServisObject = gson.fromJson(search, WebServisObject.class);
        return webServisObject;
    }

}
