package com.cybertek.tests.day13_faker_Practice;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class RegistrationFormBase {
    /*

     */
    WebDriver driver;
    String url = "http://practice.cybertekschool.com/registration_form";

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }
    @AfterMethod
    public void tearDown(){
        //driver.quit();

    }
}

