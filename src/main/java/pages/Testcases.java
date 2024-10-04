package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Testcases {
    public WebDriver driver;

    By homepageAppearence= By.xpath("//header[@id=\"header\"]");
    By testcasesButton = By.xpath("(//a[@href=\"/test_cases\"])[1]");
    By TestcasesAppearence= By.cssSelector("div.col-sm-9.col-sm-offset-1");

    public Testcases(WebDriver driver) {
        this.driver=driver;
    }

    public void CheckthatHomePageAppeared(){
        Assert.assertTrue(driver.findElement(homepageAppearence).isDisplayed());
    }
    public void ClickonTestCasesButton(){
        driver.findElement(testcasesButton).click();
    }
    public void checkthatTestCasesPageOpened(){
        Assert.assertTrue(driver.findElement(TestcasesAppearence).isDisplayed());
    }
}
