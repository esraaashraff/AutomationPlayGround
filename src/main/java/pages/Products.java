package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Products {
    public WebDriver driver;

    By Openhomepage= By.xpath("//header[@id=\"header\"]");
    By clickOnProductsButton= By.xpath("//a[@href=\"/products\"]");
    By ProductsPageisOpened = By.cssSelector("div.col-sm-9.padding-right .features_items");
    By ClickOnviewFirstProduct= By.xpath("//a[@href=\"/product_details/1\"]");
    //By ProductdetailesPage= By.linkText("https://automationexercise.com/product_details/1");
    By Productdetailesappeared = By.cssSelector("div.product-details .col-sm-7");

    public Products(WebDriver driver) {
        this.driver=driver;
    }

    public void CheckthatHomePageisOpened(){
        Assert.assertTrue(driver.findElement(Openhomepage).isDisplayed());
    }

    public void ClickOnProductsPage(){
        driver.findElement(clickOnProductsButton).click();
    }
    public void CheckthatProductsPageisOpened(){
        Assert.assertTrue(driver.findElement(ProductsPageisOpened).isDisplayed());
    }

    public void ClickOnView(){
        driver.findElement(ClickOnviewFirstProduct).click();
    }

    /*public void CheckthatdetailsisOpened(){
        Assert.assertTrue(driver.getCurrentUrl(ProductdetailesPage).isDisplayed());
    } */

    public void CheckthatProductsdetailsisOpened(){
        Assert.assertTrue(driver.findElement(Productdetailesappeared).isDisplayed());
    }
}
