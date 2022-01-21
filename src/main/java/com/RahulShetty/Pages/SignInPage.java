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

import static com.RahulShetty.TestDataReader.*;

public class SignInPage {

    WebDriver driver;
    String username = getUsername();
    String password = getPassword();
    String occupation = getOccupation();

    public SignInPage(WebDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='username']")
    WebElement usernameBox;

    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordBox;

    @FindBy(xpath = "//label[2]//span[2]")
    WebElement userButton;

    @FindBy(xpath = "//form[@id='login-form']/div[5]/select")
    WebElement dropDownMenu;

    @FindBy(xpath = "//p[contains(text(),'You will be limited to only fewer functionalities ')]")
    WebElement successMessage;

    public void signingIn() {
        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);
        userButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='okayBtn']"))).click();

    }

    public String successMessage() {
        return successMessage.getText();
    }

    public void pressButtons() {
        //Select drpRole = new Select(driver.findElement(By.xpath("//form[@id='login-form']/div[5]/select")));
        //drpRole.selectByVisibleText("consultant");
        //Select dropdown = new Select(driver.findElement(By.xpath("//form[@id='login-form']/div[5]/select")));

        //Select role = new Select(roleBox);
        //role.selectByVisibleText("consult");
        Select fromMenu = new Select (dropDownMenu);
        fromMenu.selectByVisibleText(occupation);

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='terms']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='signInBtn']"))).click();
    }
}
