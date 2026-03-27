package com.thetestingacademy.ex04_Selenium_XPATH;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestSelenium21_MiniProject_3 {

    @Owner("Manav Chaudhary")
    @Description("verify katalon login is working")
    @Test
    public void test_katalon_login()
    {
        WebDriver driver = new ChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();

        WebElement button = driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        button.click();

       List<WebElement> input_username = driver.findElements(By.xpath("//input[@placeholder='Username']"));
       input_username.get(1).sendKeys("John Doe");

       List<WebElement> input_password = driver.findElements(By.xpath("//input[@placeholder='Password']"));
       input_password.get(1).sendKeys("ThisIsNotAPassword");

       WebElement button_login = driver.findElement(By.xpath("//button[@id='btn-login']"));
       button_login.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/#appointment");

        WebElement h2 = driver.findElement(By.xpath("//h2[text()='Make Appointment']"));
        Assert.assertEquals(h2.getText(),"Make Appointment");
        Assert.assertTrue(h2.isDisplayed());


    }



}
