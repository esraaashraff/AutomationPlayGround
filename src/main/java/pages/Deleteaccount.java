package pages;

import org.example.driverfactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Deleteaccount {

       // public WebDriver driver;
    public WebDriver driver;
        By deletebutton = By.xpath("//a[@href=\"/delete_account\"]");
        By deleteMessage= By.xpath("//h2[@data-qa=\"account-deleted\"]");
        By continuetwoButton = By.xpath("//a[@data-qa=\"continue-button\"]");

        public Deleteaccount(WebDriver driver){
            this.driver=driver;
        }

        //------Assertions------

        public Deleteaccount checkthataccountshouldbedeletedsuccessfully(){
            Assert.assertTrue(driver.findElement(deleteMessage).isDisplayed());
            Assert.assertEquals(driver.findElement(deleteMessage).getText(), "ACCOUNT DELETED!");
            return this;
        }

        ///Actions\\\
        public Deleteaccount deletebutton(){
            driver.findElement(deletebutton).click();
            return this;
        }

        public Homepage continuetwoo(){
            driver.findElement(continuetwoButton).click();
            return new Homepage(driver);
        }
    }


