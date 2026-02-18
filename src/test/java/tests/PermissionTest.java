package tests;

import base.AntivirusPro;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.PermissionPage;

public class PermissionTest extends AntivirusPro {

    private PermissionPage permissionPage;

    @BeforeClass
    public void setup() {
        permissionPage = new PermissionPage();
    }
    @Test(description = "Notifcation Permisiion")
    public void notificationPermissionTest() {
        if(permissionPage.isAllowAccessVisible()){
            permissionPage.grantNotificationPermission();
        } else{
            System.out.println("[PermissionPage] Notification Permission is disabled");

        }

        Assert.assertFalse(permissionPage.isAllowAccessVisible(), "Notification Access dialog should not be visible after granting permission");
    }



    @Test(description = "Grant All Files Access permission if required")
    public void testGrantAllFilesAccess() {
        // Check if "Allow Access" dialog is visible
        if (permissionPage.isAllowAccessVisible()) {
            permissionPage.grantAllFilesAccess();
        } else {
            System.out.println("[Test] All Files Access already granted or not required.");
        }

        //Verification Assert is a check inside your automated test.
        //It verifies that the app behaved the way you expected.
        //If the check fails, the test fails automatically.
        //Without asserts, your test just clicks buttons but doesn’t actually confirm anything.

        Assert.assertFalse(permissionPage.isAllowAccessVisible(), "All Files Access dialog should not be visible after granting permission");
    }




}
