



package tests;

import org.testng.annotations.*;
import pages.FullScanPage;

public class FullScanTest {

    FullScanPage page;

    @BeforeMethod
    public void beforeMethod() {
        page = new FullScanPage();
        page.handlePopupsIfAny();
    }

    @Test(
            dependsOnMethods = {
                    "tests.PartialScanTest.partialScanFirstTimeTest"
            }
    )
    public void fullScanSecondTest() {

        System.out.println("Starting Full Scan with verification");

        page.startScan();
        page.openFilesTab();
        page.resolveAll();
        page.continueIfShown();

        // Scan again for verification
        page.startScan();
        page.continueIfShown();

        System.out.println("Full Scan with verification completed");
    }

    @AfterMethod
    public void afterMethod() {
        page.cleanupAfterTest();
    }
}
//jfhifj