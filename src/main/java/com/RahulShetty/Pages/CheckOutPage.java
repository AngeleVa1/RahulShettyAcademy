package com.RahulShetty.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

import static com.RahulShetty.TestDataReader.getLocation;

public class CheckOutPage {
    WebDriver driver;
    String location = getLocation();


    public CheckOutPage(WebDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[normalize-space()='Checkout']")
    WebElement checkOutButton;

    @FindBy(xpath = "//label[@for='country']")
    WebElement deliveryLocationAssert;

    @FindBy(xpath = "//input[@id='country']")
    WebElement deliveryToBox;

    @FindBy(xpath = "//label[@for='checkbox2']")
    WebElement agreeToTermsButton;

    @FindBy(xpath = "//input[@value='Purchase']")
    WebElement purchaseButton;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement successfulShoppingMessage;

    public void checkOut() {
        checkOutButton.click();
    }

    public String deliveryLocation() {
        return deliveryLocationAssert.getText();
    }

    public void deliveryTo() {
        deliveryToBox.sendKeys(location);
        agreeToTermsButton.click();
        purchaseButton.click();
    }

    public String shoppingMessage() {
        return successfulShoppingMessage.getText();
    }
}
