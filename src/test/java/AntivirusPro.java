

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AntivirusPro {

    AndroidDriver driver;

    @BeforeClass
    public void setup() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();

        // Basic Appium capabilities
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:deviceName", "99141FFAZ004UC");
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:platformVersion", "13");
        caps.setCapability("appium:app", "C:\\APK\\AntivirusPro.apk");


        caps.setCapability("appium:noReset", true);
        caps.setCapability("appium:fullReset", false);
        caps.setCapability("appium:autoGrantPermissions", true);


        // Appium server URL
        URL url = URI.create("http://127.0.0.1:4723/wd/hub").toURL();

        // Initialize driver
        driver = new AndroidDriver(url, caps);



    }




    // One sample test case
    @Test
    public void verifyAppLaunch() {
        System.out.println("App launched successfully");

    }



    @Test(priority = 1)
    public void partialScanFirstTimeTest() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Intro flow (FIRST TIME ONLY)
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/imgTick")
        )).click();

        By nextBtn = AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvNext");
        for (int i = 0; i < 3; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(nextBtn)).click();
        }

        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvAllowAccess")
        )).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button")
        )).click();

        // Start Scan
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvScanNow")
        )).click();

        // Select all detected items
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvSelectAll")
        )).click();

        // Delete (partial resolve flow)
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/btnDelete")
        )).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvAllowAccess")
        )).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/btnDelete")
        )).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvAllowAccess")
        )).click();

        // 2️⃣ SCROLL ONLY (do not tap "View All")
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollForward()" // scroll forward one step
        ));

        // 1️⃣ Tap Skip if visible
        try {
            WebElement skipBtn = new WebDriverWait(driver, Duration.ofSeconds(20))
                    .until(ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvSkip")
                    ));
            skipBtn.click();
            System.out.println("Skip button clicked");
        } catch (Exception e) {
            System.out.println("Skip button not shown, continuing");
        }

        // 2️⃣ Tap Allow Access if visible
        try {
            WebElement allowBtn = new WebDriverWait(driver, Duration.ofSeconds(20))
                    .until(ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvAllowAccess")
                    ));
            allowBtn.click();
            System.out.println("Allow Access clicked");
        } catch (Exception e) {
            System.out.println("Allow Access not shown, continuing");
        }

        // 3️⃣ Tap Continue
        try {
            WebElement continueBtn = new WebDriverWait(driver, Duration.ofSeconds(20))
                    .until(ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvContinue")
                    ));
            continueBtn.click();
            System.out.println("Continue button clicked");
        } catch (Exception e) {
            System.out.println("Continue button not clickable, test may fail");
        }

        System.out.println("Priority 1: Partial scan completed");

    }

    @Test(priority = 2)
    public void fullScanSecondTest() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Scan now
        WebElement el7 = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvScanNow")
        ));
        el7.click();

        // Files
        WebElement el8 = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvFiles")
        ));
        el8.click();


        // Resolve all
        WebElement el10 = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvResolveAll")
        ));
        el10.click();

        // Allow access again
        WebElement el11 = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvAllowAccess")
        ));
        el11.click();

        // Dialog OK
        WebElement el12 = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.id("android:id/button1")
        ));
        el12.click();

        // Continue
        WebElement el13 = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvContinue")
        ));
        el13.click();

        // Scan now again
        WebElement el14 = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvScanNow")
        ));
        el14.click();

        // Final continue
//	    WebElement el15 = wait.until(ExpectedConditions.elementToBeClickable(
//	        AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvContinue")
//	    ));
//	    el15.click();
        // 3️⃣ Tap Continue
        try {
            WebElement continueBtn = new WebDriverWait(driver, Duration.ofSeconds(20))
                    .until(ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvContinue")
                    ));
            continueBtn.click();
            System.out.println("Continue button clicked");
        } catch (Exception e) {
            System.out.println("Continue button not clickable, test may fail");
        }

        System.out.println("Priority 1: Partial scan completed");


    }


//    @AfterClass
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}


