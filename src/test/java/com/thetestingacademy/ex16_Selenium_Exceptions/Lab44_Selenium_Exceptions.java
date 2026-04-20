package com.thetestingacademy.ex16_Selenium_Exceptions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Lab44_Selenium_Exceptions {

    @Test
    public void test_selenium_exceptions()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://app.vwo.com/#/login");

        driver.findElement(By.id("pramod"));

    }

}
