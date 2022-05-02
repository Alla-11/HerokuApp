package org.tms.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.tms.driver.DriverSingleton;

import java.time.Duration;

public abstract class BasePage {

    protected WebDriver driver = DriverSingleton.getInstance().getDriver();
    private final static int WAIT_TIMEOUT_SECONDS = 10;

    protected BasePage(){
        PageFactory.initElements(driver,this);
    }

    protected WebElement waitVisibilityOf (WebElement element){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(element));
    }
}

