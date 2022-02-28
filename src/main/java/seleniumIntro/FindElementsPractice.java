package seleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElementsPractice {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.yahoo.com/");
        driver.manage().window().maximize();

        WebElement news=driver.findElement(By.xpath("//a[@id='root_2']"));
        news.click();

        List<WebElement> headers=driver.findElements(By.xpath("//h3"));
        int count=0;
        for(WebElement header: headers){
            //System.out.println(header.getText());
            if(header.getText().toUpperCase().contains("COVID")){
                System.out.println(header.getText());
                count++;
            }

        }
        System.out.println(count);


    }
}
