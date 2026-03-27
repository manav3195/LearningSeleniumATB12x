package com.thetestingacademy.ex02_Selenium_Basics;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestSelenium15_OptionClasses {

    public static void main(String agrs[])
    {
        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--incognito");

        ChromeDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://sdet.live");

        System.out.println(driver.getTitle());
        driver.quit();


    }
}
