package testNG;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.systeminfo.model.GPUDevice;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class PracticeRealWebsite {
    @Test
    public void validateWebsite(){
        WebDriver driver =new ChromeDriver();

        driver.get("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();

        String actualWebsite=driver.getCurrentUrl();
        String expectedWebsite = "https://demo.opencart.com/admin/";
        Assert.assertEquals(actualWebsite,expectedWebsite);

        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();

    }
    @Test
    public void validateCatalogIsDisplayed(){
        WebDriver driver =new ChromeDriver();

        driver.get("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();

        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();
        WebElement catalogBar= driver.findElement(By.id("menu-catalog"));
        boolean ActualCatalog= catalogBar.isDisplayed();
        boolean ExpectedCatalog= true;
        Assert.assertEquals(ActualCatalog,ExpectedCatalog);
        catalogBar.click();
        WebElement product =driver.findElement(By.xpath("//a[contains(text(),'Products')]"));
        product.click();

    }
    @Test
            public void validateProduct(){
        WebDriver driver =new ChromeDriver();

        driver.get("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();

        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();
        WebElement catalogBar= driver.findElement(By.id("menu-catalog"));

        catalogBar.click();
        WebElement product =driver.findElement(By.xpath("//a[contains(text(),'Products')]"));
        boolean actualProduct=product.isDisplayed();
        boolean expectedProduct=true;
        Assert.assertEquals(actualProduct,expectedProduct);
        product.click();
    }
    @Test
    public void validateBox()throws InterruptedException{
        WebDriver driver =new ChromeDriver();

        driver.get("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();

        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();
        WebElement catalogBar= driver.findElement(By.id("menu-catalog"));

        catalogBar.click();
        WebElement product =driver.findElement(By.xpath("//a[contains(text(),'Products')]"));
        Thread.sleep(1000);
        product.click();

        List<WebElement> boxes=driver.findElements(By.xpath("//input[@type='checkbox']"));
        for(int i=1; i<boxes.size();i++){
            Thread.sleep(1000);
            boxes.get(i).click();
            boolean actualBoxValidation=boxes.get(i).isDisplayed();
            boolean expectedBoxValidation=true;
            Assert.assertEquals(actualBoxValidation,expectedBoxValidation);
            boolean actualBoxValidationSelected=boxes.get(i).isSelected();
            boolean expectedBoxValidationSelected=true;
            Assert.assertEquals(actualBoxValidationSelected,expectedBoxValidationSelected);





        }
    }
}
