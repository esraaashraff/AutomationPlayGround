package pages;

import org.example.driverfactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccountSuccess {
   // public WebDriver driver;
public WebDriver driver;

    By successMessage= By.xpath("//h2[@data-qa=\"account-created\"]");
    By continueButton = By.xpath("//a[@data-qa=\"continue-button\"]");

    public AccountSuccess(WebDriver driver){
        this.driver=driver;
    }

    //------Assertions------

    public AccountSuccess checkthataccountshouldbecreatedsuccessfully(){
        Assert.assertTrue(driver.findElement(successMessage).isDisplayed());
        Assert.assertEquals(driver.findElement(successMessage).getText(), "ACCOUNT CREATED!");
        return this;
    }

    ///Actions\\\
    public AccountSuccess continuebutton(){
        driver.findElement(continueButton).click();
        return this;
    }
}
