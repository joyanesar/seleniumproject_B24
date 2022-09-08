package com.cybertek.tests.day13_faker_Practice;

import com.cybertek.utils.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RegistrationFormTest extends RegistrationFormBase {
    Faker faker = new Faker();
    @Test
    public void formTest() throws InterruptedException {
        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys(faker.name().firstName());

        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys(faker.name().lastName());

        enterUserName(faker.name().username().replace(".",""));

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys(faker.internet().emailAddress());
        WebElement passWor = driver.findElement(By.name("password"));
        passWor.sendKeys(faker.internet().password());

        WebElement mobile = driver.findElement(By.name("phone"));
        mobile.sendKeys(faker.phoneNumber().cellPhone()
        .replace("(","")
        .replace(")","")
        .replace(".","-")
        .replace(" ",""));


        WebElement maleRadio = driver.findElement(By.xpath("//*[@value='male']"));
        maleRadio.click();
        WebElement dob = driver.findElement(By.name("birthday"));
        dob.sendKeys("01/01/1990");

        Select department =  new Select(driver.findElement(By.name("department")));
        department.selectByIndex(faker.number().numberBetween(1,9));
        Select jobTitle =  new Select(driver.findElement(By.name("job_title")));
        jobTitle.selectByIndex(faker.number().numberBetween(1,8));

        List<WebElement> languages = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for(WebElement each: languages){
            each.click();
        }
        WebElement singUp = driver.findElement(By.id("wooden_spoon"));
        singUp.click();
        Thread.sleep(2000);
        //verify
        WebElement heading = driver.findElement(By.className("alert-heading"));
        Assert.assertEquals(heading.getText(),"Well done!");
        Assert.assertTrue(heading.isDisplayed());
    }
    public void enterUserName (String userName){
        WebElement userNameField = driver.findElement(By.name("username"));
        userNameField.sendKeys(userName);


    }
}
