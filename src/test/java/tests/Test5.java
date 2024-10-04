package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ExistingSignup;
import pages.Products;
import pages.Testcases;

import java.time.Duration;

public class Test5 {
    WebDriver driver;
    WebDriverWait wait;
    ExistingSignup ExistingSignUp;
    Testcases Testcases;
    Products Products;
    @BeforeClass
    public void setup(){
        driver= new ChromeDriver();
    }

    @Test
    public void test(){
        ExistingSignUp= new ExistingSignup(driver);
        Testcases = new Testcases(driver);
        Products = new Products(driver);

        driver.navigate().to("https://automationexercise.com/");
        ExistingSignUp.filldata("Esraa", "test200@gmail.com");
        ExistingSignUp.checkthatNewUSerappears();
        ExistingSignUp.checkthatemailisexisting();


        driver.navigate().to("https://automationexercise.com/");
        Testcases.CheckthatHomePageAppeared();
        Testcases.ClickonTestCasesButton();
        Testcases.checkthatTestCasesPageOpened();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        Products.ClickOnProductsPage();
        Products.CheckthatProductsPageisOpened();
        Products.ClickOnView();
        //Products.CheckthatdetailsisOpened();
        Products.CheckthatProductsdetailsisOpened();


    }

    @AfterClass
    public void teardown(){
     driver.quit();
    }
}
