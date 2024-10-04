package org.example.utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ScreenShotManager {
    static String screenshotDirectorypath = "./screenshots";

    File screenshotDirectory = new File(screenshotDirectorypath);
    public static void captureScreenShot(WebDriver driver, String screenshotname) {
        Path destination= Paths.get(screenshotDirectorypath, screenshotname + "jpg");
        byte[] byteArray = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        try {
            Files.write(destination, byteArray, StandardOpenOption.CREATE);
        } catch (IOException e) {
            System.out.println("Unable to save Screenshot");
        }
    }
}
