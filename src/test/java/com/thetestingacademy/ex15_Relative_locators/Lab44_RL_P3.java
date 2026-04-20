package com.thetestingacademy.ex15_Relative_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static com.thetestingacademy.ex07_WaitHelper.WaitHelpers.waitJVM;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Lab44_RL_P3 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.aqi.in/world-most-polluted-cities");


        WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search']"));
        search.sendKeys("India" + Keys.ENTER);
        waitJVM(5000);


        List<WebElement> cities = driver.findElements(By.xpath("//div[contains(@class,'location-name')]/p"));

        for(WebElement element : cities)
        {
            String rank = driver.findElement(with(By.tagName("p")).toLeftOf(element)).getText();
            System.out.println("Rank ->" + rank + " " + "City ->" + element.getText());
        }




    }



}
