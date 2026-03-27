package com.thetestingacademy.ex03_Selenium_Locators;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium17_Project_Locators_Selenium_ID_CLASSNAME_NAME {

    @Description("TC#1 - Verify vwo with invalid login, error message is getting displayed")
    @Owner("Manav Chaudhary")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void test_vwo_invalid_login()
    {
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com/#/login");

        WebElement email_input_box = driver.findElement(By.id("login-username"));
        email_input_box.sendKeys("admin@admin.com");

        WebElement password_input_box = driver.findElement(By.name("password"));
        password_input_box.sendKeys("admin");

        WebElement submit_button = driver.findElement(By.id("js-login-btn"));
        submit_button.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement error_msg = driver.findElement(By.className("notification-box-description"));
        System.out.println(error_msg.getText());

        Assert.assertEquals(error_msg.getText(),"Your email, password, IP address or location did not match");

    }



}
