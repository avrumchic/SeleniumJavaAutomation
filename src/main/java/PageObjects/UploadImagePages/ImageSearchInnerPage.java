package PageObjects.UploadImagePages;

import Controls.Button;
import Controls.TextBox;
import PageObjects.BasePage;
import PageObjects.MediaLibraryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ImageSearchInnerPage extends BasePage {

    private final String SearchInputCss = "[data-test=\"search-input\"]";
    private final String SearchButtonCss = "[data-test=\"do-search\"]";
    private final String ImageTileCss = "li.grid-tile";



    private TextBox imageSearchTextBox;
    private Button searchButton;

    private WebElement imageTile;

    public ImageSearchInnerPage(WebDriver driver) {
        super(driver);

        imageSearchTextBox = new TextBox(driver, By.cssSelector(SearchInputCss));
        searchButton = new Button(driver, By.cssSelector(SearchButtonCss));

    }

    public ImageSearchInnerPage searchImage(String text) {
        imageSearchTextBox.setText(text);
        searchButton.click();

        return this;
    }

    public ImageSearchInnerPage searchImageAndSelectFirst(String text) {
        searchImage(text);
        driver.findElements(By.cssSelector(ImageTileCss)).get(0).click();

        return this;
    }
}
