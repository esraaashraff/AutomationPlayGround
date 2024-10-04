package pages;

import org.example.driverfactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginSignUpPage {
//public WebDriver driver;
public WebDriver driver;
By loginEmail= By.xpath("(//input[@name=\"email\"])[1]");
By loginPassword = By.xpath("//input[@data-qa=\"login-password\"]");
By loginButton = By.xpath("//button[@data-qa=\"login-button\"]");
By SignUPName = By.name("name");
By SignUPEmail= By.xpath("//input[@data-qa=\"signup-email\"]");
By SignUPButton = By.xpath("//button[@data-qa=\"signup-button\"]");



//----------------------METHODS-----------------------//

public LoginSignUpPage(WebDriver driver){

    this.driver=driver;
}

public LoginSignUpPage fillinloginEmail(String email){
    driver.findElement(loginEmail).sendKeys(email);
    return this;
}

    public LoginSignUpPage fillinloginPassword(String password) {
        driver.findElement(loginPassword).sendKeys(password);
        return this;
    }

    public Homepage clickonloginButton() {
        driver.findElement(loginButton).click();
        return new Homepage(driver);
    }

    public LoginSignUpPage fillinSignUPName(String Name){
        driver.findElement(SignUPName).sendKeys(Name);
        return this;
    }

    public LoginSignUpPage fillinSignUPEmail(String email) {
        driver.findElement(SignUPEmail).sendKeys(email);
        return this;
    }

    public RegisterPage clickonSignUPButton() {
        driver.findElement(SignUPButton).click();
        return new RegisterPage(driver);
    }
}
