package com.thetestingacademy.ex02_Selenium_Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSelenium14_Close_VS_quit {

    public static void main(String args[])
    {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //driver.close();
        //it will close the current tab, not the session
        //session id != null

        driver.quit();
        //it will close all the tabs.
        //session id == null


    }


}
