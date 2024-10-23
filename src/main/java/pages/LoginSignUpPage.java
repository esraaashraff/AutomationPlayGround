package pages;

import org.example.driverfactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginSignUpPage {

public Driver driver;
By loginEmail= By.xpath("(//input[@name=\"email\"])[1]");
By loginPassword = By.xpath("//input[@data-qa=\"login-password\"]");
By loginButton = By.xpath("//button[@data-qa=\"login-button\"]");
By SignUPName = By.name("name");
By SignUPEmail= By.xpath("//input[@data-qa=\"signup-email\"]");
By SignUPButton = By.xpath("//button[@data-qa=\"signup-button\"]");



//----------------------METHODS-----------------------//

public LoginSignUpPage(Driver driver){

    this.driver=driver;
}

public LoginSignUpPage fillinloginEmail(String email){
    driver.element().fillfield(loginEmail, email);
    return this;
}

    public LoginSignUpPage fillinloginPassword(String password) {
        driver.element().fillfield(loginPassword,password);
        return this;
    }

    public Homepage clickonloginButton() {
        driver.element().click(loginButton);
        return new Homepage(driver);
    }

    public LoginSignUpPage fillinSignUPName(String Name){
        driver.element().fillfield(SignUPName , Name);
        return this;
    }

    public LoginSignUpPage fillinSignUPEmail(String email) {
        driver.element().fillfield(SignUPEmail, email);
        return this;
    }

    public RegisterPage clickonSignUPButton() {
        driver.element().click(SignUPButton);
        return new RegisterPage(driver);
    }
}
