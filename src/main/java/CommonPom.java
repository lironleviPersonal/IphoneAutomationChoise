
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class CommonPom {

    public CommonPom(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    protected void clickOnElement(WebDriver driver, WebElement element){
        element.click();
    }

    protected void sendKeysToAnInputBox(WebDriver driver,WebElement element, String searchKeyword){
        element.sendKeys(searchKeyword);
    }

    protected String getTextElement(WebDriver driver, WebElement element,String selector){
        Waiter.waitForTextToLoad(driver,element,selector);
        Logs.debugging("The Selector that printed is " + selector);
        return element.getText();
    }

}
