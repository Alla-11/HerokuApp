package org.tms.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicControlsPage extends BasePage{

    @FindBy(xpath = "//form[@id='checkbox-example']")
    WebElement checkboxVisibility;

    @FindBy(xpath = "//form[@id='checkbox-example']//div[@id='checkbox']")
    WebElement checkboxInput;

    @FindBy(xpath = "//form[@id='checkbox-example']//button[@type='button']")
    WebElement removeButton;

    @FindBy(xpath = "//p[@id='message']")
    WebElement messageIsDone;

    @FindBy (xpath = "//input[@type='text']")
    WebElement input;

    @FindBy(xpath = "//form[@id='input-example']//button[@type='button']")
    WebElement buttonEnable;

    @FindBy(xpath = "//p[@id='message']")
    WebElement messageItIsEnabled;


    public DynamicControlsPage openPage(String url){
        driver.get(url);
        return this;
    }

    public DynamicControlsPage clickOnCheckbox(){
        waitVisibilityOf(checkboxInput);
        checkboxInput.click();
        return this;
    }

    public Boolean isDisplayedCheckbox(){
        waitVisibilityOf(checkboxVisibility);
        Boolean visibleCheckbox = checkboxVisibility.isDisplayed();
        return visibleCheckbox;
    }

    public Boolean isEnableInput(){
        waitVisibilityOf(input);
        Boolean inputAccess = input.isEnabled();
        return inputAccess;
    }

    public DynamicControlsPage clickOnRemove(){
        removeButton.click();
        waitVisibilityOf(messageIsDone);
        return this;
    }

    public String getTextAfterClickOnRemove(){
        String messageTextAfterClickOnRemove = messageIsDone.getText();
        return messageTextAfterClickOnRemove;
    }

    public DynamicControlsPage clickOnButtonEnable(){
        buttonEnable.click();
        waitVisibilityOf(messageItIsEnabled);
        return this;
    }

    public String getTextAfterClickOnEnable(){
        String messageTextAfterClickOnEnable = messageItIsEnabled.getText();
        return messageTextAfterClickOnEnable;
    }

}


