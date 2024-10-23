package pages;

import org.example.driverfactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Deleteaccount {
    public Driver driver;
        By deletebutton = By.xpath("//a[@href=\"/delete_account\"]");
        By deleteMessage= By.xpath("//h2[@data-qa=\"account-deleted\"]");
        By continuetwoButton = By.xpath("//a[@data-qa=\"continue-button\"]");

        public Deleteaccount(Driver driver){
            this.driver=driver;
        }

        ////////////------Assertions------\\\\\\\\\\\\\\\\\

        public Deleteaccount checkthataccountshouldbedeletedsuccessfully(){
            Assert.assertTrue(driver.element().isDisplayed(deleteMessage), "ACCOUNT DELETED!");
            Assert.assertEquals(driver.element().gettextof(deleteMessage), "ACCOUNT DELETED!");
            return this;
        }

        /////////////------Actions---------\\\\\\\\\\\\\\\
        public Deleteaccount deletebutton(){
            driver.element().click(deletebutton);
            return this;
        }

        public Homepage continuetwoo(){
            driver.element().click(continuetwoButton);
            return new Homepage(driver);
        }
    }


