package org.tms.page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ContextMenuPage extends BasePage {

    @FindBy(xpath = "//div[@id='hot-spot']")
    private WebElement whiteBoxField;

    @FindBy(xpath = "//div[@id='content']//h3")
    private WebElement text;


    Alert alert;

    public ContextMenuPage() {
    }


    public ContextMenuPage openPage(String url){
        driver.get(url);
        return this;
    }

    public String clickOnTheWhiteBox(){
        waitVisibilityOf(whiteBoxField);
        Actions actions = new Actions(driver);
        actions.contextClick(whiteBoxField).perform();
        alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }

    public ContextMenuPage closeContextMenu(){
        Actions actions = new Actions(driver);
        actions.click().perform();
        return this;
    }
}




