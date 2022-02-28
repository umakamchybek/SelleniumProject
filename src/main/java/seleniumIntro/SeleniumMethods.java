package seleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumMethods {
    public static void main(String[] args) throws InterruptedException{
        //WHAT IS THE DIFFERENCE BETWEEN driver.get and driver.navigate().to()

        // WHAT IS THE DIFFERENCE BETWEEN   driver.quit(); AND driver.close();

        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // driver.navigate().to()---> it navigates to the website
        driver.navigate().to("https://www.google.com/");

       // driver.quit();
        //driver.close();

        Thread.sleep(3000);
        //System.out.println(driver.getTitle());
        //System.out.println(driver.getCurrentUrl());
        //System.out.println(driver.getPageSource());

        driver.navigate().to("https://www.techtorialacademy.com/");
        Thread.sleep(3000);
        driver.navigate().back();//amazon
        Thread.sleep(3000);
        driver.navigate().forward();//techtorial
        Thread.sleep(3000);
        driver.navigate().refresh();

        driver.close();

        // TASK

    }
}
