package classwork.utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.json.JSONObject;
import classwork.objeсt.Ingredient;
import classwork.objeсt.Recipe;
import classwork.objeсt.Search;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonParser {
//    private final static String JSON = "D:\\students\\Samuseva\\Elena_Samuseva_htp_at_project\\src\\test\\java\\test_data\\recept.json";
    private final static String JSON = "c:\\students\\Elena_Samuseva_htp_at_project\\src\\test\\java\\classwork\\test_data\\  recept.json";
    private final static String JSON1 = "D:\\students\\Samuseva\\Elena_Samuseva_htp_at_project\\src\\test\\java\\test_data\\recept1.json";

    File file = new File(JSON);

    public void parserJSON() throws IOException {
        String input = new String(Files.readAllBytes(Paths.get(JSON)));
        JSONObject obj = new JSONObject(input);
        System.out.println(obj.getString("reciprname"));
        System.out.println(obj.getJSONArray("ingredlist").getJSONObject(0).getString("itemdescription"));
    }
    public void parseGSON() throws IOException{
        Gson gson = new Gson();
        Recipe recipe = gson.fromJson(new JsonReader(new FileReader(JSON)),Recipe.class);
        System.out.println(recipe.reciprname);
        System.out.println(recipe.ingredlist[0].itemdescription);

    }
    public void parseJackson () throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        Recipe recipe = mapper.readValue(file, Recipe.class);
        System.out.println(recipe.reciprname);
        System.out.println(recipe.ingredlist[2].itemdescription);
    }


    public void fromGSON() throws FileNotFoundException{
        Gson gson= new Gson();
        Recipe recipe = new Recipe("Borsch", new Ingredient[]{},120);
       // Files.write() запись в файл
        System.out.println(gson.toJson(recipe));

    }
    public static String fromGSON(Search search){
        Gson gson= new Gson();
        return gson.toJson(search);

    }

}
