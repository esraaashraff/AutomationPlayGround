package tests;

import org.example.driverfactory.Driver;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import pages.Homepage;

import java.time.Duration;

public class TestParallel {

    public ThreadLocal<Driver> driver;

    @BeforeClass
    @Parameters(value = {"browser"})
    public void setUp(@Optional("Chrome") String browser) {
        driver = new ThreadLocal<>();
        driver.set(new Driver("Chrome"));
        driver.get().browserAction().MaximizeWindow();
        driver.get().browserAction().navigateToURL("https://automationexercise.com/");
        driver.get().get().manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

    }

    @Test
    public void contactUsTest() throws InterruptedException {
        driver.get().element().hoveronAnItem(By.xpath("(//div[@class=\"product-overlay\"])[1]"))
                .click(By.xpath("(//a[@class=\"btn btn-default add-to-cart\"])[1]"));
        Thread.sleep(5000);

        new Homepage(driver.get()).checkThatUserIsNavigatedToHomePage()
                .clickoncontactus()
                .checkthatcontactuspageisloadedsuccessfully()
                .datafill("Mohammed", "test12345@gmail.com", "Test", "Welcome")
                .checkthatformissubmittedsuccessfully()
                .successContact();




    }

//    @AfterMethod
//    public void screenshotOnFailure(ITestResult result) {
//
//        if(result.getStatus() == ITestResult.FAILURE){
//            System.out.println("Test Failed");
//            System.out.println("Taking screen shot.....");
//            ScreenShotManager.captureScreenshot(driver.get(), result.getName());
//        }
//
//    }

    @AfterClass
    public void tearDown() {
        driver.get().get().manage().deleteAllCookies();
        driver.get().quit();
    }
}