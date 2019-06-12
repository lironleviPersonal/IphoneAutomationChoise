import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LendingPage extends CommonPom {

    @FindBy (id = "twotabsearchtextbox") private WebElement searchField;
    @FindBy(xpath = "//*[@id=\"nav-search\"]/form/div[2]/div/input") private WebElement submitSearch;

    public LendingPage(WebDriver driver){
        super(driver);
    }

    public void typeAndSubmitTextInSerchField(WebDriver driver) {
        sendKeysToAnInputBox(driver,searchField,"Iphone 6");
        clickOnElement(driver,submitSearch);
    }
}
