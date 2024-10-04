package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ExistingSignup {
    public WebDriver driver;
        By newUser = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2");
        By ClickonSignUplogin= By.xpath("//a[@href=\"/login\"]");
        By Entername = By.xpath("//input[@name=\"name\"]");
        By EnterEmail= By.xpath("//input[@data-qa=\"signup-email\"]");
        By ClickOnSignUPButton = By.xpath("//button[@data-qa=\"signup-button\"]");
        By existingmessage= By.cssSelector("#form > div > div > div:nth-child(3) > div > form > p");

        public ExistingSignup(WebDriver driver) {
            this.driver=driver;
    }


    public void checkthatNewUSerappears(){
        Assert.assertTrue(driver.findElement(newUser).isDisplayed());
            Assert.assertEquals(driver.findElement(newUser).getText(),"New User Signup!");

    }

    public void filldata(String name, String email){
            driver.findElement(ClickonSignUplogin).click();
            driver.findElement(Entername).sendKeys(name);
            driver.findElement(EnterEmail).sendKeys(email);
            driver.findElement(ClickOnSignUPButton).click();
    }
    public void checkthatemailisexisting(){

    }

}

