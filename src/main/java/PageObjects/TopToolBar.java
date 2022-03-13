package PageObjects;

import Controls.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopToolBar extends BasePage {

    private final String MediaLibraryButtonCss = "[data-balloon=\"Media Library\"]";
    private final String TransformationButtonCss = "[data-balloon=\"Transformations\"]";
    private final String ReportsButtonCss = "[data-balloon=\"Transformations\"]";
    private final String AddOnsButtonCss = "[data-balloon=\"Add-ons\"]";

    public Button mediaLibraryButton;
    public Button TransformationButton;
    public Button ReportsButton;
    public Button AddOnsButton;

    public TopToolBar(WebDriver driver) {
        super(driver);

        mediaLibraryButton = new Button(driver, By.cssSelector(MediaLibraryButtonCss));
        TransformationButton = new Button(driver, By.cssSelector(TransformationButtonCss));
        ReportsButton = new Button(driver, By.cssSelector(ReportsButtonCss));
        AddOnsButton = new Button(driver, By.cssSelector(AddOnsButtonCss));
    }

    public MediaLibraryPage clickOnMediaLibraryButtonAndGoToMediaLibPage() {
        mediaLibraryButton.click();

        return new MediaLibraryPage(driver);
    }
}
