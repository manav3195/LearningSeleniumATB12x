package com.thetestingacademy.ex12_Windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class Lab38_Windows_Part1 {

    @Test
    public void test_window()
    {
        String URL = "https://the-internet.herokuapp.com/windows";
        WebDriver driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();

        String parent_id = driver.getWindowHandle();
        System.out.println(parent_id);

        WebElement link = driver.findElement(By.xpath("//a[text()='Click Here']"));
        link.click();

        //2 Windows
        Set<String> window_handles_ids = driver.getWindowHandles();
        System.out.println(window_handles_ids);

        for(String window : window_handles_ids)
        {
            driver.switchTo().window(window);
            if(driver.getPageSource().contains("New Window"))
            {
                System.out.println("Test passed");
            }

        }

        driver.switchTo().window(parent_id);


    }



}
