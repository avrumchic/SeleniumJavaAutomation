package PageObjects;

import Utils.GlobalProperties;
import Utils.JSWaiter;
import Utils.WebDriverBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;

//Base page for all common functionality of all PageObjects
public class BasePage {

    Logger logger = LogManager.getLogger(BasePage.class);

    private final int TimeOutIsSeconds = 10;

    protected Properties properties;
    protected WebDriver driver;
    protected WebDriverBase webDriverBase;
    protected Actions actions;
    public WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.properties = new GlobalProperties().getProperties();
        this.actions = new Actions(driver);
        this.wait = new WebDriverWait(driver, TimeOutIsSeconds);

        JSWaiter.setDriver(driver);
        JSWaiter.waitUntilJSReady();
    }

    public Properties getProperties() {
        return properties;
    }
}
