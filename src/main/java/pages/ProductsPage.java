package pages;
import org.example.driverfactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class ProductsPage {
        public Driver driver;

        By firstProductButton = By.xpath("//a[@href=\"/product_details/1\"]");
        By addToCartButton = By.className(".btn.btn-default.cart");
        By productName = By.xpath("//h2[contains(text(), 'Blue Top')]");
        By productCategory = By.xpath("//p[contains(text(),'Category')]");
        By productPrice = By.xpath("//span[contains(text(),'Rs. 500')]");
        By productAvailability = By.xpath("//b[contains(text(),'Availability:')]");
        By productCondition = By.xpath("//b[contains(text(),'Condition')]");
        By productBrand = By.xpath("//b[contains(text(),'Brand')]");
        By searchField = By.id("search_product");
        By submitSearchButton = By.id("submit_search");
        By pageHeader = By.className("title text-center");
        /************Actions*********/
        public ProductsPage clickOnFirstProductButton(){
            driver.element().click(firstProductButton);
            return this ;}

        public ProductsPage fillSearchWithText(){
            driver.element().fillfield(searchField,"Tshirt");
            driver.element().click(submitSearchButton);
            return this ;
        }
        /************Assertions*********/
        public ProductsPage checkThatUserNavigatedToProductsPage(){
            Assert.assertTrue(driver.get().getCurrentUrl().contains("products"));
            return this ;}
        public ProductsPage checkThatUserISLandedAtFirstProductPage(){
            driver.get().getCurrentUrl().contains("product_details");
            return this ;}
        public ProductsPage checkThatProductsListIsVisible(){
            List<WebElement> productList = driver.get().findElements(By.className("product-image-wrapper"));
            Assert.assertTrue(productList.size()>0,"Product list is not visible");
            return this ;}
        public ProductsPage checkThatProductDetailsAreVisible(){
            Assert.assertTrue(driver.element().isDisplayed(productName));
            Assert.assertTrue(driver.element().isDisplayed(productCategory));
            Assert.assertTrue(driver.element().isDisplayed(productAvailability));
            Assert.assertTrue(driver.element().isDisplayed(productBrand));
            Assert.assertTrue(driver.element().isDisplayed(productPrice));
            Assert.assertTrue(driver.element().isDisplayed(productCondition));
            return this ;}
        public ProductsPage checkThatSearchedProductsTitleIsVisible(){
            Assert.assertTrue(driver.element().isDisplayed(pageHeader));
            return this;
        }

        public ProductsPage(Driver driver) {
            this.driver = driver;
        }
    }


