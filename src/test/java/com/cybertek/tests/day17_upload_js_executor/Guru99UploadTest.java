package com.cybertek.tests.day17_upload_js_executor;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Guru99UploadTest extends TestBase {
    @Test
    public void uploadFileTest(){

        driver.get(ConfigurationReader.getProperty("guru99upload.url"));
        WebElement chooseFile = driver.findElement(By.id("uploadfile_0"));
        WebElement terms = driver.findElement(By.id("terms"));
        WebElement submitFile = driver.findElement(By.id("submitbutton"));
       chooseFile.sendKeys (System.getProperty("user.home")+"/"+"Downloads"+"/"+"some-file.txt");
       terms.click();
       submitFile.click();
       //verification
        BrowserUtils.sleep(2);
        WebElement resultMsg = driver.findElement(By.id("res"));
        Assert.assertEquals(resultMsg.getText(),"1 file\nhas been successfully uploaded.");

    }
}
