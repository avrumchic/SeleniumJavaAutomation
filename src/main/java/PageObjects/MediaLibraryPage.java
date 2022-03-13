package PageObjects;

import Controls.Button;
import PageObjects.UploadImagePages.UploadWindowPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MediaLibraryPage extends BasePage {

    private final String uploadButtonCss = "[data-test=\"upload-btn\"]:nth-of-type(1)";

    private Button uploadButton;

    private ImageTilePage imageTilePage;

    public MediaLibraryPage(WebDriver driver) {
        super(driver);
        imageTilePage = new ImageTilePage(driver, 0);
        uploadButton = new Button(driver, By.cssSelector(uploadButtonCss));
    }

    public UploadWindowPage clickOnUploadButtonAndGoToUploadPage() {
        uploadButton.click();
        return new UploadWindowPage(driver);
    }

    public MediaLibraryPage uploadAnyImageFromWeb(String publicId, String tag) {
        clickOnUploadButtonAndGoToUploadPage()
                .setAdvancedPublicId(publicId)
                .selectRandomImageFromImageSearch()
                .setAddTag(tag)
                .getUploadButton().click();

        driver.switchTo().defaultContent();

        return new MediaLibraryPage(driver);
    }

    public void rightClickImageByIndexAndClickOnMenuItem(int index, ImageTilePage.ImageTileRightClickOptions option) {
        ImageTilePage image = new ImageTilePage(driver, index);
        image.rightClickAndClickOnMenuOption(option);
    }

    public void rightClickImageByImageNameAndClickOnMenuItem(String name, ImageTilePage.ImageTileRightClickOptions option) {
        ImageTilePage image = new ImageTilePage(driver, name);
        image.rightClickAndClickOnMenuOption(option);
    }
}
