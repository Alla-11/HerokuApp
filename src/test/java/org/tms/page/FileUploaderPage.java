package org.tms.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileUploaderPage extends BasePage{

    @FindBy (xpath = "//form[@method='POST']//input[@type='file']")
    WebElement buttonChooseFile;

    @FindBy (xpath =  "//input[@id='file-submit']")
    WebElement buttonUpload;

    @FindBy (xpath = "//div[@id='uploaded-files']")
    WebElement uplodedFileName;




    public FileUploaderPage openPage(String url){
        driver.get(url);
        return this;
    }

    public FileUploaderPage clickButtonChooseFile(){
        waitVisibilityOf(buttonChooseFile);
        String filePath = "C:\\Users\\User\\IdeaProjects\\HerokuApp\\src\\test\\resources\\Test.txt";
        buttonChooseFile.sendKeys(filePath);
        return this;
    }

    public FileUploaderPage clickButtonUpload(){
        waitVisibilityOf(buttonUpload);
        buttonUpload.click();
        return this;
    }

    public String getNameOfTheUploadedFile(){
        waitVisibilityOf(uplodedFileName);
        String uplodedNameFile = uplodedFileName.getText();
        return uplodedNameFile;
    }

}



