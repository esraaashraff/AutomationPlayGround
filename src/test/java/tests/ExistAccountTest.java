package tests;

import org.example.driverfactory.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ExistingSignup;
import pages.Testcases;

import java.time.Duration;

public class ExistAccountTest {
    Driver driver;
    ExistingSignup ExistingSignUp;
    Testcases Testcases;

    @BeforeClass
    public void setup(){
        driver= new Driver("Chrome");
    }

    @Test
    public void test(){
        ExistingSignUp= new ExistingSignup(driver);
        Testcases = new Testcases(driver);

        /////////------Exist signup Test------\\\\
        driver.browserAction().navigateToURL("https://automationexercise.com/");
        driver.browserAction().MaximizeWindow();
        ExistingSignUp.filldata("Esraa", "test200@gmail.com");
        ExistingSignUp.checkthatNewUSerappears();
        ExistingSignUp.checkthatemailisexisting();


        ////////----TestCases Page-----\\\\\\\\
      //  Testcases.CheckthatHomePageAppeared();
        Testcases.ClickonTestCasesButton();
        Testcases.checkthatTestCasesPageOpened();
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

    }

    @AfterClass
    public void teardown(){
     driver.quit();
    }
}
