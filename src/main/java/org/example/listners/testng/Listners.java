package org.example.listners.testng;

import org.example.driverfactory.Driver;
import org.example.utilities.ScreenShotManager;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listners implements ITestListener {

    @Override
    public void onTestStart(ITestResult result){
        System.out.println("******* Start of test"+ result.getName()+"*********");
    }

    @Override
    public void onTestSuccess(ITestResult result){
        System.out.println("******* Success of test"+ result.getName()+"*********");
    }

    @Override
    public void onTestFailure(ITestResult result){
        System.out.println("******* Fail of test"+ result.getName()+"*********");
        System.out.println("Taking Sceenshot...");
        //ScreenShotManager.captureScreenShot(driver, result.getName());
    }

}
