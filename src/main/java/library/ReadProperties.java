package library;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    public static Properties readPropertiesFile() {
        Properties prop = new Properties();
        try (FileInputStream fis = new FileInputStream("./Properties/Packt.properties")) {
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}