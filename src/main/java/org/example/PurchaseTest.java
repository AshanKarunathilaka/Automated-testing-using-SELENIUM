package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PurchaseTest extends MainTest {

    private String itemTitle;
    private String price;

    @Test(priority = 7)
    public void selectModel() {
        try {
            WebElement selectBox = driver.findElement(By.cssSelector("select[selectboxlabel='Model']"));
            Select selectBoxLabel = new Select(selectBox);
            selectBoxLabel.selectByIndex(1);
        } catch (Exception e) {
            System.out.println("Model not found");
        }
    }

    @Test(priority = 8)
    public void selectCarrier() {
        try {
            WebElement selectBox = driver.findElement(By.cssSelector("select[selectboxlabel='Carrier']"));
            Select selectBoxLabel = new Select(selectBox);
            selectBoxLabel.selectByIndex(1);
        } catch (Exception e) {
            System.out.println("Carrier not found");
        }
    }


    @Test(priority = 9)
    public void selectStorage() {
        try {
            WebElement selectBox = driver.findElement(By.cssSelector("select[selectboxlabel='Storage Capacity'], select[selectboxlabel='Storage']"));
            Select selectBoxLabel = new Select(selectBox);
            selectBoxLabel.selectByIndex(1);
        } catch (Exception e) {
            System.out.println("Storage not found");
        }
    }

    @Test(priority = 10)
    public void selectColor() {
        try {
            WebElement selectBox = driver.findElement(By.cssSelector("select[selectboxlabel='Color'], select[selectboxlabel='Colour']"));
            Select selectBoxLabel = new Select(selectBox);
            selectBoxLabel.selectByIndex(1);
        } catch (Exception e) {
            System.out.println("Color not found");
        }
    }


    @Test(priority = 11)
    public void selectCosmetic() {
        try {
            WebElement selectBox = driver.findElement(By.cssSelector("select[selectboxlabel='Cosmetic']"));
            Select selectBoxLabel = new Select(selectBox);
            selectBoxLabel.selectByIndex(1);
        } catch (Exception e) {
            System.out.println("Cosmetic not found");
        }
    }

    @Test(priority = 12)
    public void itemName() {
        itemTitle = driver.findElement(By.cssSelector("h1.x-item-title__mainTitle")).getText().trim();
        System.out.println("Item title: " + itemTitle);
    }


    @Test(priority = 13)
    public void itemPrice() {
        price = driver.findElement(By.xpath("//span[@itemprop='price']//span[@class='ux-textspans']")).getText().trim();
        System.out.println("Item price : " + price);
    }


    @Test(priority = 14)
    public void itemCondition() {
        String condition = driver.findElement(By.xpath("//div[@class='x-item-condition-text']//span[@class='ux-textspans']")).getText().trim();
        System.out.println("Item condition : " + condition);
    }


    @Test(priority = 15)
    public void itemQuantity() {
        String quantity = driver.findElement(By.id("qtyTextBox")).getAttribute("value");
        System.out.println("Item quantity : " + quantity);
    }


    @Test(priority = 16)
    public void addItemToCart() {
        WebElement addToCartButton = driver.findElement(By.xpath("//a[@class='ux-call-to-action fake-btn fake-btn--fluid fake-btn--primary']//span[@class='ux-call-to-action__text' and text()='Add to cart']"));
        addToCartButton.click();
    }


    @Test(priority = 17)
    public void checkItemName() {
        String title = driver.findElement(By.className("item-title")).getText().trim();
        Assert.assertEquals(title, itemTitle);
    }


    @Test(priority = 18)
    public void checkItemPrice() {
        String subtotalValue = driver.findElement(By.cssSelector("div[data-test-id='SUBTOTAL']")).getText().trim();
        Assert.assertEquals(subtotalValue, price);
    }


    @Test(priority = 19)
    public void checkQuantity() {
        WebElement dropdown = driver.findElement(By.xpath("//label[text()='Qty']/following-sibling::span/select"));
        String selectedOption = dropdown.getAttribute("value");
        System.out.println("Selected option: " + selectedOption);
    }


    @Test(priority = 20)
    public void ShippingCost() {
        WebElement shippingElement = driver.findElement(By.cssSelector("div[data-test-id='SHIPPING']"));
        String shippingCost = shippingElement.getText().trim();
        System.out.println("Shipping value : " + shippingCost);
    }

}