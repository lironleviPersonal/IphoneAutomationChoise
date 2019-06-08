import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LendingPage {
    @FindBy (how = How.ID, using =  "twotabsearchtextbox") private WebElement searchField;

    @FindBy(how = How.XPATH, using = "//*[@id=\"nav-search\"]/form/div[2]/div/input") private WebElement submitSearch;

    public  void typeAndSubmitTextInSerchField() {
        searchField.sendKeys("Iphone 6");
        submitSearch.click();
    }
}
