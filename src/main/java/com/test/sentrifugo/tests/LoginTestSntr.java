package com.test.sentrifugo.tests;

import com.test.sentrifugo.pages.LoginPageSntr;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestSntr {
    //    @Test
//    public void validateSuperAdmin(){
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver=new ChromeDriver();
//        driver.get("http://demo.sentrifugo.com/index.php/");
//
//        WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
//        username.sendKeys("EM01");
//        WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
//        password.sendKeys("sentrifugo");
//        WebElement loginButton=driver.findElement(By.xpath("//input[@id='loginsubmit']"));
//        loginButton.submit();
//
//
//    }
    @Test
    public void validateSuperAdmin() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.sentrifugo.com/index.php/");
        driver.manage().window().maximize();
        LoginPageSntr loginPage = new LoginPageSntr(driver);
        loginPage.dynamicLogin("EM05", "sentrifugo");
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "http://demo.sentrifugo.com/index.php/index/welcome";
        Assert.assertEquals(actualUrl, expectedUrl);

    }

    @Test
    public void ValidateManagement() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.sentrifugo.com/index.php/");
        driver.manage().window().maximize();
        LoginPageSntr loginPage = new LoginPageSntr(driver);
        loginPage.dynamicLogin("EM02", "sentrifugo");
        String actualTitle=driver.getTitle();
        String expectedTitle="Sentrifugo - Open Sourse HRMS";
        Assert.assertEquals(actualTitle,expectedTitle);

    }
}
