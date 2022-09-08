package com.cybertek.pages;

import com.cybertek.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllOrdersPage extends SmartBearDashBoardPage{
    @FindBy(id = "ctl00_MainContent_btnDelete")
    public WebElement deleteSelected;

    public void selectCheckBox(String name){
        Driver.getDriver().findElement(By.xpath("//td[.='"+name+"']/..input[@type='checkbox']")).click();
    }

}

