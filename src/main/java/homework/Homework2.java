package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework2 {
    public static void main(String[] args)throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        driver.get("https://demoqa.com/radio-button");

        driver.manage().window().maximize();
        WebElement yesRadio=driver.findElement(By.xpath("//input[@id='yesRadio']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()",yesRadio);
        Thread.sleep(2000);
        WebElement yesRadioValidation= driver.findElement(By.xpath("//p[@class='mt-3']"));
        System.out.println(yesRadioValidation.getText());
        String actualYesRadio = yesRadioValidation.getText();
        String expectedYesRadio="You have selected Yes";
        if (actualYesRadio.equals(expectedYesRadio)) {

            System.out.println("passed");
        }else{
            System.out.println("failed");
        }

        WebElement impressive =driver.findElement(By.xpath("//input[@id='impressiveRadio']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()",impressive);
        Thread.sleep(2000);
        WebElement impressiveValidation=driver.findElement(By.xpath("//p[@class='mt-3']"));
        System.out.println(impressiveValidation.getText());
        String actualImpressive=impressiveValidation.getText();
        String expectedImpressive="You have selected Impressive";
        if (actualImpressive.equals(expectedImpressive)) {

            System.out.println("passed");
        }else{
            System.out.println("failed");
        }




    }

    }

