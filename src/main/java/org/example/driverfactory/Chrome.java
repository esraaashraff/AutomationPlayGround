package org.example.driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome implements DriverInterface {
    @Override
    public WebDriver startdriver() {
        return new ChromeDriver();
    }
}

