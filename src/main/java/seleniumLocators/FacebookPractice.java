package seleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookPractice {
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();

        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.facebook.com/";

        if(actualUrl.equals(expectedUrl)){
            System.out.println("The website is correct");
        }else{
            System.out.println("website is wrong");
        }
        WebElement create = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
        boolean validationButton=create.isDisplayed();
        boolean expectedValidationButton= true;
        if(validationButton==expectedValidationButton){
            System.out.println("Button is displayed");
        }else{
            System.out.println("button is not displayed");
        }
        create.click();
        Thread.sleep(1000);

        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys("Umutai");
        Thread.sleep(1000);

        WebElement lastName= driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys("Kamchybek");
        Thread.sleep(1000);

        WebElement mobileOrEmail=driver.findElement(By.xpath("//input[@name='reg_email__']"));
        mobileOrEmail.sendKeys("uma@gmail.com");
        Thread.sleep(1000);
        WebElement confEmail = driver.findElement(By.name("reg_email_confirmation__"));
        confEmail.sendKeys("uma@gmail.com");

        WebElement password= driver.findElement(By.name("reg_passwd__"));
        password.sendKeys("uma123456");
        Thread.sleep(1000);
        WebElement month = driver.findElement(By.id("month"));
        month.sendKeys("Dec");
        Thread.sleep(1000);
        WebElement birthday= driver.findElement(By.name("birthday_day"));
        birthday.sendKeys("18");
        Thread.sleep(1000);

        WebElement year= driver.findElement(By.name("birthday_year"));
        year.sendKeys("1992");
        Thread.sleep(1000);

        WebElement gender= driver.findElement(By.xpath("//input[@name='sex' and @value='1']"));
        gender.click();
        WebElement signInButton=driver.findElement(By.name("websubmit"));
        signInButton.click();






    }
}
