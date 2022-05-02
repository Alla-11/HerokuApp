package org.tms.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.page.DynamicControlsPage;
import org.tms.service.HerokuappService;


public class DynamicControlsTest extends BaseTest {

    private HerokuappService herokuappService;
    private DynamicControlsPage dynamicControlsPage;


    @BeforeClass
    public void openDynamicControlsPageTest() {
        herokuappService = new HerokuappService();
        dynamicControlsPage = new DynamicControlsPage();
        herokuappService.openPageDynamicControls();
    }

    @Test (description = "Сheck сheckbox not displayed")
    public void checkCheckboxNotDisplayedTest(){
        Boolean actualResultOfVisibleCheckboxAfterClickOnButtonRemove = checkboxNotShow();
        Boolean expectedResultOfVisibleCheckboxAfterClickOnButtonRemove = false;
        Assert.assertEquals(actualResultOfVisibleCheckboxAfterClickOnButtonRemove,expectedResultOfVisibleCheckboxAfterClickOnButtonRemove, "The actual result of checkbox display does not match the expected result!");
    }

    @Test (description = "Сheck input is enable")
    public void checkInputIsEnableTest(){
        Boolean actualResultOfInputEnable = dynamicControlsPage.isEnableInput();
        Boolean expectedResultOfInputEnable  = false;
        Assert.assertEquals(actualResultOfInputEnable,expectedResultOfInputEnable, "The actual result of input enable does not match the expected result!");
    }

    @Test(dependsOnMethods ="checkInputIsEnableTest")
    public void checkInputIsEnableAfterClickOnButtonEnableTest(){
        Boolean actualResultOfInputEnable = checkInputEnable();
        Boolean expectedResultOfInputEnable = true;
        Assert.assertEquals(actualResultOfInputEnable,expectedResultOfInputEnable, "The actual result of input enable does not match the expected result!");
    }


    private boolean checkboxNotShow(){
        Boolean resultOfVisibleCheckbox = true;
        dynamicControlsPage.clickOnCheckbox()
                           .clickOnRemove();
        String actualTextAfterClickOnRemove = "It's gone!";
        String expectedTextAfterClikOnRemove = dynamicControlsPage.getTextAfterClickOnRemove();
        if (expectedTextAfterClikOnRemove.equals(actualTextAfterClickOnRemove)){
            if (dynamicControlsPage.isDisplayedCheckbox()){
                resultOfVisibleCheckbox = false;
            } else {
                resultOfVisibleCheckbox = true;
            }
        }
        return resultOfVisibleCheckbox;
    }

    private boolean checkInputEnable(){
        Boolean resultOfEnableInput = true;
        dynamicControlsPage.clickOnButtonEnable();
        String actualTextAfterClickOnEnable = "It's enabled!";
        String expectedTextAfterClickOnEnable = dynamicControlsPage.getTextAfterClickOnEnable();
        if (expectedTextAfterClickOnEnable.equals(actualTextAfterClickOnEnable)){
            if (dynamicControlsPage.isEnableInput()){
                resultOfEnableInput = true;
            } else {
                resultOfEnableInput = false;
            }
        }
        return resultOfEnableInput;
    }

}
