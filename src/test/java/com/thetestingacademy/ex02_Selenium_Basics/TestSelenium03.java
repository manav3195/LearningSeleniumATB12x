package com.thetestingacademy.ex02_Selenium_Basics;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestSelenium03 {

    @Test
    public void test_Selenium01()
    {
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com");
        //In case of selenium4, webdriver path is not required.
        //In case of selenium3 , we need to give the path of webdriver
       // System.getProperty("webdriver.gecko.driver","//path/geckodriver");


    }



}
