

package modules;

import io.appium.java_client.AppiumBy;

import org.openqa.selenium.By;
import org.testng.annotations.*;
import base.AntivirusPro;

public class partialScan extends AntivirusPro {

    // Runs ONCE before this class
    @BeforeClass
    public void beforeClass() {

        // Intro flow (FIRST TIME ONLY)
        waitAndClick(
                AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/imgTick"), 30
        );

        By nextBtn = AppiumBy.id(
                "antivirus.viruscleaner.mobilesecurity.protection.android:id/tvNext"
        );
        for (int i = 0; i < 3; i++) {
            waitAndClick(nextBtn, 30);
        }

        waitAndClick(
                AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvAllowAccess"), 30
        );

        waitAndClick(
                AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button"), 30
        );
    }

    // Runs BEFORE each testcase
    @BeforeMethod
    public void beforeEachTest() {
        System.out.println("BeforeMethod: Resetting app to ensure clean state");
        // Define your app package ID
        String appId = "antivirus.viruscleaner.mobilesecurity.protection.android";

        // Terminate the app
        driver.terminateApp(appId);

        // Activate it again
        driver.activateApp(appId);


        // wait a few seconds for UI to stabilize
        try { Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();// print error detail in console
        }

        // Ensure scan screen is ready
        waitAndClick(
                AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvScanNow"), 20
        );
    }


    @Test
    public void partialScanFirstTimeTest() {
        System.out.println("Starting partial scan");

        // Try deleting apps first
        try {
            // Switch to Apps tab
            waitAndClick(AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvApps"), 10);
            //  Scroll if required
            try {
                driver.findElement(AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"
                ));
            } catch (Exception e) {
                System.out.println("Scroll not required");
            }

            // Check if any apps exist
            if (!driver.findElements(AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvSelectAll")).isEmpty()) {
                System.out.println("Apps found, deleting apps...");

                driver.findElement(AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvSelectAll")).click();
                driver.findElement(AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/btnDelete")).click();
                driver.findElement(AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvAllowAccess")).click();
                driver.findElement(AppiumBy.id("android:id/button1")).click();
                driver.findElement(AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/btnDelete")).click();
                driver.findElement(AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvAllowAccess")).click();

            } else {
                System.out.println("No apps found, will delete files instead");
                throw new Exception("No apps");
            }

        } catch (Exception e) {
            // If no apps, go to Files tab
            try {
                waitAndClick(AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvFiles"), 10);
                System.out.println("Deleting files...");

                driver.findElement(AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvSelectAll")).click();
                driver.findElement(AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/btnDelete")).click();
                driver.findElement(AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvAllowAccess")).click();
                driver.findElement(AppiumBy.id("android:id/button1")).click();
                driver.findElement(AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/btnDelete")).click();
                driver.findElement(AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvAllowAccess")).click();
            } catch (Exception ex) {
                System.out.println("No files to delete either");
            }
        }

        //  Scroll if required
        try {
            driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"
            ));
        } catch (Exception e) {
            System.out.println("Scroll not required");
        }

        //  Skip optional dialogs
        waitAndClick(
                AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvSkip"), 20
        );

        System.out.println("Partial scan completed");
    }


    // Runs AFTER each testcase
    @AfterMethod
    public void afterEachTest() {
        System.out.println("AfterMethod: Bringing app back to main screen");

    // go back to home screen
        try {

            waitAndClick(
                    AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvAllowAccess"), 20
            );

            waitAndClick(
                    AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvContinue"), 20
            );
        } catch (Exception e) {
            System.out.println("Already at main screen or navigation failed");
        }


    }

    // Runs ONCE after this class
    @AfterClass
    public void afterClass() {
        System.out.println("AfterClass: All tests done, final cleanup if needed");
    }
}




