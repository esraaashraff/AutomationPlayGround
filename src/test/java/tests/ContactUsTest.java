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
    Homepage homepage;
    Contactus contactus;
    Driver driver;

    @BeforeClass
    @Parameters(value = {"browserName"})
    public void setUp(@Optional("EDGE") String browserName){
        driver= new Driver("Chrome");
        driver.browserAction().MaximizeWindow();
        driver.browserAction().navigateToURL("https://automationexercise.com/");

    }

    @Test
    public void test() {

        new Homepage(driver)
                .clickoncontactus();

        new Contactus(driver)
                .checkthatcontactuspageisloadedsuccessfully()
                .datafill("Esraa", "esraa@gmail.com", "Contact Message", "Thank you for making this website easy to use!")
                .successContact();
        ScreenShotManager.captureScreenShot(driver.get(), "ContactUS");

    }
//    new ElementActions(driver.get())
//            .hoveronAnItem(By.xpath("(//div[@class=\"product-overlay\"])[1]"));
//        driver.element().hoveronAnItem(By.xpath("(//div[@class=\"product-overlay\"])[1]"));
//        driver.element().ClickonAnItem(By.xpath("(//div[@class=\"product-overlay\"])[1]"));
//        driver.get().navigate().to("https://automationexercise.com/contact_us");
//    //ScreenShotManager.captureScreenShot(driver,"ContactUs" );

//    @AfterMethod
//    public void ScreenshotOnFailure(ITestResult result){
//        if (result.getStatus()==ITestResult.FAILURE)
//            System.out.println("Test is Faild");
//            System.out.println("Taking Screenshot");
//        ScreenShotManager.captureScreenShot(driver, result.getName() );
//
//    }
//
//    @AfterMethod
//    public void ScreenshotOnSuccess(ITestResult result){
//        if (result.getStatus()==ITestResult.SUCCESS)
//            System.out.println("Test is Successed");
//        System.out.println("Taking Screenshot");
//        ScreenShotManager.captureScreenShot(driver, result.getName() );
//
//
//    }
    @AfterTest
    public void teardown(){
        driver.browserAction().DeleteAllCookies();
        driver.quit();
    }
}