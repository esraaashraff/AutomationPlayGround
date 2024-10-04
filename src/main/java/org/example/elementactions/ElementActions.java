package org.example.elementactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ElementActions {
    public WebDriver driver;
    private Actions actions;

    public ElementActions(WebDriver driver) {
        this.driver = driver;
        this.actions= new Actions(driver);
    }
    public ElementActions click(By locator) {
        System.out.println("Click On :" +locator.toString() );
        driver.findElement(locator).click();
        return this;
    }
    public ElementActions fillfield(By locator,String text){
        System.out.println("fill field :" +locator.toString() + "with" + text);
        driver.findElement(locator).sendKeys(text);
         return this; }

    public ElementActions clearfield(By locator){
        driver.findElement(locator).clear();
        return this;
    }
    public String gettextof(By locator){
        return driver.findElement(locator).getText();
    }

    public Boolean isDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed();
    }
    public ElementActions SelectByIndex(By locator,int indx){
        new Select(driver.findElement(locator)).selectByIndex(indx);
    return this;
    }
    public ElementActions SelectByValue(By locator,String value){
        new Select(driver.findElement(locator)).selectByValue(value);
        return this;
    }

    public Boolean isSelected(By locator) {
        return driver.findElement(locator).isSelected();
    }
    public Boolean isClickable(By locator){
        return driver.findElement(locator).isEnabled();
    }
    public ElementActions scrollToElemnt(By locator){
        actions.scrollToElement(driver.findElement(locator)).build().perform();
        return this;
    }
    public ElementActions hoveronAnItem(By locator){
        actions.moveToElement(driver.findElement(locator)).build().perform();
        return this;
    }
    public ElementActions ClickonAnItem(By locator){
        actions.moveToElement(driver.findElement(locator)).build().perform();
        return this; }
}
