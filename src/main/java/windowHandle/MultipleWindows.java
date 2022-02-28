package windowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {
    @Test
    public void MultipleWindowsTest()throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.manage().window().maximize();
        WebElement clickHere=driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHere.click();
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.open('http://www.techtorialacademy.com/')");
        Thread.sleep(2000);
        js.executeScript("window.open('https://www.techtorialacademy.com/about-us')");
        Thread.sleep(2000);
        js.executeScript("window.open('https://www.techtorialacademy.com/programs')");

        Set<String> allPages = driver.getWindowHandles();
        for (String id: allPages){ //internet -> new window
            driver.switchTo().window(id);
            if (driver.getTitle().contains("About Us - Techtorial"));
            break;
        }
        }

    }


