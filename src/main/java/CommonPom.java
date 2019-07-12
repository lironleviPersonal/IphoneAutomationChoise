import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class CommonPom {

    private static ThreadLocal<WebDriver> chromeDriverThread = new ThreadLocal<WebDriver>();

    public CommonPom(){
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        initCromeDriver();
        PageFactory.initElements(chromeDriverThread.get(), this);
    }

    protected void clickOnElement(WebElement element){
        element.click();
    }

    protected void sendKeysToAnInputBox(WebElement element, String searchKeyword){
        element.sendKeys(searchKeyword);
    }

    protected String getTextElement(WebElement element,String selector){
        Waiter.waitForTextToLoad(chromeDriverThread.get(),element,selector);
        Logs.debugging("The Selector that printed is " + selector + " value " + element.getText());
        return element.getText();
    }

    protected void navigateToWebstie(String url){
        chromeDriverThread.get().get(url);
    }

    private void initCromeDriver(){
        if(chromeDriverThread.get() == null) {
            chromeDriverThread.set( new ChromeDriver());
            chromeDriverThread.get().manage().window().maximize();
        }
    }

}
