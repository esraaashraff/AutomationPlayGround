package pages;

import org.example.driverfactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Testcases {
    public Driver driver;

    By homepageAppearence= By.xpath("//header[@id=\"header\"]");
    By testcasesButton = By.xpath("(//a[@href=\"/test_cases\"])[1]");
    By TestcasesAppearence= By.cssSelector("div.col-sm-9.col-sm-offset-1");

    public Testcases(Driver driver) {
        this.driver=driver;
    }

    public void CheckthatHomePageAppeared(){
        Assert.assertTrue(driver.get().findElement(homepageAppearence).isDisplayed());
    }
    public void ClickonTestCasesButton(){
        driver.element().click(testcasesButton);
    }
    public void checkthatTestCasesPageOpened(){
        Assert.assertTrue(driver.get().findElement(TestcasesAppearence).isDisplayed());
    }
}
