import PageObjects.*;
import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners({TestListenerAdapter.class})
@Epic("Regression Tests")
@Feature("Upload Image Test")
public class UploadImageTest extends BaseTest {
    Logger logger = LogManager.getLogger(BaseTest.class);

    private LoginPage loginPage;
    private TopToolBar topToolBar;
    private MediaLibraryPage mediaLibraryPage;
    private ManageImagePage manageImagePage;

    private String randomPubId = null;

    @BeforeMethod
    public void setup() {
        loginPage = new LoginPage(driver);
    }

    @Description("Verify image upload test")
    @Story("Verify Public ID is save correctly")
    @Test(priority = 0, description = "Verify image upload")
    public void verifyImageUploadTest() throws IOException {
        Allure.step("Login to app");
        loginPage.login();

        topToolBar = new TopToolBar(driver);
        Allure.step("Click on Media Library button");
        mediaLibraryPage = topToolBar.clickOnMediaLibraryButtonAndGoToMediaLibPage();

        randomPubId = "PubId_" + System.currentTimeMillis();

        Allure.step("Upload any image from web search");
        mediaLibraryPage.uploadAnyImageFromWeb(randomPubId, null)
                .rightClickImageByImageNameAndClickOnMenuItem(randomPubId, ImageTilePage.ImageTileRightClickOptions.MANAGE);
        takeScreenshot(driver, "After clicking menu item MANAGE");

        manageImagePage = new ManageImagePage(driver);
        Allure.step("Verify that correct pulicId is presented");
        takeScreenshot(driver, "Public Id");
        Assert.assertEquals(manageImagePage.getItemTitle(), randomPubId);
        Allure.step("Expected and actual PublicId are equal");
    }

    @AfterMethod
    public void localTearDown() {
        if (randomPubId != null) {
            manageImagePage.clickOnBackButton();
            mediaLibraryPage = new MediaLibraryPage(driver);
            mediaLibraryPage.rightClickImageByImageNameAndClickOnMenuItem(randomPubId, ImageTilePage.ImageTileRightClickOptions.DELETE);
            ConfirmDialog confirmDialog = new ConfirmDialog(driver);
            confirmDialog.getConfirmButton().click();
        }

    }
}
