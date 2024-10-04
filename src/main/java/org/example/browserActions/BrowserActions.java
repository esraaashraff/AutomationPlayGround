package org.example.browserActions;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class BrowserActions {
  public WebDriver driver;
  private Actions actions;

    public BrowserActions(WebDriver driver) {
        this.driver = driver;
        this.actions= new Actions(driver);
    }

    //--------------Controlling URL------------------\\
    public BrowserActions navigateToURL(String url){
        driver.navigate().to(url);
        return this;
    }
    public BrowserActions getToURL(String url){
        driver.get(url);
        return this;
    }
    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }
    public BrowserActions navigateForward(String url){
        driver.navigate().forward();
        return this;
    }
    public BrowserActions navigateBack(String url){
        driver.navigate().back();
        return this;
    }
    public BrowserActions Refresh(String url){
        driver.navigate().refresh();
        return this;
    }
    public BrowserActions scrollToBottom(){
        actions.scrollByAmount(0, 2500).build().perform();
        return this;
    }
    public BrowserActions scrollByAmount(int width, int height){
        actions.scrollByAmount(width,height).build().perform();
        return this;
    }

    //--------------Controlling Cookies------------------\\

    public BrowserActions AddCookie(Cookie cookie){
        driver.manage().addCookie(cookie);
        return this;
    }
    public BrowserActions DeleteCookie(Cookie cookie){
        driver.manage().deleteCookie(cookie);
        return this;
    }
    public BrowserActions DeleteAllCookies(){
        driver.manage().deleteAllCookies();
        return this;
    }
    public BrowserActions DeleteCookieNamed(String name){
        driver.manage().deleteCookieNamed(name);
        return this;
    }

    //--------------Controlling Window------------------\\

}
