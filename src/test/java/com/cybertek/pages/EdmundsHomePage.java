package com.cybertek.pages;

import org.testng.Assert;
import static org.testng.Assert.*;
public class EdmundsHomePage extends BasePage{
    @Override
    public void isCurrentPage() {
        assertEquals(driver.getTitle(),"New Cars, Used Cars, Car Reviews and Pricing | Edmunds");

    }
}
