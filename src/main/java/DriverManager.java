import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static ThreadLocal <WebDriver> drvierThreadPool = new ThreadLocal<WebDriver>();

    public static void setThreadLoacl(){
        if(drvierThreadPool.get() == null) {
            drvierThreadPool.set(CreateDriver.initDriver());
        }
    }
    public static WebDriver getChromeDriver(){
       return drvierThreadPool.get();
    }
}
