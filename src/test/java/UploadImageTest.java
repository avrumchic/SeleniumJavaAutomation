import PageObjects.*;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.logging.Logger;

@Listeners({TestListenerAdapter.class})
public class UploadImageTest extends BaseTest {
    Logger logger = Logger.getLogger(BaseTest.class.getName());

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
    @Test
    public void test() {
        Reporter.log("Verify image upload");
        loginPage.login();

        topToolBar = new TopToolBar(driver);
        mediaLibraryPage = topToolBar.clickOnMediaLibraryButtonAndGoToMediaLibPage();

        randomPubId = "PubId_" + System.currentTimeMillis();

        mediaLibraryPage.uploadAnyImageFromWeb(randomPubId, null)
                .rightClickImageByImageNameAndClickOnMenuItem(randomPubId, ImageTilePage.ImageTileRightClickOptions.MANAGE);

        manageImagePage = new ManageImagePage(driver);
        Assert.assertEquals(manageImagePage.getItemTitle(), randomPubId);
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
