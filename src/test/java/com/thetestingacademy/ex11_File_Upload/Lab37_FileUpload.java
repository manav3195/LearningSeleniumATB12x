package com.thetestingacademy.ex11_File_Upload;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Lab37_FileUpload {

    @Description("Verify user is able to uplaod the file")
    @Owner("Manav Chaudhary")
    @Test
    public void test_fileupload()
    {
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://awesomeqa.com/selenium/upload.html");

        WebElement fileupload = driver.findElement(By.id("fileToUpload"));
        String user_dir = System.getProperty("user.dir");
        System.out.println(user_dir);
        String path = user_dir + "\\src\\test\\java\\com\\thetestingacademy\\ex10_Actions_Class\\Test.txt";

        fileupload.sendKeys(path);
        WebElement submit_button = driver.findElement(By.name("submit"));
        submit_button.click();


    }
}
