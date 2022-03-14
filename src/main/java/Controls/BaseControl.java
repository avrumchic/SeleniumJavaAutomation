package Controls;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseControl {
    Logger logger = LogManager.getLogger(BaseControl.class);

    private final int TimeOutIsSeconds = 10;
    protected WebDriver driver;
    protected WebElement element;
    protected Actions actions;
    public WebDriverWait wait;


    public BaseControl(WebDriver driver, By by) {
        this.driver = driver;
        this.actions = new Actions(driver);
        wait = new WebDriverWait(driver, TimeOutIsSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        this.element = driver.findElement(by);
    }

    public BaseControl(WebDriver driver, WebElement element) {
        this.driver = driver;
        this.actions = new Actions(driver);
        wait = new WebDriverWait(driver, TimeOutIsSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
        this.element = element;
    }

    public WebElement getElement() {
        return this.element;
    }

    public WebElement getAncestorElement() {
        return this.element.findElement(By.xpath(".//.."));
    }

    public WebElement click() {
        logger.info("Clicking element");
        try {
            element.click();
        } catch (ElementNotInteractableException e) {
            actions.moveByOffset(element.getLocation().getX(), element.getLocation().getY()).click().build().perform();
        }
        return element;
    }

    public void rightClick() {
        actions.contextClick(element).build().perform();
    }

    public String getText() {
        return element.getText();
    }
}
