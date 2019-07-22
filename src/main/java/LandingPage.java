import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends CommonPom {
    private  String url = null;

    @FindBy (id = "twotabsearchtextbox")
    private WebElement searchField;

    @FindBy(xpath = "//*[@class = 'nav-input' and @type='submit']")
    private WebElement submitSearch;

    public LandingPage(){
        super();
        url = PropertiesReader.getUrl();
    }

    protected void navigateToAmazonWebsite(){
        navigateToWebstie(url);
    }

    protected void typeSerchResults() {
        sendKeysToAnInputBox(searchField,"Iphone 6");
    }

    protected void submitSearch(){
        clickOnElement(submitSearch);
    }
}

