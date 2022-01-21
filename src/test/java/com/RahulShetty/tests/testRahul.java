package com.RahulShetty.tests;

import com.RahulShetty.Base.BaseTest;
import com.RahulShetty.Pages.CheckOutPage;
import com.RahulShetty.Pages.HomePage;
import com.RahulShetty.Pages.ShoppingChart;
import com.RahulShetty.Pages.SignInPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class testRahul extends BaseTest {
    SignInPage signInPage;
    HomePage homePage;
    ShoppingChart shoppingChart;
    CheckOutPage checkOutPage;


    @Test (priority = 1)
    public void signingIn() throws IOException {
        signInPage = new SignInPage(driver);
        signInPage.signingIn();
        System.out.println(signInPage.successMessage());
        Assert.assertEquals(signInPage.successMessage(), "You will be limited to only fewer functionalities of the app. Proceed?", "Test not passed");

    }

    @Test (priority = 2)
    public void pressButton() throws IOException {
        signInPage = new SignInPage(driver);
        signInPage.pressButtons();
    }

    @Test (priority = 3)
    public void protoHomeMessage() throws IOException {
        homePage = new HomePage(driver);
        homePage.protoHomeMessage();
        System.out.println(homePage.protoHomeMessage());
        Assert.assertEquals(homePage.protoHomeMessage(), "ProtoCommerce Home", "Test not passed");
        homePage.addToBasket();
        homePage.checkBasket();
        System.out.println(homePage.priceToCheckOut());
        Assert.assertEquals(homePage.priceToCheckOut(), "₹. 300000", "Test not passed");
    }

    @Test (priority = 4)
    public void shoppingChart() throws IOException {
        shoppingChart = new ShoppingChart(driver);
        shoppingChart.basket();
        System.out.println(shoppingChart.checkOutPriceForThreeItem());
        Assert.assertEquals(shoppingChart.checkOutPriceForThreeItem(), "₹. 200000", "Test not passed");
        shoppingChart.addedOneAdditional();

    }

    @Test(priority = 5)
    public void checkOut() throws IOException {
        checkOutPage = new CheckOutPage(driver);
        checkOutPage.checkOut();
        checkOutPage.deliveryLocation();
        checkOutPage.deliveryTo();
        System.out.println(checkOutPage.shoppingMessage());
        Assert.assertEquals(checkOutPage.shoppingMessage(), "×\n" + "Success! Thank you! Your order will be delivered in next few weeks :-)." , "Test not passed");
    }
}


