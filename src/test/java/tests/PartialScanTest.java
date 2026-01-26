


package tests;

import org.testng.annotations.*;
import pages.PartialScanPage;

public class PartialScanTest {

    PartialScanPage page;

    @BeforeClass
    public void beforeClass() {
        page = new PartialScanPage();
        page.completeIntroFlow();
    }

    @BeforeMethod
    public void beforeEachTest() {
        page.resetAndOpenScan();
    }

    @Test
    public void partialScanFirstTimeTest() {

        System.out.println("Starting partial scan");

        boolean appsDeleted = page.deleteAppsIfPresent();

        if (appsDeleted) {
            page.deleteFiles();
        }
else{
    page.deleteFiles();
        }
        page.skipDialogs();

        System.out.println("Partial scan completed");
    }

    @AfterMethod
    public void afterEachTest() {
        page.returnToHome();
    }

    @AfterClass
    public void afterClass() {
        System.out.println("All partial scan tests completed");
    }
}

//ffeufiu

