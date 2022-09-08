//package com.cybertek.tests.OfficeHour;
//
//import com.cybertek.pages.PlaceOrderPage;
//import com.cybertek.tests.TestBase;
//import com.cybertek.utils.BrowserUtils;
//import com.cybertek.utils.ConfigurationReader;
//import com.cybertek.utils.OfficeUtils;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class day05_PlaceOrderTest2 extends TestBase {
//    int expectedPrice = 0;
//
//    @Test
//    public void placeOrder() {
//        // gets me URL of the page
//        driver.get(ConfigurationReader.getProperty("demoblazeUrl"));
//        // adding Laptops Sony vaio i7
//        expectedPrice += OfficeUtils.addProduct("Laptops", "Sony vaio i7");
//
//        // adding Iphone
//        expectedPrice += OfficeUtils.addProduct("Phones", "Iphone 6 32gb");
//        // adding Monitor
//        expectedPrice += OfficeUtils.addProduct("Monitors", "Apple monitor 24");
//
//        OfficeUtils.getLink("Cart").click();
//
//        expectedPrice -= OfficeUtils.removeProduct("Iphone 6 32gb");
//
//        System.out.println("expectedPrice = " + expectedPrice);
//
//        // we are calling our form filling method
//        PlaceOrderPage placeOrderPage = new PlaceOrderPage();
//        placeOrderPage.placeOrderButton.click();
//        placeOrderPage.fillForm(faker);
//        BrowserUtils.sleep(1);
//        placeOrderPage.purchaseBtn.click();
//
//
//        System.out.println("placeOrderPage.confirmationText.getText() = " + placeOrderPage.confirmationText.getText());
//
//        //     split method with regex "\n"  you need two splits
//
//        String[] arr = placeOrderPage.confirmationText.getText().split("\n");
//
//        // Click OK button after we get the text
//        BrowserUtils.sleep(2);
//        placeOrderPage.Ok.click();
//
//        Map<String, Object> dataMap = new HashMap<>(); // if the order of the keys not important for me
//        // arr[0].split(":")[0] = Id ---> Key for my Map  arr[0].split(":")[1]=1575159 ----> Value for my map
//        // arr[0] : String value
//
//        for (String s : arr) {
//            dataMap.put(s.split(":")[0].trim(), s.split(":")[1].trim());
//        }
//
//        System.out.println("dataMap = " + dataMap); // dataMap = {Id=5551210}
//
//        // Object: Everything can be Object (String, primitives, Objects created from Class, List<String> , Arrays, ArrayLists
//
//        int actualPrice = Integer.parseInt(((String) dataMap.get("Amount")).split(" ")[0]);
//
//        System.out.println("actualPrice = " + actualPrice);
//
//        System.out.println("Customer name : "+ dataMap.get("Name"));
//
//        System.out.println("Confirmation ID Number for the purchase is : "+ dataMap.get("Id"));
//
//        Assert.assertEquals(actualPrice,expectedPrice,"The Price is NOT as expected");
//
//    }
//
//
//}
//
//
//
//
//
//
