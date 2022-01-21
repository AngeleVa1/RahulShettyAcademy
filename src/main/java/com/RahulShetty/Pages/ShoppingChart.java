package com.RahulShetty.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ShoppingChart {

    WebDriver driver;

    public ShoppingChart(WebDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//tbody/tr[1]/td[5]/button[1]")
    WebElement removeButton;

    @FindBy(xpath = "//strong[contains(text(),'₹. 200000')]")
    WebElement priceForThree;

    @FindBy(xpath = "//button[normalize-space()='Continue Shopping']")
    WebElement continueShoppingButton;

    @FindBy(xpath = "//app-card[2]//div[1]//div[2]//button[1]")
    WebElement addSamsungButton;

    @FindBy(xpath = "//table[@class='table table-hover']/tbody/tr[2]/td[2]/input")
    WebElement addNumberOfItems;


    public void basket() {
        removeButton.click();
    }

    public String checkOutPriceForThreeItem() {
        return priceForThree.getText();
    }

    public void addedOneAdditional() {
        addNumberOfItems.click();
        Actions act = new Actions(driver);
        act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys("2").build().perform();

    }

}
