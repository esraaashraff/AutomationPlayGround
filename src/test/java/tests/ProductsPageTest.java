package tests;

import org.example.driverfactory.Driver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Homepage;

public class ProductsPageTest {
        Driver driver;


        @BeforeTest
        public void setUp() {
            driver = new Driver("Chrome");
            driver.browserAction().MaximizeWindow();
        }

        @Test(priority = 1)
        public void userCanVerifyAllProductsAndDetails() {
            driver.browserAction().navigateToURL("https://automationexercise.com/");
            new Homepage(driver)
                .clickOnProductLink().checkThatUserNavigatedToProductsPage().checkThatUserNavigatedToProductsPage()
                .checkThatProductsListIsVisible().clickOnFirstProductButton().checkThatUserISLandedAtFirstProductPage()
                .checkThatProductDetailsAreVisible();
        }

        @Test(priority = 2)
        public void userCanSearchProduct(){
            driver.browserAction().navigateToURL("https://automationexercise.com/");
            new Homepage(driver).clickOnProductLink().checkThatUserNavigatedToProductsPage().checkThatProductsListIsVisible()
                    .fillSearchWithText().checkThatSearchedProductsTitleIsVisible();
        }
        @AfterTest
        public void quit () {
            driver.browserAction().DeleteAllCookies();
            driver.quit();
        }
    }

