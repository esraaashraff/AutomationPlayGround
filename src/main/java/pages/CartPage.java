package pages;
import org.example.driverfactory.Driver;
import org.example.elementactions.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;


    public class CartPage {
        private Driver driver;
        WebDriverWait wait;
        By cartProductList = By.cssSelector(".cart_product");
        By productPrice = By.cssSelector(".cart_price");
        By productQuantity = By.cssSelector(".cart_quantity");
        By productTotalPrice = By.cssSelector(".cart_total");

        By removeButton =  By.xpath(" //*[@id=\"product-1\"]/td[6]/a");
        By emptyCart = By.xpath("//*[@id=\"empty_cart\"]/p/b");
        public CartPage(Driver driver) {
            this.driver = driver;
            wait =  new WebDriverWait(driver.get(), Duration.ofSeconds(30));
        }

        public CartPage removeProductFromCart() {

            driver.element().click(removeButton);
            return this;
        }

        public CartPage verifyProductIsRemoved() {

            wait.until(ExpectedConditions.visibilityOf(driver.get().findElement(emptyCart)));
            Assert.assertTrue(driver.get().findElement(emptyCart).isDisplayed());
            Assert.assertEquals(driver.element().gettextof(emptyCart),  "Cart is empty!");
            return this;
        }

        public CartPage verifyProductsInCart() {
            int productCount = driver.get().findElements(cartProductList).size();
            Assert.assertTrue(productCount > 0, "No products found in the cart!");
            return this;
        }

        public CartPage verifyProductDetails() {
            for (int i = 0; i < driver.get().findElements(cartProductList).size(); i++) {
                // Use regex to remove any non-numeric characters, such as currency symbols
                String price = driver.get().findElements(productPrice).get(i).getText().replaceAll("[^0-9.]", "");
                String quantity = driver.get().findElements(productQuantity).get(i).getText();
                String total = driver.get().findElements(productTotalPrice).get(i).getText().replaceAll("[^0-9.]", "");

                // Debugging: Print the values being captured
                System.out.println("Price: " + price);
                System.out.println("Quantity: " + quantity);
                System.out.println("Total: " + total);

                double expectedTotal = Double.parseDouble(price) * Integer.parseInt(quantity);

                // Adding print statement before assertion to verify expected and actual total
                System.out.println("Expected Total: " + expectedTotal);

                try {
                    Assert.assertEquals(Double.parseDouble(total), expectedTotal, "Price mismatch for product at index " + i);
                } catch (AssertionError e) {
                    System.out.println("Assertion Failed: " + e.getMessage());
                }
            }
            return this;
        }

    }

