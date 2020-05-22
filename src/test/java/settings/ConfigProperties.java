package settings;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {
    private static Properties property;

    private static String pathTestData;

    public static void setPathTestData(String fileName) {
        ConfigProperties.pathTestData = GetPath.getPathTestData(fileName);
    }

    public static String read(String key){
        try (FileInputStream file = new FileInputStream(pathTestData)){
            ConfigProperties.property = new Properties();
            property.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return property.getProperty(key);
    }
}
