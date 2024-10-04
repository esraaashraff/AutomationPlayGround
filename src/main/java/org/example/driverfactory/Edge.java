package org.example.driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Edge implements DriverInterface {

    @Override
    public WebDriver startdriver() {
        return new EdgeDriver();
    }
}
