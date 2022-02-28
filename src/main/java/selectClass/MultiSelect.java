package selectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

public class MultiSelect {
    @Test
    public void multipleSelectAndFirstSelectPtactice() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("file:///C:/Users/umuta/Downloads/Techtorial%20(3).html");
        driver.manage().window().maximize();
        WebElement multiSelectBox=driver.findElement(By.xpath("//select[@class='select']"));
        Select select=new Select(multiSelectBox);
        select.selectByValue("2");
        select.selectByIndex(3);
        select.selectByVisibleText("One");
        Thread.sleep(2000);
        select.deselectByIndex(3);
        //select.deselectAll();
        WebElement countryList=driver.findElement(By.name("country"));
// trim() --> it removes the spaces
        Select country =new Select(countryList);
       // String actualFirstSelectedOption=country.getFirstSelectedOption().getText().trim();//both works
        String actualFirstSelectedOption = BrowserUtils.getTextMethod(country.getFirstSelectedOption());//both works
        String expectedFirstSelectedOption="UNITED STATES";
        Assert.assertEquals(actualFirstSelectedOption,expectedFirstSelectedOption);


















    }

}
