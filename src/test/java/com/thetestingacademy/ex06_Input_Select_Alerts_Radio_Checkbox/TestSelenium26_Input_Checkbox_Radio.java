package com.thetestingacademy.ex06_Input_Select_Alerts_Radio_Checkbox;

import com.thetestingacademy.CommonToAll;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestSelenium26_Input_Checkbox_Radio extends CommonToAll {

    @Description("This is Description")
    @Test
    public void test_HtmlTags()
    {
        WebDriver driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/practice.html");

        WebElement input_firstname = driver.findElement(By.xpath("//input[@name='firstname']"));
        input_firstname.sendKeys("the testing academy");

        WebElement radio_button = driver.findElement(By.id("sex-0"));
        radio_button.click();

        WebElement checkbox_select = driver.findElement(By.id("tool-1"));
        checkbox_select.click();


    }





}
