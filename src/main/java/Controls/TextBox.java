package Controls;

import io.netty.util.internal.StringUtil;
import org.openqa.selenium.*;

public class TextBox extends BaseControl {

    public TextBox(WebDriver driver, By by) {
        super(driver, by);
    }

    public TextBox(WebDriver driver, WebElement elem) {
        super(driver, elem);
    }

    public WebElement setText(String text) {
        clearText();
        try {
            element.sendKeys(text);
        } catch (ElementNotInteractableException e) {
            element.click();
            actions.sendKeys(text).build().perform();
        }
        return element;
    }

    public WebElement addText(String text) {
        element.sendKeys(text);
        return element;
    }

    public WebElement clearText() {
        element.click();
        if (!StringUtil.isNullOrEmpty(element.getText())) {
            element.clear();
        }
        return element;
    }
}
