package tests;

import org.example.driverfactory.Driver;
import org.example.driverfactory.DriverInterface;
import org.example.elementactions.ElementActions;
import org.example.utilities.ScreenShotManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.Contactus;
import pages.Homepage;

import java.time.Duration;

public class ContactUsTest {
    //WebDriverWait wait;
    Homepage homepage;
    Contactus contactus;
    WebDriver driver;
    //ThreadLocal<Driver> driver;

    @BeforeClass
    @Parameters(value = {"browserName"})
    public void setUp(@Optional("EDGE") String browserName){
//wait = new WebDriverWait(this.driver, Duration.ofSeconds(40));
        driver= Driver.getDriver("Chrome" ).startdriver();
//driver=new ThreadLocal<>();
       // driver.set(new Driver(browserName));
        driver.manage().window().maximize();
        driver.navigate().to("https://automationexercise.com/");

    }

    @Test
    public void test(){
        new ElementActions(driver)
        .hoveronAnItem(By.xpath("(//div[@class=\"product-overlay\"])[1]"));
        //.ClickonAnItem(By.cssSelector("btn.btn-default.add-to-cart"));
       // driver.element().hoveronAnItem(By.xpath("(//div[@class=\"product-overlay\"])[1]"));
        //     .click(By.xpath("(//a[@class=\"btn btn-default add-to-cart\"])[1]"));
        driver.navigate().to("https://automationexercise.com/contact_us");

        new Homepage(driver)
                .clickoncontactus();
        new Contactus(driver)
                .checkthatcontactuspageisloadedsuccessfully()
                .datafill("Esraa", "esraa@gmail.com","hello","Iam happu to see you")
                .successContact();
        ScreenShotManager.captureScreenShot(driver,"ContactUs" );

        //wait.until(ExpectedConditions.alertIsPresent());
    }

    @AfterMethod
    public void ScreenshotOnFailure(ITestResult result){
        if (result.getStatus()==ITestResult.FAILURE)
            System.out.println("Test is Faild");
            System.out.println("Taking Screenshot");
        ScreenShotManager.captureScreenShot(driver, result.getName() );

    }

    @AfterMethod
    public void ScreenshotOnSuccess(ITestResult result){
        if (result.getStatus()==ITestResult.SUCCESS)
            System.out.println("Test is Successed");
        System.out.println("Taking Screenshot");
        ScreenShotManager.captureScreenShot(driver, result.getName() );


    }
    @AfterTest
    public void teardown(){
        driver.manage().deleteAllCookies();

    }
}