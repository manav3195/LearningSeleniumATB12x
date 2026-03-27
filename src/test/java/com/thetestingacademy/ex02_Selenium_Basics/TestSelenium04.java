package com.thetestingacademy.ex02_Selenium_Basics;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestSelenium04 {

    public static void main(String args[])
    {
        // Webdriver hierarchy
        // SearchContext(I) -> (2) -> WebDriver(I)( 10) -> RemoteWebDriver(C) (15)
        //        //// -> ChromiumDriver(C) 25 -> EdgeDriver(C) (45)


        // SearchContext - Interface - findElement, and findElements - GGF
        // WebDriver - Interface - some incomplete functions - GF
        // RemoteWebDriver - Class- It also has some functions - F
        // ChromeDriver, FirefoxDriver, EdgeDriver, SafariDriver, InternetExplorerDriver  Class - S

       // SearchContext driver = new FirefoxDriver();
       // SearchContext driver1 = new EdgeDriver();
       // SearchContext driver2 = new InternetExplorerDriver();

        // 1- Do you want to run specifically on chrome or edge
        ChromeDriver driver = new ChromeDriver();

        //2- If you want to change browser also
        WebDriver driver1 = new FirefoxDriver();
        driver1 = new ChromeDriver();
        driver1 = new EdgeDriver();

        // 3. Do you want to run on multiple browsers, aws machine? 2%
        // RemoteWebDriver driver (with GRID) - Advance (Last 2 Sessions)





    }


}
