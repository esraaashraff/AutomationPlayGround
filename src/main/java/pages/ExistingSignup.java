package pages;

import org.example.driverfactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ExistingSignup {

    public Driver driver;
        By newUser = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2");
        By ClickonSignUplogin= By.xpath("//a[@href=\"/login\"]");
        By Entername = By.xpath("//input[@name=\"name\"]");
        By EnterEmail= By.xpath("//input[@data-qa=\"signup-email\"]");
        By ClickOnSignUPButton = By.xpath("//button[@data-qa=\"signup-button\"]");
        By existingmessage= By.cssSelector("#form > div > div > div:nth-child(3) > div > form > p");

        public ExistingSignup(Driver driver) {
            this.driver=driver;
    }

    public void checkthatNewUSerappears(){
        Assert.assertTrue(driver.element().isDisplayed(newUser),"New User Signup!");
            Assert.assertEquals(driver.element().gettextof(newUser),"New User Signup!");

    }

    public void filldata(String name, String email){
            driver.element().click(ClickonSignUplogin);
            driver.element().fillfield(Entername,name);
            driver.element().fillfield(EnterEmail,email);
            driver.element().click(ClickOnSignUPButton);
    }
    public void checkthatemailisexisting(){
        Assert.assertTrue(driver.element().isDisplayed(existingmessage),"Email Address already exist!");
    }

}

