package com.thetestingacademy.ex16_Selenium_Exceptions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Lab45_Selenium_Exceptions {

    @Test
    public void test_exceptions_try()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://app.vwo.com/#/login");

        try{
            driver.findElement(By.id("pramod"));
        }
        catch (NoSuchElementException e)
        {
            System.out.println("Element not found");
        }



    }


}
