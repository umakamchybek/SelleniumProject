package JavaScriptExecutor;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

public class JavaScriptMethods {
    // whenever normal methods are not working then last decision sould be JavaScript
    @Test
    public void TitleMethod(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle() + "from driver");

//        JavascriptExecutor javascriptExecutor=(JavascriptExecutor)driver;
//        String title= javascriptExecutor.executeScript("return document.title").toString();
//        System.out.println(title+"from javaScript");
        String actualTitle= BrowserUtils.GetTitleWithJS(driver);
        String expectedTitle="Home Page - Techtorial";
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @Test
    public void ClickWithJS(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");
        driver.manage().window().maximize();
        Actions actions=new Actions(driver);
        for(int i=0; i<5;i++){
            actions.click().sendKeys(Keys.ARROW_DOWN).perform();
        }

        WebElement browseCourse= driver.findElement(By.xpath("//a[.='Browse Course']"));
//        JavascriptExecutor javascriptExecutor=(JavascriptExecutor)driver;
//        javascriptExecutor.executeScript("arguments[0].click()",browseCourse);
        BrowserUtils.ClickWithJS(driver,browseCourse);


    }
    @Test
    public void Practice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");
        driver.manage().window().maximize();
        WebElement signButton=driver.findElement(By.xpath("//div[@class='navigation hidden-xs']//a[.='Student login']"));
        BrowserUtils.ClickWithJS(driver,signButton);

    }
    @Test
    public void ScrollIntoView(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");
        driver.manage().window().maximize();
        WebElement copyright=driver.findElement(By.xpath("//p[contains(text(), 'Copyrights')]"));
        JavascriptExecutor js=(JavascriptExecutor)driver;
        //js.executeScript("arguments[0].scrollIntoView(true)",copyright);


    }
    @Test
    public void Practice1()throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");
        driver.manage().window().maximize();
        Actions actions=new Actions(driver);
        for(int i=0; i<5;i++){
            actions.click().sendKeys(Keys.ARROW_DOWN).perform();
        }
        WebElement browseCourse= driver.findElement(By.xpath("//a[.='Browse Course']"));
        BrowserUtils.ClickWithJS(driver,browseCourse);
        WebElement getStarted=driver.findElement(By.xpath("//h4[.='On-Campus Course']//..//a"));
        Thread.sleep(2000);
//        JavascriptExecutor js=(JavascriptExecutor)driver;
//        js.executeScript("arguments[0].scrollIntoView(true)",getStarted);
        BrowserUtils.ScrollWithJS(driver,getStarted);
        BrowserUtils.ClickWithJS(driver,getStarted);


    }
    @Test
    public void ScrollWithXandYCoordinantTest(){
            WebDriverManager.chromedriver().setup();
            WebDriver driver=new ChromeDriver();
            driver.get("http://www.techtorialacademy.com/");
            driver.manage().window().maximize();
            WebElement copyright=driver.findElement(By.xpath("//p[contains(text(), 'Copyrights')]"));
       // JavascriptExecutor js=(JavascriptExecutor)driver;
//        Point location=copyright.getLocation();
//        System.out.println(location.getX());
//        System.out.println(location.getY());
//        int xCord=location.getX();
//        int yCord=location.getY();
//        js.executeScript("window.scrollTo("+xCord+","+yCord+")");
        BrowserUtils.ScrollWithXandYCord(driver,copyright);
    }
    @Test
    public void MoveByOffSetPractice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");
        driver.manage().window().maximize();
        WebElement contactUs=driver.findElement(By.xpath("//div[@class='navigation hidden-xs']//..//a[.='Contact Us']"));
         Point coordinatesOfContactUs=contactUs.getLocation();
         int xCoord=coordinatesOfContactUs.getX();
         int yCoord=coordinatesOfContactUs.getY();
         Actions actions=new Actions(driver);
         actions.moveByOffset(xCoord,yCoord).click().perform();
    }
}
