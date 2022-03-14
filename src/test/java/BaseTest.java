import Utils.BrowserTypeEnum;
import Utils.GlobalProperties;
import Utils.WebDriverBase;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class BaseTest {
    private static Logger logger = LogManager.getLogger(BaseTest.class);


    protected WebDriver driver = null;
    protected Properties properties;

    @BeforeSuite
    public void initAll() {
        logger.info("Initializing suite");
        this.properties = new GlobalProperties().getProperties();
    }

    @BeforeMethod
    public void setUp() {
        logger.info(String.format("Setting up WebDriver [%1$s] and navigating to url: [%2$ss]",
                properties.getProperty("browser"), properties.getProperty("url")));
        this.driver = new WebDriverBase().getDriver(BrowserTypeEnum.fromString(properties.getProperty("browser")));
        driver.get(properties.getProperty("url"));
    }

    @AfterMethod
    public void tearDown() {
        logger.info("Global tearDown");
        this.driver.quit();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public void takeScreenshot(WebDriver driver) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        Date date = new Date();
        String fileName = sdf.format(date);
        File SrcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(SrcFile, new File(System.getProperty("user.dir") + "//allure-results//" + fileName + ".png"));
    }
}
