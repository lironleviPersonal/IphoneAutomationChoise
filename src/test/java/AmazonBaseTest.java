import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public abstract class AmazonBaseTest {

    @BeforeSuite
    public void beforeSuiteAction(){
        PropertiesReader.getInstance();
    }

    @BeforeClass
    public void beforeClasstInstance(){
        DriverManager.setThreadLoacl();
    }
}
