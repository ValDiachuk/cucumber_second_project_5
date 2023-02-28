package utilities;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    //help us read properties file
    private static Properties properties = new Properties();

    static{
        try {
            //open file
            FileInputStream fileInputStream = new FileInputStream("config.properties");

            //load / read the content
            properties.load(fileInputStream);

            //close
            fileInputStream.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}
