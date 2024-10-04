package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Duckduck {
    public static void main(String[] args) {

        WebDriver driver = new EdgeDriver();
        driver.navigate().to("https://start.duckduckgo.com/");
        driver.findElement(By.id("searchbox_input")).sendKeys("panda");
        driver.findElement(By.xpath("//button[@aria-label=\"Search\"]")).click();
        driver.findElement(By.cssSelector("a.kFFXe30DOpq5j1hbWU1q wZ4JdaHxSAhGy1HoNVja d26Geqs1C__RaCO7MUs2")).click();
    }
}
