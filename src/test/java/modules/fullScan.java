

package modules;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.*;
import base.AntivirusPro;

public class fullScan extends AntivirusPro {

    // Prepare app before each test
    @BeforeMethod
    public void beforeMethod() {
        // Make sure we are on scan home screen, handle popups if they appear
        try {
            waitAndClick(
                    AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvSkip"), 5
            );
        } catch (Exception ignored) {}

        try {
            waitAndClick(
                    AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvContinue"), 5
            );
        } catch (Exception ignored) {}
    }

    @Test(dependsOnMethods = {"modules.partialScan.partialScanFirstTimeTest"})
    public void fullScanSecondTest() {

        System.out.println("Starting Full Scan with verification");

        // Scan Now
        waitAndClick(
                AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvScanNow"), 30
        );

        //  Click Files
        waitAndClick(
                AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvFiles"), 30
        );

        // Resolve All
        waitAndClick(
                AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvResolveAll"), 30
        );
         waitAndClick(
                 AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvAllowAccess"),30
         );
        waitAndClick(
                AppiumBy.id("android:id/button1"),30
        );


        //  Continue (if appears)
        try {
            waitAndClick(
                    AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvContinue"), 10
            );
        } catch (Exception ignored) {}

        //  Scan Again (to re-verify deleted items)
        waitAndClick(
                AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvScanNow"), 30
        );

        //  Final Continue (if appears)
        try {
            waitAndClick(
                    AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvContinue"), 10
            );
        } catch (Exception ignored) {}

        System.out.println("Full Scan with verification completed");
    }

    // Clean up after each test
    @AfterMethod
    public void afterMethod() {
        // Make sure app is ready for next test
        try {
            waitAndClick(
                    AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvContinue"), 5
            );
        } catch (Exception ignored) {}

        try {
            waitAndClick(
                    AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvAllowAccess"), 5
            );
        } catch (Exception ignored) {}
    }
}

