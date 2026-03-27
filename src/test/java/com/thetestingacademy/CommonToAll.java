package com.thetestingacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class CommonToAll {

    public FirefoxDriver driver;

    public void openBrowser(WebDriver driver, String url)
    {
        driver.get(url);
    }

    public void closeBrowser(WebDriver driver)
    {
        driver.quit();
    }

    public void waitForVisibility(WebDriver driver, int timeInSeconds, String xpath)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public static void waitFluentVisibility(WebDriver driver, int maxTime, int pollingTime, String xpath)
    {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(maxTime))
                .pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class);

        WebElement msg = wait.until(new Function<WebDriver,WebElement>(){

         public WebElement apply(WebDriver driver)
         {
            return driver.findElement(By.xpath(xpath));
         }
        });


    }

}
