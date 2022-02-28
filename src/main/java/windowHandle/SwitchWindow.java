package windowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import javax.sql.rowset.BaseRowSet;
import java.util.Set;

public class SwitchWindow {
    @Test
    public void practice1() throws InterruptedException{
        //it is failing because my driver is still pointing the last tab
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.manage().window().maximize();
        WebElement click=driver.findElement(By.xpath("//a[.='Click Here']"));
        click.click();
        Thread.sleep(2000);
        WebElement header=driver.findElement(By.xpath("//h3[.='New Window']"));
        System.out.println(header.getText());
    }
    @Test
    public void SwitchingWindow()throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.manage().window().maximize();
        System.out.println(driver.getWindowHandle());
        WebElement click=driver.findElement(By.xpath("//a[.='Click Here']"));
        click.click();
        Thread.sleep(2000);
        System.out.println(driver.getWindowHandles());
       // WebElement header=driver.findElement(By.xpath("//h3[.='New Window']"));
        String mainPageId= driver.getWindowHandle();
        Set<String> allPagesId=driver.getWindowHandles();

        //this implementation for only 2 tabs

        for(String id:allPagesId){
            //System.out.println(id);
            if(!id.equals(mainPageId)){
                driver.switchTo().window(id);
            }

        }
       WebElement header=driver.findElement(By.xpath("//h3[.='New Window']"));
        System.out.println(header.getText());
        String actualText=header.getText();
        String expectedText="New Window";
        Assert.assertEquals(actualText,expectedText);

    }
    @Test
    public void WindowHandlePractice2()throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        driver.manage().window().maximize();
        String mainPageId=driver.getWindowHandle();
        Thread.sleep(2000);
        WebElement button2=driver.findElement(By.id("newTabBtn"));
        BrowserUtils.ScrollWithJS(driver,button2);
        button2.click();
        BrowserUtils.SwitchOnlyFor2Tabs(driver,mainPageId);
//
//        Set<String >allPagesId=driver.getWindowHandles();
//        for(String id: allPagesId){
//            if(!id.equals(mainPageId)){
//                driver.switchTo().window(id);
//
//            }
//        }

        WebElement header = driver.findElement(By.xpath("//h1[contains(text(),'Alert')]"));
        String actualHeader= BrowserUtils.getTextMethod(header);
        String expectedHeader="AlertsDemo";
        Assert.assertEquals(actualHeader,expectedHeader);

        WebElement click=driver.findElement(By.id("alertBox"));
        click.click();

    }

}
