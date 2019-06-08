import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FindCheapIphone {

    private WebDriver chromeDriver;

    @BeforeClass
    public void initWebDriver() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/L/Desktop/chromedriver.exe");
        chromeDriver = new ChromeDriver();
    }

    @Test
    public void findcheaperIphoneFromAmazone() {
        IphoneSix iphone;
        chromeDriver.get("https://www.amazon.com/");

        LendingPage landingPage = PageFactory.initElements(chromeDriver, LendingPage.class);
        landingPage.typeAndSubmitTextInSerchField();

        IphoneSixSearchResults IphoneSixSearchResults = PageFactory.initElements(chromeDriver, IphoneSixSearchResults.class);
        iphone = IphoneSixSearchResults.returnBestIphoneChoise();

        EMail mail = new EMail(iphone.getName(),Double.toString(iphone.getPrice()));
        mail.sendMail();


    }
}
