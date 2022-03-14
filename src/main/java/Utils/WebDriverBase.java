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
                if (getOsName().contains("mac")) {
                    System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
                } else if (getOsName().contains("win")) {
                    String resourcePath = this.getClass().getClassLoader().getResource("chromedriver.exe").getPath();
                    System.setProperty("webdriver.chrome.driver", resourcePath);
                }
                this.driver = new ChromeDriver();
            } else if (browserType.equals(BrowserTypeEnum.FIREFOX)) {
                this.driver = new FirefoxDriver();
            } else if (browserType.equals(BrowserTypeEnum.SAFARI)) {
                this.driver = new SafariDriver();
            }
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return this.driver;
    }

    public void quit() {
        this.driver.quit();
    }

    private String getOsName() {
        return System.getProperty("os.name").toLowerCase();
    }

}
