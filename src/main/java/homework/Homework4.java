package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework4 {
    public static void main(String[] args)throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        WebElement username= driver.findElement(By.xpath("//input[@placeholder='Username']"));
        username.sendKeys("standard_user");
        Thread.sleep(2000);

        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys("secret_sauce");
        Thread.sleep(2000);

        WebElement loginButton= driver.findElement(By.xpath("//input[@class='submit-button btn_action']"));
        loginButton.click();
        Thread.sleep(2000);

        driver.getCurrentUrl();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl ="https://www.saucedemo.com/inventory.html";
        if (actualUrl.equals(expectedUrl)) {

            System.out.println("passed");
        }else{
            System.out.println("failed");
        }
      driver.quit();


    }
}
