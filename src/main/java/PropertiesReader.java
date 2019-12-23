import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    private static PropertiesReader propertiesReaderInstance = null;
    private static   String url = null;
    private static String browser = null;

    private PropertiesReader() {
        setProperties();
    }

    public static PropertiesReader getInstance() {
        if (propertiesReaderInstance == null) {
            propertiesReaderInstance = new PropertiesReader();
        }
        return propertiesReaderInstance;
    }

    public static String getUrl(){
        return url;
    }

    public static String getBrowser(){
        return browser;
    }

    private void setProperties() {
        try {
            InputStream inputStream = new FileInputStream("src/main/resources/config.properties");

            Properties properties = new Properties();
            properties.load(inputStream);
            url = properties.getProperty("prodUrl");
            browser = properties.getProperty("browser");

        } catch (FileNotFoundException e) {
            Logs.error("File Not Found In readProperties");
        } catch (IOException e) {
            Logs.error(e.getMessage());
        }
    }
}
