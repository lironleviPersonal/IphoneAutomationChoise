import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTests {
    protected WebDriver chromeDriver;
    private String url = "https://www.amazon.com/";

    public BaseTests(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/L/Desktop/chromedriver.exe");
        chromeDriver = new ChromeDriver();
    }

    protected void navigateToAmazonWebsite(){
        chromeDriver.get(url);
    }
}
