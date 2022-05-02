package org.tms.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.tms.driver.DriverSingleton;
import org.tms.utils.TestListener;

@Listeners(TestListener.class)
public class BaseTest{

    protected WebDriver driver;

    @BeforeTest
    public void startBrowser() {
        driver = DriverSingleton.getInstance().getDriver();
    }

    @AfterTest(alwaysRun = true)
    public void stopBrowser() {
        DriverSingleton.getInstance().closeDriver();
    }

}







