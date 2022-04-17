package org.tms.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.page.FileUploaderPage;
import org.tms.service.HerokuappService;

public class FileUploaderTest extends BaseTest{

    private HerokuappService herokuappService = new HerokuappService();
    private FileUploaderPage fileUploaderPage = new FileUploaderPage();

    @BeforeClass
    public void openFileUploaderPageTest(){
        herokuappService.openPageFileUploader();
    }

    @Test
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


