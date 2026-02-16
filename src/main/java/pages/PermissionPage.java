package pages;

import base.AntivirusPro;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class PermissionPage extends AntivirusPro {

    // Locators
    private By allowAccessButton = AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvAllowAccess");
    private By fullStorageSwitch = AppiumBy.id("android:id/switch_widget");
    private By navigateUpButton = AppiumBy.accessibilityId("Navigate up");



    //  Grant All Files Access
    public void grantAllFilesAccess() {
        System.out.println("[PermissionPage] Granting All Files Access...");

        waitAndClick(allowAccessButton, 15);
        waitAndClick(fullStorageSwitch, 10);
        waitAndClick(navigateUpButton, 5);

        System.out.println("[PermissionPage] All Files Access granted successfully.");
    }

    // Check if "Allow Access" is displayed
    public boolean isAllowAccessVisible() {
        try {
            return driver.findElement(allowAccessButton).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }






}
