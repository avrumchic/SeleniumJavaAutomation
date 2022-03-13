package Controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Button extends BaseControl {

    public Button(WebDriver driver, By by) {
        super(driver, by);
    }

    public Button(WebDriver driver, WebElement elem) {
        super(driver, elem);
    }
}
