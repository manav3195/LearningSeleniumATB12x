package com.thetestingacademy.ex12_Windows;

import com.thetestingacademy.CommonToAll;
import com.thetestingacademy.ex07_WaitHelper.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class TestProjectInterview extends CommonToAll {


    @Test
    public void test_interview_vwo_project()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://app.vwo.com/#/login");
        WebElement email = driver.findElement(By.id("login-username"));
        email.sendKeys("test3@dev.nondon.store");
        WebElement password = driver.findElement(By.id("login-password"));
        password.sendKeys("Test3@4321");
        WebElement signIn = driver.findElement(By.id("js-login-btn"));
        signIn.click();

        new WaitHelpers().waitJVM(5000);
        driver.get("https://app.vwo.com/#/analyze/heatmap?accountId=1220012");

        new WaitHelpers().waitJVM(2000);

        waitForVisibility(driver,5,"//button[text()='Skip']");
        WebElement skip_button = driver.findElement(By.xpath("//button[text()='Skip']"));
        skip_button.click();

        new WaitHelpers().waitJVM(2000);
        String parentHandle = driver.getWindowHandle();
        System.out.println(parentHandle);
        WebElement url = driver.findElement(By.name("primaryUrl"));
        url.clear();
        url.sendKeys("https://thetestingacademy.com");
        WebElement button = driver.findElement(By.xpath("//button[text()=' View Heatmap ']"));
        button.click();

        new WaitHelpers().waitJVM(10000);
        Set<String> allHandles = driver.getWindowHandles();
        System.out.println(allHandles);
        System.out.println("Inside loop");

        for (String handle : allHandles)
        {
            if(!handle.equals(parentHandle))
            {
                driver.switchTo().window(handle);
                WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
                new WaitHelpers().waitJVM(2000);
                System.out.println("print");
                System.out.println(driver.getPageSource().contains("vwo-heatmap-journey"));

                /*
                WebElement shadowHost = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("vwo-heatmap-journey-component#vwo-heatmap-journey")
                ));


                JavascriptExecutor js = (JavascriptExecutor) driver;
                WebElement skipIframe = (WebElement) js.executeScript("return document.querySelector('vwo-heatmap-journey-component#vwo-heatmap-journey').shadowRoot.querySelector('.guide-skip-button');");
                skipIframe.click();

                 */

                JavascriptExecutor js = (JavascriptExecutor) driver;

                wait.until(driver1 ->
                        (Boolean) js.executeScript(
                                "let host = document.querySelector('vwo-heatmap-journey-component#vwo-heatmap-journey');" +
                                        "if (!host || !host.shadowRoot) return false;" +

                                        "let btn = host.shadowRoot.querySelector('.guide-skip-button');" +
                                        "if (!btn) return false;" +

                                        "btn.click();" +
                                        "return true;"
                        )
                );



                driver.switchTo().frame("heatmap-iframe");
                WebElement compare = driver.findElement(By.xpath("//div[@id='compare-heatmap-open-modal']"));
                Actions actions = new Actions(driver);
                actions.moveToElement(compare).click().build().perform();
                System.out.println("button clicked");

            }
        }






    }



}
