package seleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathPractice {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/umuta/Downloads/Techtorial%20(2).html");

        WebElement javaLink = driver.findElement(By.xpath("//a[@href='https://www.oracle.com/java/']"));
        javaLink.click();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
    }
}
