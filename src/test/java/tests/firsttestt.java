package tests;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;


public class firsttestt {
    WebDriver driver;
@BeforeClass
    public void OPenWebsite() {
        driver = new ChromeDriver();

        driver.navigate().to("https://automationexercise.com/login");
    }

    @Test(priority = 1)
    public void SignUP(){
        driver.navigate().to("https://automationexercise.com/login");
        driver.findElement(By.name("name")).sendKeys("Esraa");
        driver.findElement(By.xpath("(//input[@name=\"email\"])[2]")).sendKeys("test550@gmail.com");
        driver.findElement(By.xpath("//button[@data-qa=\"signup-button\"]")).click();
        driver.findElement(By.id("password")).sendKeys("esraa2024");
        driver.findElement(By.id("first_name")).sendKeys("Esraa");
        driver.findElement(By.id("last_name")).sendKeys("Esraa");
        driver.findElement(By.id("address1")).sendKeys("Alex");
        driver.findElement(By.id("state")).sendKeys("Alex");
        driver.findElement(By.id("city")).sendKeys("Alex");
        driver.findElement(By.id("zipcode")).sendKeys("555412");
        driver.findElement(By.id("mobile_number")).sendKeys("012215438");
        WebElement dropdown= driver.findElement(By.xpath("//select[@id=\"country\"]"));
        Select select= new Select(dropdown);
        select.selectByValue("Australia");
        driver.findElement(By.xpath("//button[@data-qa=\"create-account\"]")).click();
        WebElement successMessage = driver.findElement(By.xpath("//h2[@data-qa=\"account-created\"]"));
        Assert.assertTrue(successMessage.isDisplayed());
        Assert.assertEquals(successMessage.getText(), "ACCOUNT CREATED!");
        driver.findElement(By.xpath("//a[@data-qa=\"continue-button\"]")).click();
         driver.findElement(By.xpath("//a[@href=\"/logout\"]")).click();

    }

    @Test(priority = 2, dependsOnMethods = "SignUP")
    public void Login(){
        driver.navigate().to("https://automationexercise.com/login");
        driver.findElement(By.xpath("(//input[@name=\"email\"])[1]")).sendKeys("test550@gmail.com");
        driver.findElement(By.xpath("//input[@data-qa=\"login-password\"]")).sendKeys("esraa2024");
        driver.findElement(By.xpath("//button[@data-qa=\"login-button\"]")).click();
        WebElement logout = driver.findElement(By.xpath("//a[@href=\"/logout\"]"));
        Assert.assertTrue(logout.isDisplayed());

    }

    @AfterClass
    public void Teardown(){

    }
}