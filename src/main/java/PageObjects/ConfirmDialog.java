package PageObjects;

import Controls.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmDialog extends BasePage {

    private final String RootLocator = "[data-test=\"confirm-dialog\"]";
    private final String ConfirmButtonCss = "[data-test=\"confirm-dialog-confirm-btn\"]";
    private final String CancelButtonCss = "[data-test=\"confirm-dialog-cancel-btn\"]";

    private Button confirmButton;
    private Button cancelButton;

    public ConfirmDialog(WebDriver driver) {
        super(driver);

        confirmButton = new Button(driver, By.cssSelector(ConfirmButtonCss));
        cancelButton = new Button(driver, By.cssSelector(CancelButtonCss));
    }

    public Button getConfirmButton() {
        return confirmButton;
    }

    public Button getCancelButton() {
        return cancelButton;
    }
}
