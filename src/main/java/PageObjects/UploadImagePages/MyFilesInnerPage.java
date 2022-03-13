package PageObjects.UploadImagePages;

import Controls.Button;
import PageObjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyFilesInnerPage extends BasePage {

    private final String BrowseButtonCss = ".upload_button_holder .BUTTON";

    private Button browseButton;

    public MyFilesInnerPage(WebDriver driver) {
        super(driver);

        browseButton = new Button(driver, By.cssSelector(BrowseButtonCss));
    }
}
