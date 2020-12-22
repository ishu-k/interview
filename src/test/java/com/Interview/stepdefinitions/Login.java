package com.Interview.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Login {
    WebDriver driver = null;
    @Given("^I am on home page$")
        public void im_on_home_page () throws Throwable {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get("https://tuclothing.sainsburys.co.uk/");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.id("consent_prompt_submit")).click();
            driver.manage().window().maximize();
        }

        @When("^I click on Login$")
        public void i_click_on_Login () throws InterruptedException {
            Thread.sleep(3000);
            driver.findElement(By.cssSelector("a[href^='/login']")).click();

        }

        @When("^I enter valid login details$")
        public void i_enter_valid_login_details () throws Throwable {
            driver.findElement(By.cssSelector(".ln-c-input-container #j_username")).sendKeys("abc@gmail.com");
            driver.findElement(By.cssSelector(".ln-c-input-container #j_password")).sendKeys("abc1234");
        }

        @When("^I click on Login button$")
        public void i_click_on_Login_button () throws Throwable {

        }

        @Then("^I should see welcome page$")
        public void i_should_see_welcome_page () throws Throwable {

        }

        @Then("^I should see full name on top of the page$")
        public void i_should_see_full_name_on_top_of_the_page () throws Throwable {

        }


    }

