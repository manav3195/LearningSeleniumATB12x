package com.thetestingacademy.ex15_Relative_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Lab43_RL_P2 {

    @Test
    public void test_relativeLocator()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://codepen.io/AbdullahSajjad/full/LYGVRgK");

        driver.switchTo().frame("result");
        WebElement button = driver.findElement(By.xpath("//button[text()='Submit']"));
        button.click();

        WebElement username = driver.findElement(By.id("username"));
        WebElement error = driver.findElement(with(By.tagName("small")).below(username));
        String error_msg = error.getText();
        Assert.assertEquals(error_msg,"Username must be at least 3 characters");


    }




}
