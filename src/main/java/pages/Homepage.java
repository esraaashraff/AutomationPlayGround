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
    By ProductLink = By.xpath( "//a[@href=\"/products\"]");

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


    public Contactus clickoncontactus(){
        driver.element().click(contactus);
        return new Contactus(driver); }

    public ProductsPage clickOnProductLink()
    {
        driver.get().findElement(ProductLink).click();
        return  new  ProductsPage (driver);
    }
    public  Homepage navigateToHomePage()
    {
        driver.browserAction().navigateToURL("https://automationexercise.com/");
        return this;
    }
    public Homepage checkThatUserIsNavigatedToHomePage()
    {
        Assert.assertTrue(driver.browserAction().getCurrentURL().contentEquals("https://automationexercise.com/"));
        return this; }
}
