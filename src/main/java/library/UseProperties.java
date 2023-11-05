package library;

import java.util.Properties;

public class UseProperties {
    static Properties prop = ReadProperties.readPropertiesFile();

    public static String getBrowser() {
        return prop.getProperty("Browser", "chrome");
    }

    public static String getUrl() {
        return prop.getProperty("URL");
    }
}