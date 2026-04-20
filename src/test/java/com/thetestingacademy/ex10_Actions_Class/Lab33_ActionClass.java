package com.thetestingacademy.ex10_Actions_Class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class Lab33_ActionClass {

    public static void main(String args[])
    {
        String url = "https://www.spicejet.com/";
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        WebElement source = driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']/div/div/input"));

        WebElement dest = driver.findElement(By.xpath("//div[@data-testid='to-testID-destination']/div/div/input"));

        Actions actions = new Actions(driver);
        actions.moveToElement(source).click().sendKeys("DEL").moveToElement(dest).sendKeys("IXC")
                .build().perform();

    }


}
