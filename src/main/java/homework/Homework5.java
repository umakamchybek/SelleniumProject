package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework5 {
    public static void main(String[] args)throws InterruptedException {

        WebDriver driver= new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

        WebElement register= driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
        register.click();
        Thread.sleep(1000);
        WebElement gender= driver.findElement(By.xpath("//input[@id='gender-female']"));
        gender.click();
        Thread.sleep(1000);
        WebElement firstName= driver.findElement(By.xpath("//input[@name='FirstName']"));
        firstName.sendKeys("Uma");
        Thread.sleep(1000);
        WebElement lastName= driver.findElement(By.xpath("//input[@name='LastName']"));
        lastName.sendKeys("Kamchybek");
        Thread.sleep(1000);
        WebElement day=driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));
        day.sendKeys("18");
        WebElement  month=driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"));
        month.sendKeys("12");
        WebElement year= driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"));
        year.sendKeys("1992");

        WebElement email=driver.findElement(By.xpath("//input[@name='Email']"));
        email.sendKeys("uma@techtorial.com");
         WebElement company = driver.findElement(By.xpath("//input[@name='Company']"));
         company.sendKeys("Techtorial");
         WebElement newsletter = driver.findElement(By.xpath("//input[@name='Newsletter']"));
         newsletter.click();
         WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
         password.sendKeys("123456uma");
         WebElement passwordConfirm= driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
         passwordConfirm.sendKeys("123456uma");

         WebElement register2 = driver.findElement(By.xpath("//button[@name='register-button']"));
         register2.click();
         WebElement validate= driver.findElement(By.xpath("//li[contains(text(),'The specified email already exists')]"));
        System.out.println(validate.getText());

        String actualText= validate.getText();
        String expected ="";

         WebElement continue2 =  driver.findElement(By.xpath("//a[contains(text(),'Continue')]"));
         continue2.click();









    }
}
