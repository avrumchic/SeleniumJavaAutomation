package PageObjects;

import Controls.TextBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;


public class ImageTilePage extends BasePage {
    Logger logger = Logger.getLogger(ImageTilePage.class.getName());

    public enum ImageTileRightClickOptions {
        MANAGE("[data-test=\"action-manage-btn\"]"),
        EDIT("[data-test=\"action-transform-btn\"]"),
        ANALYZE("[data-test=\"action-analyze-btn\"]"),
        COPY_URL("[data-test=\"action-copy-btn\"]"),
        DOWNLOAD("[data-test=\"action-download-btn\"]"),
        ADD_TO_COLLECTION("[data-test=\"action-addToCollection-btn\"]"),
        DELETE("[data-test=\"action-delete-btn\"]");

        private String locator;

        ImageTileRightClickOptions(String locator) {
            this.locator = locator;
        }

    }

    private final String RightClickMenuCss = "[data-test=\"popover\"]";
    private final String NameTextBoxCss = "[data-test=\"asset-info-text\"]";
    private final String ImageTileByIndexCss = "[data-item-index=\"%1$s\"]";

    private TextBox NameTextBox;
    private WebElement element;

    public ImageTilePage(WebDriver driver, String name) {
        super(driver);

        NameTextBox = new TextBox(driver, By.cssSelector(NameTextBoxCss));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(String.format("[alt=\"%1$s\"]", name))));
        try {
            element = driver.findElements(By.cssSelector(NameTextBoxCss))
                    .stream()
                    .filter(elem -> elem.getText().equals(name))
                    .collect(Collectors.toList())
                    .get(0);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Failed locating Image Tile Element with Name: " + name);
        }
    }

    public ImageTilePage(WebDriver driver, int index) {
        super(driver);

        NameTextBox = new TextBox(driver, By.cssSelector(NameTextBoxCss));
        try {
            element = driver.findElement(By.cssSelector(String.format(ImageTileByIndexCss, index)));
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Failed locating Image Tile Element with index: " + index);
        }
    }

    public WebElement getElement() {
        return element;
    }

    public void rightClickAndClickOnMenuOption(ImageTileRightClickOptions option) {
        actions.contextClick(element).build().perform();
        driver.findElement(By.cssSelector(option.locator)).click();
    }
}
