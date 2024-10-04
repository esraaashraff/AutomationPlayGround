package tests;

import junit.framework.Assert;
import org.example.driverfactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.*;

public class MyFirstTest {
    WebDriver driver;
   // Driver driver;


    @BeforeClass
    public void setup() {
    driver= Driver.getDriver("chrome").startdriver()  ;
    }

    @Test(priority = 1)
    public void usercanRegistersuccessfully() {
        /* LoginSignUpPage = new LoginSignUpPage(driver);
        Homepage = new Homepage(driver);
        RegisterPage = new RegisterPage(driver);
        creation = new AccountSuccess(driver);
        Deleteaccount = new Deleteaccount(driver);

        driver.navigate().to("https://automationexercise.com/login");
        LoginSignUpPage.fillinSignUPName("Esraa");
        LoginSignUpPage.fillinSignUPEmail("test666@gmail.com");
        LoginSignUpPage.clickonSignUPButton();


        RegisterPage.enterfirstname("Esraa");
        RegisterPage.enterlastname("Soso");
        RegisterPage.enterpassword("esraa2024");
        RegisterPage.enteraddress("Alex");
        RegisterPage.entercity("Alex");
        RegisterPage.enterstate("Alex");
        RegisterPage.enterzipcode("555412");
        RegisterPage.entermobileno("012215438");
        RegisterPage.entercountry();
        RegisterPage.clickoncreateButton();

        creation.checkthataccountshouldbecreatedsuccessfully();// problem
        creation.continuebutton();
        driver.manage().deleteAllCookies();

  /*WebElement dropdown = driver.findElement(By.xpath("//select[@data-qa=\"country\"]"));
  driver.findElement(By.xpath("//option[@value=\"United States\"]")).click();
  driver.findElement(By.xpath("//button[@data-qa=\"create-account\"]")).click();

   */
        driver.navigate().to("https://automationexercise.com/login");
new LoginSignUpPage( driver)
        .fillinSignUPName("Esraa")
        .fillinSignUPEmail("test9590@gmail.com")
        .clickonSignUPButton();

new RegisterPage(driver)
        .enterfirstname("Es")
        .enterlastname("raa")
        .enterpassword("12345")
        .enteraddress("Alex")
        .entercity("Alex")
        .enterstate("Alex")
        .enterzipcode("4444")
        .entermobileno("01224578")
        .entercountry()
        .clickoncreateButton();

    }


    @Test(priority = 2, dependsOnMethods = "usercanRegistersuccessfully")

    public void usercanLogin() {
        new AccountSuccess(driver).checkthataccountshouldbecreatedsuccessfully()
                        .continuebutton();
        new Homepage(driver).clickonLogoutlink();

        new LoginSignUpPage(driver)
                .fillinloginEmail("test9590@gmail.com")
                .fillinloginPassword("12345")
                .clickonloginButton();

    }

    @Test(priority = 3, dependsOnMethods = "usercanLogin")
    public void usercandelete() {
        new Deleteaccount(driver)
                .deletebutton()
                .checkthataccountshouldbedeletedsuccessfully()
                .continuetwoo();

    }


    @AfterClass
    public void TearDown() {
        // driver.quit();
    }

}
