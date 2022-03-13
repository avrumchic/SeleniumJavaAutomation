package PageObjects;

import Controls.Button;
import Controls.TextBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ManageImagePage extends BasePage {

    private final String ItemTitleCss = "[data-test=\"item-title\"]";
    private final String BackIconCss = "[data-test=\"back-arrow-button\"]";

    private TextBox itemTitleTextBox;
    private Button backIconButton;

    public ManageImagePage(WebDriver driver) {
        super(driver);

        itemTitleTextBox = new TextBox(driver, By.cssSelector(ItemTitleCss));
        backIconButton = new Button(driver, By.cssSelector(BackIconCss));
    }

    public String getItemTitle() {
        return itemTitleTextBox.getElement().getAttribute("value");
    }

    public MediaLibraryPage clickOnBackButton() {
        backIconButton.click();

        return new MediaLibraryPage(driver);
    }
}
