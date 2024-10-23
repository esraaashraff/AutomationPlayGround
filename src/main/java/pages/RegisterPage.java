package pages;

import org.example.driverfactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {

public Driver driver;

 By title = By.xpath("(//h2[@class=\"title text-center\"])[1]");
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

 ///////////////////Methods////////////////////////////

public RegisterPage(Driver driver){
    this.driver=driver;
}

public RegisterPage enterpassword( String pass){
    driver.element().fillfield(password, pass);
    return this;
}

    public RegisterPage enterfirstname( String fname){
        driver.element().fillfield(firstName , fname);
        return this;
    }

    public RegisterPage enterlastname( String lname){
        driver.element().fillfield(lastName, lname);
        return this;
    }

    public RegisterPage enteraddress( String add){
        driver.element().fillfield(Address, add);
        return this;
    }

    public RegisterPage enterstate( String stat){
        driver.element().fillfield(state,stat);
        return this;
    }

    public RegisterPage entercity( String cit){
        driver.element().fillfield(city, cit);
        return this;
}


    public RegisterPage enterzipcode( String zip){
        driver.element().fillfield(zipcode , zip);
        return this;
    }

    public RegisterPage entermobileno( String mobno){
        driver.element().fillfield(mobileNumber, mobno);
        return this;
    }

    public RegisterPage entercountry(){
        driver.element().click(country);
        Select select= new Select(driver.get().findElement(country));
        select.selectByValue("Canada");
        return this;
    }

    public RegisterPage chooseoption(String op){
        driver.element().fillfield(option, op);
        return this;
    }

    public AccountSuccess clickoncreateButton(){
        driver.element().click(createButton);
        return new AccountSuccess(driver);
    }
}
