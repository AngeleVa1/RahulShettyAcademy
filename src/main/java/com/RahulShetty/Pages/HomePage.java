package com.RahulShetty.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.IOException;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[normalize-space()='ProtoCommerce Home']")
    WebElement protoHomeSuccessMessage;

    @FindBy(xpath = "//app-card[1]//div[1]//div[2]//button[1]")
    WebElement addIphone;

    @FindBy(xpath = "//app-card[2]//div[1]//div[2]//button[1]")
    WebElement addSamsung;

    @FindBy(xpath = "//app-card[3]//div[1]//div[2]//button[1]")
    WebElement addNokia;

    @FindBy(xpath = "//app-card[4]//div[1]//div[2]//button[1]")
    WebElement addBlackberry;

    @FindBy(xpath = "//a[@class='nav-link btn btn-primary']")
    WebElement checkOutButton;

    @FindBy(xpath = "//strong[contains(text(),'₹. 300000')]")
    WebElement priceToCheckout;


    public String protoHomeMessage() {
        return protoHomeSuccessMessage.getText();
    }

    public void addToBasket() {
        addIphone.click();
        addSamsung.click();
        addNokia.click();
        addBlackberry.click();}

//public String getNumberOfItems() {
//        return itemsInCart.getText();

    public void checkBasket() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='nav-link btn btn-primary']"))).click();

    }
    public String priceToCheckOut() {
        return priceToCheckout.getText();
    }

}
