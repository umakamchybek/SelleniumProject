package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework3 {
    public static void main(String[] args)throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        WebElement username= driver.findElement(By.xpath("//input[@placeholder='Username']"));
        username.sendKeys("Java");
        Thread.sleep(2000);

        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys("Selenium");
        Thread.sleep(2000);

        WebElement loginButton= driver.findElement(By.xpath("//input[@class='submit-button btn_action']"));
        loginButton.click();
        Thread.sleep(2000);

        WebElement epicSadface= driver.findElement(By.xpath("//h3"));
        System.out.println(epicSadface.getText());

        String actualEpicSadFace = epicSadface.getText();
        String expectedEpicSadFace="Epic sadface: Username and password do not match any user in this service";
        if (actualEpicSadFace.equals(expectedEpicSadFace)) {

            System.out.println("passed");
        }else{
            System.out.println("failed");
        }

    }
}
