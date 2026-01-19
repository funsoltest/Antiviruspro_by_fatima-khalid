
package modules;

import base.AntivirusPro;
import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class apkScan extends AntivirusPro {

    @Test(dependsOnMethods = {"modules.fullScan.fullScanSecondTest"})
    public void ApkScanFlow() {

        System.out.println("=== Starting APK Scanner Test ===");

        //  Open APK Scanner module
        waitAndClick(
                AppiumBy.androidUIAutomator("new UiSelector().text(\"Apk Scanner\")"), 20
        );
        System.out.println("APK Scanner module opened");

        //  Select first APK checkbox
        waitAndClick(
                AppiumBy.androidUIAutomator(
                        "new UiSelector().resourceId(\"antivirus.viruscleaner.mobilesecurity.protection.android:id/checkBox\").instance(0)"
                ), 20
        );
        System.out.println("First APK selected");

        // Tap Clean/Delete
        waitAndClick(
                AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvClean"), 20
        );
        System.out.println("Clean/Delete button clicked — APK will be deleted");

        //  Allow Access (if shown)
        try {
            waitAndClick(
                    AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvAllowAccess"), 10
            );
            System.out.println("Access allowed");
        } catch (Exception e) {
            System.out.println("Allow Access not shown, continuing");
        }

        //  Tap Continue to finish
        waitAndClick(
                AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvContinue"), 20
        );
        System.out.println("APK Scanner flow completed successfully!");

        // Tap some ViewGroup item (optional)
        try {
            waitAndClick(
                    AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(12)"), 10
            );
            System.out.println("ViewGroup item clicked");
        } catch (Exception e) {
            System.out.println("ViewGroup item not found, skipping");
        }

        //  Tap Back button
        waitAndClick(
                AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvBack"), 20
        );
        System.out.println("Back button clicked");

        // Allow Access again (if shown)
        try {
            waitAndClick(
                    AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvAllowAccess"), 10
            );
            System.out.println("Access allowed on back navigation");
        } catch (Exception e) {
            System.out.println("Allow Access not shown on back, continuing");
        }

        System.out.println("APK Scanner Test finished");
    }
}
