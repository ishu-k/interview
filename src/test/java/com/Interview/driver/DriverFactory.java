package com.Interview.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
    public static WebDriver driver;
    private String browser=" ";

    public void openBrowser() {
        switch (browser) {
            case "ie":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
        }
    }


    public void navigateTo(String url){
        driver.get(url);
    }

    public void maxiBrowser(){
        driver.manage().window().maximize();
    }


    public void closeBrowser(){
        driver.quit();
    }
    public int implicitWait(int wait)
    {
        driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
        return wait;
    }
}

    

