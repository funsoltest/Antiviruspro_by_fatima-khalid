package pages;

import base.AntivirusPro;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.time.Duration;

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

    //new code for deleteing all files one by one  and verify count

    public void scrollAndClick(String elementId) {

        int maxScrolls = 5;
        int scrollCount = 0;

        while ( scrollCount < maxScrolls) {

            if(driver.findElements(AppiumBy.id(elementId)).isEmpty()) {
                throw new RuntimeException("Element not present anymore: " + elementId);
            }

            try{
                waitAndClick(AppiumBy.id(elementId), 2);
                return;
            } catch (Exception e) {

                // element not visible


                Dimension size = driver.manage().window().getSize();
                int startX = size.width / 2;
                int startY = (int) (size.height * 0.8);
                int endY = (int) (size.height * 0.2);

                new TouchAction(driver).press(PointOption.point(startX, startY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                        .moveTo(PointOption.point(startX, endY))
                        .release()
                        .perform();

                scrollCount++;

            }


        }


    }

// tap on view all to open list

    public void openThreatList(){

        scrollAndClick("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvSelectAll");

    }

    // delete threats one by one

    public void deleteThreatsOneByOne() {


        while (true) {
            try {


                scrollAndClick(
                        "antivirus.viruscleaner.mobilesecurity.protection.android:id/btnDelete"
                );
                try {
                    waitAndClick(AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvAllowAccess"), 5);
                } catch (Exception e) {
                }
            } catch (Exception e) {

                System.out.println("all threats deleted");
                break;

            }
        }
        }












    public void resolveAll() {


        if(!driver.findElements(AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvResolveAll")).isEmpty()) {
            waitAndClick(
                    AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvResolveAll"), 30
            );

            waitAndClick(
                    AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvAllowAccess"), 30
            );
            waitAndClick(
                    AppiumBy.id("android:id/button1"), 30
            );
            return;
        }

        if(!driver.findElements(AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvContinue")).isEmpty()) {
            waitAndClick(
                    AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvContinue"),
                    10
            );
        }

//        waitAndClick(
//                AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvResolveAll"), 30
//        );
//
//        waitAndClick(
//                AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvAllowAccess"), 30
//        );

//        waitAndClick(
//                AppiumBy.id("android:id/button1"), 30
//        );
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