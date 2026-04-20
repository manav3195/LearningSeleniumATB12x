package com.thetestingacademy.ex10_Actions_Class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.sql.Driver;

public class Lab36_ActionClass_Drag_Drop {

    public static void main(String args[])
    {
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        WebElement from = driver.findElement(By.id("column-a"));
        WebElement to = driver.findElement(By.id("column-b"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(from,to).build().perform();


    }



}
