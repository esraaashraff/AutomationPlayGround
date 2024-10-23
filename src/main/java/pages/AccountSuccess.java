package pages;

import org.example.driverfactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccountSuccess {

    public Driver driver;

    By successMessage= By.xpath("//h2[@data-qa=\"account-created\"]");
    By continueButton = By.xpath("//a[@data-qa=\"continue-button\"]");

    public AccountSuccess(Driver driver){
        this.driver=driver;
    }

    //------Assertions------

    public AccountSuccess checkthataccountshouldbecreatedsuccessfully(){
        Assert.assertTrue(driver.element().isDisplayed(successMessage),"ACCOUNT CREATED!");
        Assert.assertEquals(driver.element().gettextof(successMessage), "ACCOUNT CREATED!");
        return this;
    }

    ///Actions\\\
    public AccountSuccess continuebutton(){
        driver.element().click(continueButton);
        return this;
    }
}
