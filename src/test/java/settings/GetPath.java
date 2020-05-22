package settings;

import java.io.File;

public class GetPath {

    public static String getPathTestData(String fileName) {
        String pathDir = System.getProperty("user.dir") + File.separator ;
        String pathFolder = "src/test/java/test_data/";
        String path = "c:\\students\\Elena_Samuseva_htp_at_project\\src\\test\\java\\test_data\\";

//        return pathDir+pathFolder+fileName;
        return path+fileName;
    }
    public static String getPathProperties(Class<?> aClass) {
        String pathDir = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String pathFolder = aClass.getName().replace(aClass.getSimpleName(), "").replace(".", File.separator);
        return pathDir+pathFolder;
    }
}
