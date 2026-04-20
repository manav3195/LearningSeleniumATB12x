package com.thetestingacademy.ex08_SVG_Elements;

import com.thetestingacademy.CommonToAll;
import com.thetestingacademy.ex07_WaitHelper.WaitHelpers;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import java.util.List;


public class Lab30_SVG extends CommonToAll {

    @Description("Verify that on search svg icon results are visibile")
    @Owner("Manav Chaudhary")
    @Test
    public void test_flipkart()
    {
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        String URL = "https://www.flipkart.com/search";
        driver.get(URL);

        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("macmini");

        WebElement search_button = driver.findElement(By.xpath("//*[name()='svg']"));
        search_button.click();

        WaitHelpers waitHelpers = new WaitHelpers();
        waitHelpers.checkVisibility(driver,By.xpath("//div[contains(@data-id,'CPU')]/div/a[2]"));

        List<WebElement> titleResults = driver.findElements(By.xpath("//div[contains(@data-id,'CPU') or contains(@data-id,'MPC') or contains(@data-id,'COM')]/div/a[2]"));

        for(WebElement title: titleResults)
        {
            System.out.println(title.getText());
        }

        System.out.println("Clicking on 2");
        WebElement next_page = driver.findElement(By.xpath("//a[normalize-space()='2']"));
        next_page.click();
        waitHelpers.waitJVM(4);
        waitHelpers.checkVisibility(driver,By.xpath("//div[contains(@data-id,'MPC')]/div/a[2]"));

        List<WebElement> titleResults2 = driver.findElements(By.xpath("//div[contains(@data-id,'MPC')]/div/a[2]"));

        for(WebElement title1 :titleResults2) {
            try {
                {
                    System.out.println(title1.getText());
                }
            } catch (StaleElementReferenceException e) {
                System.out.println("Retrying");
            }
        }

        closeBrowser(driver);

    }




}
