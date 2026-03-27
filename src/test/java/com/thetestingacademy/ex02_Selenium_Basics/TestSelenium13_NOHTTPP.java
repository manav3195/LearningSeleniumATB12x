package com.thetestingacademy.ex02_Selenium_Basics;

import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileReader;

public class TestSelenium13_NOHTTPP {

    public static void main(String args[])
    {
        FirefoxDriver driver = new FirefoxDriver();
       // driver.get("bing.com");
        driver.get("https://bing.com");


    }
}
