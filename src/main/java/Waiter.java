import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Waiter {

    public static void waitForTextToLoad(WebDriver driver,WebElement element,final String selector) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(60, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(selector)));
        wait.until(ExpectedConditions.visibilityOfAllElements(element));


/*        WebElement elementA = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                System.out.println("polling");
                return driver.findElement(By.cssSelector(selector));
            }
        });*/
    }
}
