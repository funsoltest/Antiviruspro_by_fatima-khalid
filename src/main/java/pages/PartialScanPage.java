package pages;

import base.AntivirusPro;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class PartialScanPage extends AntivirusPro {
    private PermissionPage permissionPage;

    public PartialScanPage() {
        permissionPage = new PermissionPage();
    }

    public void checkNotificationAccess() {
       if(permissionPage.isAllowAccessVisible()){
           permissionPage.grantNotificationPermission();
       }
    }

    // Method to check and grant permission
    public void checkPermissionBeforeScan() {
        if (permissionPage.isAllowAccessVisible()) {
            System.out.println("Granting All Files Access...");
            permissionPage.grantAllFilesAccess();
        }
    }
    // INTRO FLOW

    public void completeIntroFlow() {

        waitAndClick(
                AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/imgTick"), 30
        );

        By nextBtn = AppiumBy.id(
                "antivirus.viruscleaner.mobilesecurity.protection.android:id/tvNext"
        );

        for (int i = 0; i < 3; i++) {
            waitAndClick(nextBtn, 30);
        }

//        waitAndClick(
//                AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvAllowAccess"), 30
//        );
//
//        waitAndClick(
//                AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button"), 30
//        );
    }

    // RESET APP

    public void resetAndOpenScan() {

        String appId = "antivirus.viruscleaner.mobilesecurity.protection.android";

//        driver.terminateApp(appId);
//        driver.activateApp(appId);

        try { Thread.sleep(3000); } catch (InterruptedException ignored) {}



        checkNotificationAccess();

        waitAndClick(
                AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvScanNow"), 20
        );

        checkPermissionBeforeScan(); // ← Add this line







    }

    //DELETE APPS

    public boolean deleteAppsIfPresent() {

        try {
            waitAndClick(
                    AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvApps"), 10
            );
            try {
                By viewAllBtn = AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvViewAll");
                if (!driver.findElements(viewAllBtn).isEmpty()) {
                    waitAndClick(viewAllBtn, 5);
                }
            } catch (Exception ignored) {}

            if (!driver.findElements(
                    AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvSelectAll")
            ).isEmpty()) {

                driver.findElement(
                        AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvSelectAll")
                ).click();

                driver.findElement(
                        AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/btnDelete")
                ).click();

                driver.findElement(
                        AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvAllowAccess")
                ).click();

                driver.findElement(AppiumBy.id("android:id/button1")).click();

                driver.findElement(
                        AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/btnDelete")
                ).click();

                driver.findElement(
                        AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvAllowAccess")
                ).click();

                return true;
            }

        } catch (Exception ignored) {}

        return false;
    }

   //DELETE FILES

    public void deleteFiles() {

        try {
            waitAndClick(
                    AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvFiles"), 10
            );

            driver.findElement(
                    AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvSelectAll")
            ).click();

            driver.findElement(
                    AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/btnDelete")
            ).click();

            driver.findElement(
                    AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvAllowAccess")
            ).click();

            driver.findElement(AppiumBy.id("android:id/button1")).click();

            driver.findElement(
                    AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/btnDelete")
            ).click();

            driver.findElement(
                    AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvAllowAccess")
            ).click();

        } catch (Exception e) {
            System.out.println("No files found");
        }
    }

   //FINISH

    public void skipDialogs() {
        waitAndClick(
                AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvSkip"), 20
        );
    }

    public void returnToHome() {
        try {
            waitAndClick(
                    AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvAllowAccess"), 20
            );
            waitAndClick(
                    AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvContinue"), 20
            );
        } catch (Exception ignored) {}
    }
}
//gyfyufu