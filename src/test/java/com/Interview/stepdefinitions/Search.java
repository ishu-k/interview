package com.Interview.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.apache.commons.lang3.StringUtils.containsAny;
import static org.apache.commons.lang3.StringUtils.equalsIgnoreCase;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class Search {
   WebDriver driver;
    @Given("^Im on home page$")
    public void im_on_home_page() throws Throwable {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://tuclothing.sainsburys.co.uk/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("consent_prompt_submit")).click();
        driver.manage().window().maximize();
    }

    @When("^I search for a prodcut$")
    public void i_search_for_a_prodcut() throws Throwable {
        WebElement element= driver.findElement(By.id("search"));
        element.sendKeys("jumper");
        element.sendKeys(Keys.ENTER);

    }

    @Then("^I should see the desired product$")
    public void i_should_see_the_desired_product() throws Throwable {
       String actual= driver.getTitle();
        System.out.println(actual);
       String expected ="jumper";
       Assert.assertThat(actual,containsString(expected));
       //Assert.assertThat(containString("jumper"),actual);
    }

    @Then("^i should see the error$")
    public void i_should_see_the_error() throws Throwable {
        String expected ="Sorry, no results for 'alltainability'" ;
        String actual=
                driver.findElement(By.xpath("//h1[contains(text(),\"Sorry, no results for 'alltainability'\")]")).getText();
        System.out.println(expected);
        Assert.assertThat(actual,containsString(expected));

    }

    @When("^I search for a invalid productid$")
    public void iSearchForAInvalidProductid() {
        WebElement element= driver.findElement(By.id("search"));
        element.sendKeys("alltainability");
        element.sendKeys(Keys.ENTER);
        
    }
    @When("^I search with no data$")
    public void i_search_with_no_data() throws Throwable {
        WebElement element= driver.findElement(By.id("search"));
        element.sendKeys("  ");
        element.sendKeys(Keys.ENTER);
    }

    @Then("^I should see the desired error$")
    public void i_should_see_the_desired_error() throws Throwable {
        String expected ="Sorry, no results for ''{0}''";
        String actual=driver.findElement(By.xpath("//h1[contains(text(),\"Sorry, no results for ''{0}''\")]")).getText();
        System.out.println(actual);
        Assert.assertThat(actual,containsString(expected));


    }

}
