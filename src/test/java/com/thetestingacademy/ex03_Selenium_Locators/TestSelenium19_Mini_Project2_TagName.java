package com.thetestingacademy.ex03_Selenium_Locators;

import com.thetestingacademy.CommonToAll;
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

public class TestSelenium19_Mini_Project2_TagName extends CommonToAll {

    @Description("Verify error message in free trial")
    @Owner("Manav Chaudhary")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void test_vwo_free_trial()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        openBrowser(driver,"https://app.vwo.com/");

        WebElement a_tag_partial_match = driver.findElement(By.partialLinkText("TRIAL"));
        a_tag_partial_match.click();


        /*
        System.out.println("Running-test");
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("free-trial"));
         */

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement email_free_trial = driver.findElement(By.id("page-v1-step1-email"));
        email_free_trial.sendKeys("abc");

        WebElement checkbox_free_trial = driver.findElement(By.name("gdpr_consent_checkbox"));
        checkbox_free_trial.click();

        WebElement button_free_trial = driver.findElement(By.tagName("button"));
        button_free_trial.click();

        WebElement error_msg_free_trial = driver.findElement(By.className("invalid-reason"));
        Assert.assertEquals(error_msg_free_trial.getText(),"The email address you entered is incorrect.");

        closeBrowser(driver);

    }


}
