package pages;

import org.example.driverfactory.Driver;
import org.example.elementactions.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Contactus {
    public Driver driver;
    public Contactus(Driver driver) {
        this.driver = driver;
    }

    By title =By.xpath("(//h2[@class=\"title text-center\"])[2]");
    By name= By.xpath("//input[@data-qa=\"name\"]");
    By email= By.xpath("//input[@data-qa=\"email\"]");
    By subject = By.xpath("//input[@data-qa=\"subject\"]");
    By message= By.id("message");
    By submit = By.xpath("//input[@data-qa=\"submit-button\"]");
    By successmessage= By.cssSelector("div.status.alert.alert-success");
    By homebutton= By.cssSelector("a.btn.btn-success");



    //------METHODS-----\\

    public Contactus checkthatcontactuspageisloadedsuccessfully(){
        Assert.assertTrue(driver.get().getCurrentUrl().contains("/contact_us"));
        Assert.assertEquals(driver.element().gettextof(title),"GET IN TOUCH");
        return this;
    }
    public Contactus checkthatformissubmittedsuccessfully() {
        Assert.assertEquals(driver.element().gettextof(successmessage), "GET IN TOUCH");
        return this;
    }

public Contactus datafill(String contactorname, String contactoremail, String Subject, String Message){
//        driver.findElement(name).sendKeys(contactorname);
//        driver.findElement(email).sendKeys(contactoremail);
//        driver.findElement(subject).sendKeys(Subject);
//        driver.findElement(message).sendKeys(Message);
//        driver.findElement(submit).click();
//         driver.switchTo().alert().accept();
    driver.element().fillfield(name, contactorname);
    driver.element().fillfield(email, contactoremail);
    driver.element().fillfield(subject, Subject);
    driver.element().fillfield(message, Message);
    driver.element().click(submit);
    driver.get().switchTo().alert().accept();

    return this;
}
public Contactus successContact(){
      driver.element().click(homebutton);
        return new Contactus(driver);
}


}
