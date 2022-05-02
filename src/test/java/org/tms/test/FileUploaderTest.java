package org.tms.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.page.FileUploaderPage;
import org.tms.service.HerokuappService;

public class FileUploaderTest extends BaseTest{

    private HerokuappService herokuappService;
    private FileUploaderPage fileUploaderPage;

    @BeforeClass
    public void openFileUploaderPageTest(){
        herokuappService = new HerokuappService();
        fileUploaderPage = new FileUploaderPage();
        herokuappService.openPageFileUploader();
    }

    @Test(description = "Сheck that you have downloaded the correct file")
    public void checkUploadedNameFileTest(){
        String actualUplodedNameFile = "Test.txt";
        String expectedUplodedNameFile = addFileOnFileUploderPage();
        Assert.assertEquals(actualUplodedNameFile,expectedUplodedNameFile,"The actual file name result does not match expected file name result!");
    }


    private String addFileOnFileUploderPage(){
        fileUploaderPage.clickButtonChooseFile()
                        .clickButtonUpload();
        String text = fileUploaderPage.getNameOfTheUploadedFile();
        return text;
    }
}


