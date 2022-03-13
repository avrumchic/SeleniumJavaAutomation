package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverBase {

    public WebDriver driver = null;

    public WebDriver getDriver(BrowserTypeEnum browserType) {
        if (this.driver != null) {
            return this.driver;
        } else {
            if (browserType.equals(BrowserTypeEnum.CHROME)) {
                System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
                this.driver = new ChromeDriver();
            } else if (browserType.equals(BrowserTypeEnum.FIREFOX)) {
                this.driver = new FirefoxDriver();
            } else if (browserType.equals(BrowserTypeEnum.SAFARI)) {
                this.driver = new SafariDriver();
            }
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return this.driver;
    }

    public void quit() {
        this.driver.quit();
    }

}
