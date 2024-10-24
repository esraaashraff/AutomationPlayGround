package tests;

import org.example.driverfactory.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ExistingSignup;
import pages.Homepage;
import pages.Testcases;

public class CartPageTest
{
    Driver driver;

    @BeforeClass
    public void setUp()
    {
        driver= new Driver("Chrome");
        driver.browserAction().MaximizeWindow();
        driver.browserAction().navigateToURL("https://automationexercise.com/");
    }


    @Test(priority = 1)  //Test Case 12: Add Products in Cart
    public void verifyCartProductsAndPrices() {

        new Homepage(driver)
                .checkThatUserIsNavigatedToHomePage()
                .clickOnProductLink()
                // .hoverAndAddFirstProductToCart()
                .clickOnFirstProductButton()
                .clickAddToCart()
                .clickContinueShopping()
                .returnToProducts()
                // .hoverAndAddSecondProductToCart()
                .clickOnSecondProductButton()
                .clickAddToCart()
                .clickViewCart()
                .verifyProductsInCart()
                .verifyProductDetails();
    }



    @Test(priority = 2)  //Test Case 17: Remove Products From Cart
    public void testRemoveProductFromCart() {
        new Homepage(driver).navigateToHomePage()
                .checkThatUserIsNavigatedToHomePage()
                .clickOnProductLink()
                .clickOnFirstProductButton()
                .clickAddToCart()
                .clickViewCart()
                .verifyProductsInCart()
                .removeProductFromCart()
                .verifyProductIsRemoved();
    }

    @AfterClass
    public void tearDown()
    {
        driver.browserAction().DeleteAllCookies();
        driver.quit();
    }

}


