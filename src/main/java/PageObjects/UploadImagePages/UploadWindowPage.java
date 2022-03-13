package PageObjects.UploadImagePages;

import Controls.Button;
import Controls.TextBox;
import PageObjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UploadWindowPage extends BasePage {

    private final String ImageSearchButtonCss = "[data-id=\"image_search\"] button";
    private final String UploadButtonCss = "[data-test=\"upload-btn\"]";

    private final String AdvancedButtonCss = "[data-test=\"btn-advanced\"] button:last-of-type";
    private final String AdvancedBoxCss = "[data-test=\"advanced-box\"]";
    private final String PublicIdTextBoxCss = ".field.id";
    private final String TagTextBoxCss = ".field.tag";

    private Button browseButton;
    private Button imageSearch;
    private Button uploadButton;
    private Button advancedButton;

    public UploadWindowPage(WebDriver driver) {
        super(driver);

        wait.until(ExpectedConditions.attributeContains(By.cssSelector("[class=\"bg-color\"]"), "style", "overflow: hidden;"));
        driver.switchTo().frame(1);

        imageSearch = new Button(driver, By.cssSelector(ImageSearchButtonCss));
        advancedButton = new Button(driver, By.cssSelector(AdvancedButtonCss));
    }


    public UploadWindowPage selectRandomImageFromImageSearch() {
        imageSearch.click();
        ImageSearchInnerPage innerPage = new ImageSearchInnerPage(driver);
        innerPage.searchImageAndSelectFirst("Any Image");

        return this;
    }

    public UploadWindowPage setAdvancedPublicId(String publicId) {
        if (publicId == null) {
            return this;
        }
        advancedButton.click();
        new TextBox(driver, By.cssSelector(PublicIdTextBoxCss)).setText(publicId);
        advancedButton.click();

        return this;
    }

    public UploadWindowPage setAddTag(String tag) {
        if (tag == null) {
            return this;
        }
        advancedButton.click();
        new TextBox(driver, By.cssSelector(TagTextBoxCss)).setText(tag);
        advancedButton.click();

        return this;
    }

    public Button getUploadButton() {
        uploadButton = new Button(driver, By.cssSelector(UploadButtonCss));
        return uploadButton;
    }

}
