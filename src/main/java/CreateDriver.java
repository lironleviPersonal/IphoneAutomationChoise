import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateDriver {

    private static WebDriver driver = null;


    public static WebDriver initDriver() {
        if (PropertiesReader.getBrowser().equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (PropertiesReader.getBrowser().equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
             driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        return driver;
    }
}
