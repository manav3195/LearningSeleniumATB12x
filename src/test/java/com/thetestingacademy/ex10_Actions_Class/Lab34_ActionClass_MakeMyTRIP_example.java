package com.thetestingacademy.ex10_Actions_Class;

import com.thetestingacademy.ex07_WaitHelper.WaitHelpers;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.lang.reflect.Executable;
import java.time.Duration;
import java.util.List;

public class Lab34_ActionClass_MakeMyTRIP_example {

    @Description("verify test on makemytrip.com")
    @Owner("Manav Chaudhary")
    @Test
    public void test_makeMyTrip()
    {
        WebDriver driver;
        driver = new FirefoxDriver();
        String url ="https://www.makemytrip.com/";
        driver.get(url);
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-cy='closeModal']")));

        WebElement close = driver.findElement(By.xpath("//span[@data-cy='closeModal']"));
        close.click();
        new WaitHelpers().waitJVM(5000);

        WebElement fromCity = driver.findElement(By.xpath("//input[@data-cy='fromCity']"));

        WebElement toCity = driver.findElement(By.xpath("//input[@data-cy='toCity']"));
        Actions actions = new Actions(driver);

        actions.moveToElement(fromCity).click().build().perform();
       WebElement input_from = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='From']")));
        input_from.sendKeys("IXC");

        System.out.println("Moving to try code");
        try {
            List<WebElement> list_auto_complete = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li")));

            for(WebElement e: list_auto_complete)
            {
                if (e.getText().contains("Chandigarh"))
                {
                    e.click();
                }
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }


    }



}
