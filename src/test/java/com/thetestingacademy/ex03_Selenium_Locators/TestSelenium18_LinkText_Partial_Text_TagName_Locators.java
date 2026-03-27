package com.thetestingacademy.ex03_Selenium_Locators;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestSelenium18_LinkText_Partial_Text_TagName_Locators {

    @Description("TC#2 - verify vwo login")
    @Owner("Manav Chaudhary")
    @Test
    public void test_vwo_login()
    {
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com/#/login");

        WebElement a_tag_partial_match = driver.findElement(By.partialLinkText("TRIAL"));
        a_tag_partial_match.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }


}
