package pages;

import org.example.driverfactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {
   // public WebDriver driver;
        WebDriver driver;

//By pagetitle= By
 By password= By.id("password");
 By firstName= By.id("first_name");
 By lastName= By.id("last_name");
 By Address= By.id("address1");
 By state= By.id("state");
 By city= By.id("city");
 By zipcode= By.id("zipcode");
 By mobileNumber= By.id("mobile_number");
 By country= By.xpath("//select[@data-qa=\"country\"]");
 By option= By.xpath("//option[@value=\"United States\"]");


 By createButton = By.xpath("//button[@data-qa=\"create-account\"]");

 /////Methods///

public RegisterPage(WebDriver driver){
    this.driver=driver;
}

public RegisterPage enterpassword( String pass){
    driver.findElement(password).sendKeys(pass);
    return this;
}

    public RegisterPage enterfirstname( String fname){
        driver.findElement(firstName).sendKeys(fname);
        return this;
    }

    public RegisterPage enterlastname( String lname){
        driver.findElement(lastName).sendKeys(lname);
        return this;
    }

    public RegisterPage enteraddress( String add){
        driver.findElement(Address).sendKeys(add);
        return this;
    }

    public RegisterPage enterstate( String stat){
        driver.findElement(state).sendKeys(stat);
        return this;
    }

    public RegisterPage entercity( String cit){
        driver.findElement(city).sendKeys(cit);
        return this;
}


    public RegisterPage enterzipcode( String zip){
        driver.findElement(zipcode).sendKeys(zip);
        return this;
    }

    public RegisterPage entermobileno( String mobno){
        driver.findElement(mobileNumber).sendKeys(mobno);
        return this;
    }

    public RegisterPage entercountry(){
        driver.findElement(country).click();
        Select select= new Select(driver.findElement(country));
        select.selectByValue("Canada");
        return this;
    }

    public RegisterPage chooseoption(String op){
        driver.findElement(option).sendKeys(op);
        return this;
    }

    public AccountSuccess clickoncreateButton(){
        driver.findElement(createButton).click();
        return new AccountSuccess(driver);
    }
}
