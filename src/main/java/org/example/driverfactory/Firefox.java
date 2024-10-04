package org.example.driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox implements DriverInterface {
    @Override
    public WebDriver startdriver() {
       return new FirefoxDriver();
    }
}
