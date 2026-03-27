package com.thetestingacademy.ex02_Selenium_Basics;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestSelenium09_Assertion_TestNG {

    @Test
    @Description("Open the URL")
    public void test_Selenium01()
    {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com");

        //TestNG
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.google.com/");
        //AssertJ
        assertThat(driver.getCurrentUrl()).isNotNull().isNotBlank().isEqualTo("https://www.google.com/");
        driver.quit();


    }

}
