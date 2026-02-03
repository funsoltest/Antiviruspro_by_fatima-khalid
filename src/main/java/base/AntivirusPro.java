package base;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;


import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeSuite;

public class AntivirusPro {

    protected static AndroidDriver driver;

    @BeforeSuite
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
    // 2️⃣ Generic wait & click function
    public void waitAndClick(By locator, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            WebElement el = wait.until(ExpectedConditions.elementToBeClickable(locator));
            el.click();
        } catch (Exception e) {
            System.out.println("Element not clickable: " + locator);
        }
    }







    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }


    }
}


