package org.example.driverfactory;

import org.example.browserActions.BrowserActions;
import org.example.elementactions.ElementActions;
import org.example.listners.webdriver.WebDriverListeners;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

public class Driver {
   public WebDriver driver;
    public Driver (String driverType){
        driver= getDriver(driverType).startdriver();
    }

    public static DriverInterface getDriver(String browsertype) {

        switch (browsertype) {
            case "Chrome": {
                return new Chrome();
            }
            case "Firefox": {
                return new Firefox();
            }
            case "Edge": {
                return new Edge();
            }
            default: {
                throw new IllegalStateException("Unexpected value: " + browsertype);
            }
        }
    }
    public WebDriver get() {
        return driver;
    }
    public void quit() {
        driver.quit();
    }

    public ElementActions element() {
        return new ElementActions(driver);
    }

    public BrowserActions browserAction() {
        return new BrowserActions(driver);
    }
}
