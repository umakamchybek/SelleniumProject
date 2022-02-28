package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework1 {
    public static void main(String[] args)throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        driver.get("https://demoqa.com/text-box");

        WebElement fullName= driver.findElement(By.xpath("//input[@placeholder='Full Name']"));
        fullName.sendKeys("Umutai Kamchybek");
        fullName.isDisplayed();
        Thread.sleep(2000);

        WebElement email = driver.findElement(By.xpath("//input[@placeholder='name@example.com']"));
        email.sendKeys("uma@techtorialacademy.com");
        email.isDisplayed();
        Thread.sleep(2000);

        WebElement currentAddress = driver.findElement(By.xpath("//textarea[@placeholder='Current Address']"));
        currentAddress.sendKeys("1234 W Fletcher St, Chicago, IL 60641");
        currentAddress.isDisplayed();
        Thread.sleep(2000);

        WebElement permanentAddress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAddress.sendKeys("1234 W Fletcher St, Chicago, IL 60641");
        permanentAddress.isDisplayed();
        Thread.sleep(2000);

        WebElement submit = driver.findElement(By.xpath("//button[@id='submit']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submit);
        Thread.sleep(500);
        submit.click();

        WebElement namevalidation= driver.findElement(By.xpath("//p[@id='name']"));
        System.out.println(namevalidation.getText());

        String actualNameValidation = namevalidation.getText();
        String expectedNameValidation ="Name:Umutai Kamchybek";
        if (actualNameValidation.equals(expectedNameValidation)) {

            System.out.println("passed");
        }else{
            System.out.println("failed");
        }
        WebElement emailValidation=driver.findElement(By.xpath("//p[@id='email']"));
        System.out.println(emailValidation.getText());

        String actualEmailValidation = emailValidation.getText();
        String expectedEmailValidation ="Email:uma@techtorialacademy.com";
        if(actualEmailValidation.equals(expectedEmailValidation)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }
        WebElement currentAddressValidation= driver.findElement(By.xpath("//p[@id='currentAddress']"));
        System.out.println(currentAddressValidation.getText());

        String actualCurrentAddress= currentAddressValidation.getText();
        String expectedCurrentAddress="Current Address :1234 W Fletcher St, Chicago, IL 60641";
        if(actualCurrentAddress.equals(expectedCurrentAddress)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }
        WebElement permanentAddressValidation= driver.findElement(By.xpath("//p[@id='permanentAddress']"));
        System.out.println(permanentAddressValidation.getText());

        String actualPermanentAddress= permanentAddressValidation.getText();
        String expectedPermanentAddress="Permananet Address :1234 W Fletcher St, Chicago, IL 60641";
        if(actualPermanentAddress.equals(expectedPermanentAddress)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }



    }
}
