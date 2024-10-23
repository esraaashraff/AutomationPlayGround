package pages;

import org.example.driverfactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Homepage {
    public Driver driver;

    By logoutlink = By.xpath("//a[@href=\"/logout\"]");
    By loginlink = By.xpath("//a[@href=\"/login\"]");
    By Deleteaccount = By.xpath("//a[@href=\"/delete_account\"]");
    By contactus = By.xpath("//a[@href=\"/contact_us\"]");


    public Homepage(Driver driver){
        this.driver=driver;
    }

    //-----Assertions-----\\

    public Homepage checkthatLogoutLinkisDisplayed(){
        Assert.assertTrue(driver.element().isDisplayed(logoutlink), "login link isn't displayed");
        return this;
    }

    public Homepage checkthatDeleteaccountLinkisDisplayed(){
        Assert.assertTrue(driver.element().isDisplayed(Deleteaccount), "Deleteaccount link isn't displayed");
    return this;
    }



    //------Methods of Actions-----\\
    public LoginSignUpPage clickonLoginlink(){
        driver.element().click(loginlink);
        return new LoginSignUpPage(driver);
    }

    public LoginSignUpPage clickonLogoutlink() {
        driver.element().click(logoutlink);
        return new LoginSignUpPage(driver); }


    public Homepage clickoncontactus(){
        driver.element().click(contactus);
        return new Homepage(driver); }

}
