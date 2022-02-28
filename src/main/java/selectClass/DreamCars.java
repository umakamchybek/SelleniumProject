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

import java.util.List;

public class DreamCars {
    @Test
        public void BMW() throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.cars.com/");
            driver.manage().window().maximize();
            Thread.sleep(300);
            WebElement newUsed = driver.findElement(By.name("stock_type"));
            newUsed.sendKeys("New & used cars");

            WebElement make = driver.findElement(By.id("makes"));
            //BrowserUtils.selectBy(make,"Honda","text");
        Select select1 = new Select(make);
        select1.selectByVisibleText("Honda");

            WebElement model = driver.findElement(By.xpath("//select[@id='models']"));
           // BrowserUtils.selectBy(model,"honda-cr_v","value");
        Select select2 =new Select(model);
        select2.selectByValue("honda-cr_v");

            WebElement maxPrice = driver.findElement(By.id("make-model-max-price"));
            //BrowserUtils.selectBy(maxPrice,"125000","value");
        Select select3 = new Select(maxPrice);
        select3.selectByValue("125000");

            WebElement distance = driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']"));
            //BrowserUtils.selectBy(distance,"10 miles","text");
        Select select4= new Select(distance);
        select4.selectByVisibleText("10 miles");

            WebElement zip = driver.findElement(By.xpath("//input[@id='make-model-zip']"));
            zip.sendKeys("32256");

            WebElement SearchBut = driver.findElement(By.xpath("//button[@data-linkname='search-all-make']"));
            SearchBut.click();
            Thread.sleep(200);

            WebElement header = driver.findElement(By.xpath("//h1[.='New and used Honda CR-V for sale']"));
            String actualH = header.getText();
            String expectedH = "New and used Honda CR-V for sale";
            Assert.assertEquals(actualH,expectedH);

            List<WebElement> headers = driver.findElements(By.xpath("//h2[@class='title']"));
            String expected = "Honda";
            int count = 0;
            for(WebElement element: headers){
                Assert.assertTrue(element.getText().contains(expected));
                count++;
            }
            System.out.println(count);
        }
    }

