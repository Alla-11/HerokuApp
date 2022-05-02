package org.tms.test;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.page.ContextMenuPage;
import org.tms.service.HerokuappService;




public class ContextMenuTest extends BaseTest {

    private HerokuappService herokuappService;
    private ContextMenuPage contextMenuPage;
    Alert alert;

    @BeforeClass
    public void openContextMenuPageTest(){
        herokuappService = new HerokuappService();
        contextMenuPage = new ContextMenuPage();
        herokuappService.openPageContextMenu();
    }

    @Test (description = "Сheck alert opening")
    public void checkContextMenuPageTest(){
        String actualResulttextOnAlert = contextMenuPage.clickOnTheWhiteBox();
        String expectedResultAlertText = "You selected a context menu";
        Assert.assertEquals(actualResulttextOnAlert, expectedResultAlertText, "The actual result does not match the expected result! ");
    }

    @Test(dependsOnMethods ="checkContextMenuPageTest", description = "Сheck alert close")
    public void checkAlertCloseTest(){
        Boolean actualResultCloseAlert = checkAlertOff();
        Boolean expectedResultCloseAlert = true;
        Assert.assertEquals(actualResultCloseAlert,expectedResultCloseAlert,"The actual result does not match the expected result! Alert does not close!");
    }

    private Boolean checkAlertOff(){
        if (alert != null) {
             closeAlert();
        }
        contextMenuPage.closeContextMenu();
        return true;
    }

//    private String getAlertText(){
//        alert = driver.switchTo().alert();
//        String alertText = alert.getText();
//        return alertText;
//    }

    public void closeAlert(){
        alert.accept();
    }


}






