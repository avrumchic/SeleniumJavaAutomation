package PageObjects;

import Utils.GlobalProperties;
import Utils.JSWaiter;
import Utils.WebDriverBase;
import io.netty.util.internal.StringUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;
import java.util.logging.Logger;

public class BasePage {

    Logger logger = Logger.getLogger(BasePage.class.getName());

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
