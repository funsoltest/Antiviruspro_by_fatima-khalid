package pages;

import base.AntivirusPro;
import io.appium.java_client.AppiumBy;

public class FullScanPage extends AntivirusPro {

   // PREPARE SCREEN

    public void handlePopupsIfAny() {

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

    // FULL SCAN FLOW

    public void startScan() {
        waitAndClick(
                AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvScanNow"), 30
        );
    }

    public void openFilesTab() {
        waitAndClick(
                AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvFiles"), 30
        );
    }

    public void resolveAll() {

        waitAndClick(
                AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvResolveAll"), 30
        );

        waitAndClick(
                AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvAllowAccess"), 30
        );

        waitAndClick(
                AppiumBy.id("android:id/button1"), 30
        );
    }

    public void continueIfShown() {
        try {
            waitAndClick(
                    AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvContinue"), 10
            );
        } catch (Exception ignored) {}
    }

    // AFTER TEST

    public void cleanupAfterTest() {

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
//fjkfj