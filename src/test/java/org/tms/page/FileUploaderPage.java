package org.tms.page;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//@Log4j2
public class FileUploaderPage extends BasePage{

    @FindBy (xpath = "//form[@method='POST']//input[@type='file']")
    WebElement buttonChooseFile;

    @FindBy (xpath =  "//input[@id='file-submit']")
    WebElement buttonUpload;

    @FindBy (xpath = "//div[@id='uploaded-files']")
    WebElement uplodedFileName;




    public FileUploaderPage openPage(String url){
        //log.info("Open page FileUploader");
        driver.get(url);
        return this;
    }

    @Step("Add file to upload ")
    public FileUploaderPage clickButtonChooseFile(){
        waitVisibilityOf(buttonChooseFile);
        String filePath = "C:\\Users\\User\\IdeaProjects\\HerokuApp\\src\\test\\resources\\Test.txt";
        buttonChooseFile.sendKeys(filePath);
        return this;
    }

    @Step ("File upload")
    public FileUploaderPage clickButtonUpload(){
        waitVisibilityOf(buttonUpload);
        buttonUpload.click();
        return this;
    }


    public String getNameOfTheUploadedFile(){
        //log.info("return file name");
        waitVisibilityOf(uplodedFileName);
        String uplodedNameFile = uplodedFileName.getText();
        return uplodedNameFile;
    }

}



