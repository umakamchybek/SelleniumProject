package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonHomework {
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.get(" https://www.amazon.com/");
        driver.manage().window().maximize();

//tagname[contains(text(),'textitself')];

        WebElement signButton = driver.findElement(By.xpath("//span[contains(text(),'Hello, Sign in')]"));
        signButton.click();
        WebElement create = driver.findElement(By.xpath("//a[contains(text(),'Create your Amazon account')]"));
        create.click();

        Thread.sleep(1000);
        WebElement name = driver.findElement(By.xpath("//input[@name='customerName']"));
        name.sendKeys("Uma");
        Thread.sleep(1000);
        WebElement email=driver.findElement(By.xpath("//input[@name='email']"));
        email.sendKeys("uma@techtorial.com");
        Thread.sleep(1000);
        WebElement password =driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("uma123456");
        Thread.sleep(1000);
        WebElement passwordCheck = driver.findElement(By.xpath("//input[@name='passwordCheck']"));
        passwordCheck.sendKeys("uma123456");
        Thread.sleep(1000);
        WebElement continueButton= driver.findElement(By.xpath("//input[@class='a-button-input']"));
        continueButton.click();




    }
}
