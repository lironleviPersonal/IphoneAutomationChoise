import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class CommonPom {


    public CommonPom(){
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        PageFactory.initElements(DriverManager.getChromeDriver(), this);
    }

    protected void clickOnElement(WebElement element){
        element.click();
    }

    protected void sendKeysToAnInputBox(WebElement element, String searchKeyword){
        element.sendKeys(searchKeyword);
    }

    protected String getTextElement(WebElement element,String selector){
        Waiter.waitForTextToLoad(DriverManager.getChromeDriver(),element,selector);
        Logs.debugging("The Selector that printed is " + selector + " value " + element.getText());
        return element.getText();
    }

    protected void navigateToWebstie(String url){
        DriverManager.getChromeDriver().get(url);
    }

}
