package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SelectTest extends MainTest{
    @Test(priority = 1)
    @Parameters({"url"})
    public void getUrl(String url){
        driver.get(url);

    }

    @Test(priority = 2)
    @Parameters({"url"})
    public void verifyUrl(String url){
        Assert.assertEquals(driver.getCurrentUrl(),url);
    }

    @Test(priority = 3)
    public void selectCategory(){
        WebElement categoryDropDown = driver.findElement(By.id("gh-cat"));
        Select select = new Select(categoryDropDown);
        select.selectByVisibleText("Cell Phones & Accessories");
    }

    @Test(priority = 4)
    public void search(){
        WebElement searchBox = driver.findElement(By.id("gh-ac"));
        searchBox.sendKeys("Mobile phone");
        driver.findElement(By.id("gh-btn")).click();
    }

    @Test(priority = 5)
    public void selectApple(){
        WebElement appleCheckBox = driver.findElement(By.xpath("//*[@id=\"x-refine__group_1__0\"]/ul/li[1]/div/a/div/span/input"));
        appleCheckBox.click();
    }

    @Test(priority = 6)
    public void selectFirstItem() throws InterruptedException {
        WebElement firstElement = driver.findElement(By.xpath("//*[@id=\"srp-river-results\"]/ul/li[2]/div/div[2]/a/div/span"));
        firstElement.click();

        Thread.sleep(5000);

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
    }

}
