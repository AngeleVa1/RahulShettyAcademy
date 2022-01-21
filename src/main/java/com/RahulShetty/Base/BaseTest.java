package com.RahulShetty.Base;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;

import static com.RahulShetty.TestDataReader.*;

public class BaseTest {

    public WebDriver driver;

    DesiredCapabilities dc;

    @BeforeTest
    public void setUp() throws IOException {

        String browser = getBrowser();
        String baseUrl = getUrl();

        String nodeUrl = getNode();


        dc = new DesiredCapabilities();
        dc.setPlatform(Platform.WINDOWS);
        dc.setBrowserName(browser);
        driver = new RemoteWebDriver(new URL(nodeUrl), dc);
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();

    }

    @AfterTest
    public void tearDown() {
        //driver.close();
    }
}
