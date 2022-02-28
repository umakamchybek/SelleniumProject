package seleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro {
    public static void main(String[] args)throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/umuta/Downloads/Techtorial%20(2).html");

        //LOCATOR: ID
        WebElement header = driver.findElement(By.id("techtorial1"));



        String actualText = header.getText();// from the system

        String expectedText ="Techtorial Academy";// from th business requirement

        if(actualText.equals(expectedText)){
            System.out.println(" passed");
        }else{
            System.out.println("failed");
        }


        //
        WebElement paragraph = driver.findElement(By.id("details2"));
        System.out.println(paragraph.getText());


        //LOCATOR: CLASSNAME

        WebElement tools= driver.findElement(By.className("group_checkbox"));
        System.out.println(tools.getText());

        //LOCATOR: NAME
        WebElement firstName=driver.findElement(By.name("firstName"));
        firstName.sendKeys("Umutai");
        Thread.sleep(2000);
        WebElement lastName = driver.findElement(By.name("lastName"));
        lastName.sendKeys("Kamchybek");
        Thread.sleep(2000);
        WebElement phone= driver.findElement(By.name("phone"));
        phone.sendKeys("224-254-9025");
        Thread.sleep(2000);
        WebElement email = driver.findElement(By.name("userName"));
        email.sendKeys("uma@techtorialacademy.com");

        WebElement  javaBox= driver.findElement(By.id("cond1"));
        javaBox.click();
        javaBox.isDisplayed();//true
        javaBox.isSelected();//true

        WebElement testNg= driver.findElement(By.id("cond3"));
        testNg.click();

        WebElement cucumber = driver.findElement(By.id("cond4"));
        cucumber.click();





    }
}
