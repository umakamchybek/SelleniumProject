package iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

public class IframePractice {
    @Test
    public void iframeTest()throws InterruptedException{

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.manage().window().maximize();
        driver.switchTo().frame("mce_0_ifr");
        //do not forget to switch your frame before you fin the element
        WebElement box=driver.findElement(By.id("tinymce"));
        Thread.sleep(2000);
        box.clear();
        box.sendKeys("I love Selenium");
        driver.switchTo().parentFrame();

        WebElement header=driver.findElement(By.tagName("h3"));
        String actualHeader= BrowserUtils.getTextMethod(header);
        String expectedHeader="An iFrame containing the TinyMCE WYSIWYG Editor";
        Assert.assertEquals(actualHeader,expectedHeader);
    }
}
