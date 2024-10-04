package pages;

import org.example.driverfactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Homepage {
    //public WebDriver driver;
    public WebDriver driver;

    By logoutlink = By.xpath("//a[@href=\"/logout\"]");
    By loginlink = By.xpath("//a[@href=\"/login\"]");
    By Deleteaccount = By.xpath("//a[@href=\"/delete_account\"]");
    By contactus = By.xpath("//a[@href=\"/contact_us\"]");


    public Homepage(WebDriver driver){
        this.driver=driver;
    }

    //-----Assertions-----\\

    public Homepage checkthatLogoutLinkisDisplayed(){
        Assert.assertTrue(driver.findElement(logoutlink).isDisplayed(), "login link isn't displayed");
        return this;
    }

    public Homepage checkthatDeleteaccountLinkisDisplayed(){
        Assert.assertTrue(driver.findElement(Deleteaccount).isDisplayed(), "Deleteaccount link isn't displayed");
    return this;
    }



    //------Methods of Actions-----\\
    public LoginSignUpPage clickonLoginlink(){
        driver.findElement(loginlink).click();
        return new LoginSignUpPage(driver);
    }

    public LoginSignUpPage clickonLogoutlink() {
        driver.findElement(logoutlink).click();
        return new LoginSignUpPage(driver); }


    public Homepage clickoncontactus(){
        driver.findElement(contactus).click();
        return new Homepage(driver); }

}
