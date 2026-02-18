package pages;

import base.AntivirusPro;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class PermissionPage extends AntivirusPro {

    // Locators
    private By allowAccessButton = AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvAllowAccess");
    private By fullStorageSwitch = AppiumBy.id("android:id/switch_widget");

//    By fullStorageSwitch = AppiumBy.xpath(
//            "//android.widget.Switch[@resource-id='android:id/switch_widget']"
//    );




    private By navigateUpButton = AppiumBy.accessibilityId("Navigate up");


    private By notificationAllowButton = AppiumBy.id("antivirus.viruscleaner.mobilesecurity.protection.android:id/tvAllowAccess");
    private By systemNotificationButton = AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button");

//notification permission
    public void grantNotificationPermission(){
        try{
            if(driver.findElement(notificationAllowButton).isDisplayed()){
                System.out.println("[permissionPage] Notification dialog detected.Granting permission");
                driver.findElement(notificationAllowButton).click();


            }

            //handel system lever notification dialog
            if(driver.findElement(systemNotificationButton).isDisplayed()){
                System.out.println("[permissionPage] System dialog detected.Granting permission");
                driver.findElement(systemNotificationButton).click();
            }
        }catch(Exception e){
            System.out.println("[permissionPage] Notification dialog detected.Error: " + e.getMessage());

        }
    }

    //  Grant All Files Access
    public void grantAllFilesAccess() {
        System.out.println("[PermissionPage] Granting All Files Access...");

        waitAndClick(allowAccessButton, 15);
        waitAndClick(fullStorageSwitch, 10);
        //waitAndClick(navigateUpButton, 20);
        try {
            Thread.sleep(1500);  // 1.5 sec pause
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Press back to close overlay / dropdown
        driver.navigate().back();

        // Navigate back in the app
        waitAndClick(navigateUpButton, 20);

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
