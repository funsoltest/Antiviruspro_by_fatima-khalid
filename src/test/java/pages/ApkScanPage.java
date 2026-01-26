package pages;

import base.AntivirusPro;
import io.appium.java_client.AppiumBy;

public class ApkScanPage extends AntivirusPro{

    // Open APK Scanner
    public void openApkScanner() {
        waitAndClick(
                AppiumBy.androidUIAutomator("new UiSelector().text(\"Apk Scanner\")"), 20
        );
    }

    // Select first APK
    public void selectFirstApk() {
        waitAndClick(
                AppiumBy.androidUIAutomator(
                        "new UiSelector().resourceId(\"antivirus.viruscleaner.mobilesecurity.protection.android:id/checkBox\").instance(0)"
                ), 20
        );
    }

    // Click Clean/Delete
    public void clickClean() {
        waitAndClick(
                AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvClean"), 20
        );
    }

    // Allow Access (optional)
    public void allowAccessIfShown() {
        try {
            waitAndClick(
                    AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvAllowAccess"), 10
            );
        } catch (Exception e) {
            System.out.println("Allow Access not shown");
        }
    }

    // Continue
    public void clickContinue() {
        waitAndClick(
                AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvContinue"), 20
        );
    }

    // Optional ViewGroup click
    public void clickOptionalViewGroup() {
        try {
            waitAndClick(
                    AppiumBy.androidUIAutomator(
                            "new UiSelector().className(\"android.view.ViewGroup\").instance(12)"
                    ), 10
            );
        } catch (Exception e) {
            System.out.println("ViewGroup not found");
        }
    }

    // Back
    public void clickBack() {
        waitAndClick(
                AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvBack"), 20
        );
    }
}
