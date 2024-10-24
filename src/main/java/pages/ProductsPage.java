package pages;

import org.example.browserActions.BrowserActions;
import org.example.driverfactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class ProductsPage {
    public Driver driver;

    By searchField = By.id("search_product");
    By submitSearchButton = By.id("submit_search");
    By pageHeader = By.cssSelector(".title.text-center");
    By firstProductButton = By.xpath("//a[@href=\"/product_details/1\"]");
    By secondProductButton= By.xpath("//a[@href=\"/product_details/2\"]");
    By addToCartButton = By.cssSelector(".btn.btn-default.cart");
    By productName = By.xpath("//h2[contains(text(), 'Blue Top')]");
    By productCategory = By.xpath("//p[contains(text(),'Category')]");
    By productPrice = By.xpath("//span[contains(text(),'Rs. 500')]");
    By productAvailability = By.xpath("//b[contains(text(),'Availability:')]");
    By productCondition = By.xpath("//b[contains(text(),'Condition')]");
    By productBrand = By.xpath("//b[contains(text(),'Brand')]");
    By continueShoppingButton = By.xpath("button[@class='btn btn-success close-modal btn-block']");
  //  By viewCartButton =By.xpath("//a[contains(text(),'View Cart')]");
  By viewCartButton =By.xpath("//a[contains(text(), 'View Cart')]");

    By ProductLink = By.xpath( "//a[@href=\"/products\"]");
    By productQuantity = By.cssSelector(".cart_quantity");
    By productTotalPrice = By.cssSelector(".cart_total");
    By cartProductList = By.cssSelector(".cart_product");

    /************Actions*********/
    public ProductsPage clickOnFirstProductButton(){
        driver.element().click(firstProductButton);
        return this ;}

    public ProductsPage clickOnSecondProductButton(){
        driver.element().click(secondProductButton);
        return this ;}

    public ProductsPage hoverAndAddFirstProductToCart() {
        Actions actions = new Actions(driver.get());
        actions.moveToElement(driver.get().findElement(firstProductButton)).perform();
        driver.get().findElement(addToCartButton).click();
        return this ;}

    public ProductsPage hoverAndAddSecondProductToCart() {
        Actions actions = new Actions(driver.get());
        actions.moveToElement(driver.get().findElement(secondProductButton)).perform();
        driver.get().findElement(addToCartButton).click();
        return this ;}

    public ProductsPage clickContinueShopping() {
        WebDriverWait wait= new WebDriverWait(driver.get(), Duration.ofSeconds(2));
        driver.element().click(continueShoppingButton);
        return this ;}

    public ProductsPage clickAddToCart() {
        driver.element().click(addToCartButton);
        return this ;}
//page edited
    public CartPage clickViewCart() {
        WebDriverWait wait= new WebDriverWait(driver.get(), Duration.ofSeconds(2));
        driver.get().findElement(viewCartButton).click();
        return new CartPage(driver);
    }

    public ProductsPage returnToProducts() {
        driver.element().click(ProductLink);
        return this;
    }
    public ProductsPage fillSearchWithText(){
        driver.element().fillfield(searchField,"Tshirt");
        driver.element().click(submitSearchButton);
        return this ;}
    /************Assertions*********/
    public ProductsPage checkThatUserNavigatedToProductsPage(){
        Assert.assertTrue(driver.browserAction().getCurrentURL().contains("products"));
        return this ;}

    public ProductsPage checkThatUserISLandedAtFirstProductPage(){
        driver.browserAction().getCurrentURL().contains("product_details");
        return this ;}
    public ProductsPage checkThatUserISLandedAtSecondProductPage(){
        driver.browserAction().getCurrentURL().contains("product_details");
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
        return this;}


    public ProductsPage(Driver driver) {
        this.driver = driver;
    }
}