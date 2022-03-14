import Utils.BrowserTypeEnum;
import Utils.GlobalProperties;
import Utils.WebDriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.Properties;
import java.util.logging.Logger;

public class BaseTest {
    private static Logger logger = Logger.getLogger(BaseTest.class.getName());


    protected WebDriver driver = null;
    protected Properties properties;

    @BeforeSuite
    public void initAll() {
        this.properties = new GlobalProperties().getProperties();
    }

    @BeforeMethod
    public void setUp() {
        this.driver = new WebDriverBase().getDriver(BrowserTypeEnum.fromString(properties.getProperty("browser")));
        driver.get(properties.getProperty("url"));
    }

    @AfterMethod
    public void tearDown() {
        this.driver.quit();
    }
}
