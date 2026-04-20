package com.thetestingacademy.ex11_File_Upload;

import com.thetestingacademy.ex07_WaitHelper.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Lab38_FileUpload_BS {

    public static void main(String[] args) {

        WebDriver driver;
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.browserstack.com/users/sign_in");

        WebElement email = driver.findElement(By.id("user_email_login"));
        email.sendKeys("ccauuvuz@bscse.okcx.edu.rs");

        new WaitHelpers().waitJVM(2000);

        WebElement pass = driver.findElement(By.id("user_password"));
        pass.sendKeys("ccauuvuz@bscse.okcx.edu.rs");

        new WaitHelpers().waitJVM(2000);

        WebElement submit = driver.findElement(By.id("user_submit"));
        submit.click();

        new WaitHelpers().waitJVM(5000);
        driver.get("https://app-automate.browserstack.com/utilities/app_management");
        new WaitHelpers().waitJVM(2000);

        WebElement fileUpload = driver.findElement(By.id("file-upload"));
        String user_dir = System.getProperty("user.dir");
        String path =user_dir + "\\src\\test\\java\\com\\thetestingacademy\\ex11_File_Upload\\testdroid-sample-app.apk";
        fileUpload.sendKeys(path);
    }

}
