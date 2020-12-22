package com.Interview.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class StoreLocator {
    public  static  WebDriver driver=null;
    //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    @Given("^I am on Home page$")
    public void i_am_on_Home_page() throws Throwable {
        WebDriverManager.chromedriver().setup();
         driver=new ChromeDriver();
        driver.get("https://tuclothing.sainsburys.co.uk/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("consent_prompt_submit")).click();
        driver.manage().window().maximize();
    }

    @When("^I click Tu store locator link$")
    public void i_click_Tu_store_locator_link() throws Throwable {
            //driver.findElement(By.cssSelector(".nav a[href^=\"/store-finder\"]")).click();
            driver.findElement(By.cssSelector("a[href^='/store-finder']")).click();
            System.out.println("when step definition");
        }


    @When("^enter post code$")
    public void enter_post_code()
    {
        //driver.findElement(By.cssSelector(".nav a[href^='/store-finder']")).click();
        driver.findElement(By.name("q")).sendKeys("MK11 3ER");
    }

    @When("^select checkbox for only show stores that stock clothing and tick checkbox womens$")
    public void select_checkbox_for_only_show_stores_that_stock_clothing_and_tick_checkbox_womens() throws Throwable {
        System.out.println("clothing wo,en");

    }

    @Then("^it should display store that stock clothing$")
    public void it_should_display_store_that_stock_clothing() throws Throwable {
        System.out.println("stock");

    }

}
