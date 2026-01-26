

package tests;

import org.testng.annotations.Test;
import pages.ApkScanPage;

public class ApkScanTest {

    @Test(dependsOnMethods = {
            "tests.FullScanTest.fullScanSecondTest"
    })

    public void ApkScanFlow() {

        ApkScanPage apk = new ApkScanPage();

        System.out.println("=== Starting APK Scanner Test ===");

        apk.openApkScanner();
        apk.selectFirstApk();
        apk.clickClean();
        apk.allowAccessIfShown();
        apk.clickContinue();
        apk.clickOptionalViewGroup();
        apk.clickBack();
        apk.allowAccessIfShown();

        System.out.println("APK Scanner Test finished");
    }
}
//eufiufiu

