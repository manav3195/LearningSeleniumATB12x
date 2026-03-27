package com.thetestingacademy.ex05_Selenium_Waits;

import com.thetestingacademy.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.function.Function;

public class TestSelenium25_Fluent_Wait extends CommonToAll {

    public static void main(String args[])
    {
        FirefoxOptions edgeOptions = new FirefoxOptions();
        edgeOptions.addArguments("--incognito");
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new FirefoxDriver(edgeOptions);
        driver.navigate().to("https://app.vwo.com");

        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");

        WebElement input_email = driver.findElement(By.id("login-username"));
        input_email.sendKeys("admin@admin.com");

        WebElement input_password = driver.findElement(By.id("login-password"));
        input_password.sendKeys("password@321");

        WebElement button_signIn = driver.findElement(By.xpath("//button[@id='js-login-btn']"));
        button_signIn.click();

        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);

        Boolean isTextLoaded = wait.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return driver.findElement(By.className("notification-box-description")).getText().trim().length()>0;
            }
        });

        WebElement error_msg = driver.findElement(By.className("notification-box-description"));

        System.out.println(error_msg.getText());
        Assert.assertEquals(error_msg.getText(),"Your email, password, IP address or location did not match");


    }
}
