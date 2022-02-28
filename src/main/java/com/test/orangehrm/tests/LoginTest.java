package com.test.orangehrm.tests;

import com.test.orangehrm.TestBase;
import com.test.orangehrm.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void validateLoginPositive(){

        LoginPage loginPage= new LoginPage(driver);
        loginPage.login("Admin","admin123");
        Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/index.php/dashboard");
    }
    @Test
    public void validateLoginNegative(){
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver=new ChromeDriver();
//        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
//        driver.manage().window().maximize();
        LoginPage loginPage= new LoginPage(driver);
        loginPage.login("Admin","ahmet");
        String actualErrorMessage=loginPage.getErrorMessage();
        String expectedErrorMessage="Invalid credentials";
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
    }
    @Test
    public void validateLoginNegative2(){
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver=new ChromeDriver();
//        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
//        driver.manage().window().maximize();
        LoginPage loginPage= new LoginPage(driver);
        loginPage.login("","");
        String actualErrorMessage=loginPage.getErrorMessage();
        String expectedErrormessage="Username cannot be empty";
        Assert.assertEquals(actualErrorMessage,expectedErrormessage);
        String actualcolorOfError=loginPage.getColorOfTheErrorMessage();
        String expectedcolorOfErrorMessage="rgba(221, 119, 0, 1)";
        Assert.assertEquals(actualcolorOfError,expectedcolorOfErrorMessage);
    }

}
