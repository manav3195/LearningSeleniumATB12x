package com.thetestingacademy.ex01_Selenium_Basics;

import io.qameta.allure.Description;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium02 {

    @Test
    @Description("Open app.vwo.com and verify the current URL")
    public void test_Selenium02()
    {
        FirefoxDriver driver = new FirefoxDriver();
        // new EdgeDriver(); -> POST Request(Browser Driver) (localhost:XXXXX),
        // Create New Session Endpoint - 16 digit Unique ID is also created.
        driver.get("https://app.vwo.com/#/login");
        System.out.println(driver.getCurrentUrl());

        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");
        driver.quit();


    }



}
