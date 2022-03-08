package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        String path = "configuration.properties";
        try {
            FileInputStream input = new FileInputStream(path); // opens the file in the path
            properties = new Properties();
            properties.load(input); // loads the file details
        } catch (Exception e) {
            System.out.println("File could not be found!");
            e.printStackTrace();
        }
    }


    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
