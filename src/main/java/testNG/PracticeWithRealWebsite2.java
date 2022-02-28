package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class PracticeWithRealWebsite2 {
    @Test
    public void validationOfAccendingOrder() throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();
        WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        WebElement catalogBar=driver.findElement(By.id("menu-catalog"));
        catalogBar.click();
        Thread.sleep(500);
        WebElement optionButton = driver.findElement(By.xpath("//a[.='Options']"));
        optionButton.click();
        Thread.sleep(500);
        List<WebElement> allOptions = driver.findElements(By.xpath("//tbody/tr/td[2]"));
        //create a set to check the ascending order:
        Set<String> expectedOptionOrder = new TreeSet<String >(); //>>> ascending order
        //linkedHashSet accepts insertion order, that is why we are using it
        Set<String> actualOptionsOder = new LinkedHashSet<String >(); //>>> insertion order
        //use loop to add each element one by one into sets:
        for(WebElement options : allOptions){
            actualOptionsOder.add(options.getText().trim());
            expectedOptionOrder.add(options.getText().trim());
        }
        Assert.assertEquals(actualOptionsOder,expectedOptionOrder);
    }
    @Test
    public void validationOfDescendingOrderOptions() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();
        WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        WebElement catalogBar=driver.findElement(By.id("menu-catalog"));
        catalogBar.click();
        Thread.sleep(500);
        WebElement optionButton = driver.findElement(By.xpath("//a[.='Options']"));
        optionButton.click();
        Thread.sleep(500);
        WebElement optionNameButton = driver.findElement(By.xpath("//a[.='Option Name']"));
        optionNameButton.click();
        List<WebElement> descendingAllOptions=driver.findElements(By.xpath("//tbody/tr/td[2]"));
        //in order to work with descending order we will use LinkedList, then use sort and reverse methods:
        List<String> actualDescendingOrder = new LinkedList<String >();
        List<String> expectedDescendingOrder = new ArrayList<String>();
        for (int i = 0; i < descendingAllOptions.size(); i++) {
            actualDescendingOrder.add(descendingAllOptions.get(i).getText().trim());
            expectedDescendingOrder.add(descendingAllOptions.get(i).getText().trim());
            Collections.sort(expectedDescendingOrder);
            Collections.reverse(expectedDescendingOrder);
        }
        Assert.assertEquals(actualDescendingOrder, expectedDescendingOrder);
    }
}
