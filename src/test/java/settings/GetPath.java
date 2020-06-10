package settings;

import java.io.File;

public class GetPath {

    public static String getPathTestData(String fileName) {
        String pathDir = System.getProperty("user.dir") + File.separator ;
        String pathFolder = "src/test/resources/test_data/";
        return pathDir+pathFolder+fileName;
    }
    public static String getPathProperties(String fileName) {
        String pathDir = System.getProperty("user.dir") + File.separator ;
        String pathFolder = "src/test/resources/";
        return pathDir+pathFolder+fileName;
    }
}
