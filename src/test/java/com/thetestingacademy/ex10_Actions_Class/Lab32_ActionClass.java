package com.thetestingacademy.ex10_Actions_Class;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Lab32_ActionClass {

    @Test
    public void test_actions()
    {
        WebDriver driver;
        String url="https://awesomeqa.com/practice.html";
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        WebElement firstname = driver.findElement(By.name("firstname"));

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.SHIFT).sendKeys(firstname,"the testing academy")
                .keyUp(Keys.SHIFT).build().perform();

    }



}
