package com.thetestingacademy.ex14_JS_ShadowDOM;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Lab41_JS_Code_ShadowDOM {


    @Test
    public void test_shadowDom()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://selectorshub.com/xpath-practice-page/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement inputPizza= (WebElement) js.executeScript(" return document.querySelector('div#userName').shadowRoot.querySelector('div#app2').shadowRoot.querySelector('input#pizza');");
        inputPizza.sendKeys("farmhouse");

    }
}
