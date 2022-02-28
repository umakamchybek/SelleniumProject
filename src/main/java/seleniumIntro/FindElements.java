package seleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElements {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();

        List<WebElement> allLinks = driver.findElements(By.xpath("//li//a"));
        int count =0;
        for(WebElement link: allLinks){
            if(link.getText().length()<=12) {
                System.out.println(link.getText());
                count++;

            }
        }
        System.out.println(count);


    }
}
