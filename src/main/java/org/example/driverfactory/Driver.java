package org.example.driverfactory;

import org.example.browserActions.BrowserActions;
import org.example.elementactions.ElementActions;
import org.example.listners.webdriver.WebDriverListeners;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

public class Driver {
   // WebDriver driver;
   private ThreadLocal<WebDriver> driver;

   /* public Driver(String driverType) {
        WebDriver undecoratedDriver = getDriver(driverType).startdriver();
        assert undecoratedDriver != null;

       driver = new ThreadLocal<>();
        driver.set(new EventFiringDecorator<>(org.openqa.selenium.WebDriver.class,
                new WebDriverListeners(undecoratedDriver))
                .decorate(undecoratedDriver));
    } */
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
        return driver.get();
    }
    public void quit() {
        driver.get().quit();
        driver.remove();
    }

    public ElementActions element() {
        return new ElementActions(driver.get());
    }

    public BrowserActions browser() {
        return new BrowserActions(driver.get());
    }
}
