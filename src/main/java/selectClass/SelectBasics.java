package selectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class SelectBasics {
    @Test
    public void practice1(){
       // WebDriverManager.firefoxdriver().setup();
       // WebDriver driver =new FirefoxDriver();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

        WebElement dropdown = driver.findElement(By.linkText("Dropdown"));
        dropdown.click();
        WebElement optionsBox=driver.findElement(By.id("dropdown"));
        Select option = new Select(optionsBox);
       // option.selectByIndex(2);//option 2
        //option.selectByValue("2");
        option.selectByVisibleText("Option 1");
        List<WebElement>options=option.getOptions();
        for(WebElement optn:options){

            System.out.println(optn.getText().trim());

        }

    }
}
