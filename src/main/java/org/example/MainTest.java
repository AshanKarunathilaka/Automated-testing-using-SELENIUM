package org.example;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainTest {

    protected static WebDriver driver;
    @BeforeTest
    public void setUp(){
        System.setProperty("Webdriver.chrome.driver","src/main/resources/driver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;



    }

    @AfterTest
    public void quitBrowser() {
        driver.quit();
    }
}