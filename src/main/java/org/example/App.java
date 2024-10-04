package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App 
{
    public static void main( String[] args ) {
WebDriver driver= new ChromeDriver();

        driver.navigate().to("https://automationexercise.com/login");
        driver.findElement(By.name("name")).sendKeys("Esraa");
        driver.findElement(By.xpath("(//input[@name=\"email\"])[2]")).sendKeys("teast404@gmail.com");
        driver.findElement(By.xpath("//button[@data-qa=\"signup-button\"]")).click();
        driver.findElement(By.id("password")).sendKeys("esraa2024");
        driver.findElement(By.id("first_name")).sendKeys("Esraa");
        driver.findElement(By.id("last_name")).sendKeys("Esraa");
        driver.findElement(By.id("address1")).sendKeys("Alex");
        driver.findElement(By.id("state")).sendKeys("Alex");
        driver.findElement(By.id("city")).sendKeys("Alex");
        driver.findElement(By.id("zipcode")).sendKeys("555412");
        driver.findElement(By.id("mobile_number")).sendKeys("012215438");

        WebElement dropdown = driver.findElement(By.xpath("//select[@data-qa=\"country\"]"));
       /* Select select =new Select(dropdown);
        select.selectByValue("Canada");

        */
        driver.findElement(By.xpath("//option[@value=\"United States\"]")).click();
        driver.findElement(By.xpath("//button[@data-qa=\"create-account\"]")).click();

        driver.quit();
    }

}
