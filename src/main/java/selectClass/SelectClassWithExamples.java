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

public class SelectClassWithExamples{
    // https://demo.guru99.com/test/newtours/reservation.php
    @Test
    public void validateTripRadioButton(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");
        driver.manage().window().maximize();
        WebElement oneWayRadio = driver.findElement(By.xpath("//input[@value='oneway']"));
        WebElement roundTripRadio = driver.findElement(By.xpath("//input[@value='roundtrip']"));
        oneWayRadio.click();
        Assert.assertTrue(oneWayRadio.isSelected() && !(roundTripRadio.isSelected())); // it must be tru to pass the assertions
        Assert.assertTrue(oneWayRadio.isSelected());
    }
    @Test
    public void selectMethod() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");
        driver.manage().window().maximize();
        WebElement passengerCount = driver.findElement(By.name("passCount"));
        Select selectPassengerCount = new Select(passengerCount);
        selectPassengerCount.selectByIndex(1);
        WebElement departFrom = driver.findElement(By.name("fromPort"));
        Select selectDepartFrom = new Select(departFrom);
        selectDepartFrom.selectByValue("San Francisco");
        WebElement monthDepart = driver.findElement(By.name("fromMonth"));
        Select selectmonthDepart = new Select(monthDepart);
        selectmonthDepart.selectByValue("2");
        WebElement dayDepart = driver.findElement(By.name("fromDay"));
        Select selectDayDepart = new Select(dayDepart);
        selectDayDepart.selectByValue("13");
        WebElement arrivingTo = driver.findElement(By.name("toPort"));
        Select selectArrivingTo = new Select(arrivingTo);
        selectArrivingTo.selectByValue("Paris");
        WebElement monthArrive = driver.findElement(By.name("toMonth"));
        Select selectMonthArrive = new Select(monthArrive);
        selectMonthArrive.selectByValue("2");
        WebElement dayArrive = driver.findElement(By.name("toDay"));
        Select selectDayArrive = new Select(dayArrive);
        selectDayArrive.selectByValue("20");
        //Coach Business
        WebElement economyClass = driver.findElement(By.xpath("//input[@value='Coach']"));
        WebElement businessClass = driver.findElement(By.xpath("//input[@value='Business']"));
        WebElement firstClass = driver.findElement(By.xpath("//input[@value='First']"));
        firstClass.click();
        Assert.assertTrue(firstClass.isSelected() && !(economyClass.isSelected()) && !(businessClass.isSelected()));
        //input[@name='findFlights']
        WebElement continueButton = driver.findElement(By.xpath("//input[@name='findFlights']"));
        continueButton.click();
        Thread.sleep(2000);
        String expectedMessage = "After flight finder - No Seats Avaialable";
        String actualMessage = driver.findElement(By.xpath("//tbody/tr[1]/td[1]/p[1]/font[1]/b[1]/font[1]")).getText();
        Assert.assertEquals(actualMessage,expectedMessage);
    }
    @Test
    public void theSecondWay() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");
        driver.manage().window().maximize();
        WebElement passengerCount = driver.findElement(By.name("passCount"));
        // OLD CODE:
        //Select selectPassengerCount = new Select(passengerCount);
        //selectPassengerCount.selectByIndex(1);
        // NEW CODE With Utils Class method:
     //   BrowserUtils.selectBy(passengerCount, "2", "value");
        WebElement departFrom = driver.findElement(By.name("fromPort"));
        Select selectDepartFrom = new Select(departFrom);
        selectDepartFrom.selectByVisibleText("San Francisco");
      //  BrowserUtils.selectBy(departFrom, "Paris", "text");
        WebElement monthDepart = driver.findElement(By.name("fromMonth"));
        Select selectmonthDepart = new Select(monthDepart);
        selectmonthDepart.selectByValue("2");
      //  BrowserUtils.selectBy(monthDepart, "2", "value");
        WebElement dayDepart = driver.findElement(By.name("fromDay"));
        Select selectDayDepart = new Select(dayDepart);
        selectDayDepart.selectByValue("13");
      //  BrowserUtils.selectBy(dayDepart, "13", "value");
        WebElement arrivingTo = driver.findElement(By.name("toPort"));
        Select selectArrivingTo = new Select(arrivingTo);
        selectArrivingTo.selectByValue("Paris");
       // BrowserUtils.selectBy(arrivingTo, "Paris", "value");
        WebElement monthArrive = driver.findElement(By.name("toMonth"));
      //  BrowserUtils.selectBy(monthArrive, "2", "value");
        Select selectMonthArrive = new Select(monthArrive);
        selectMonthArrive.selectByValue("2");
        WebElement dayArrive = driver.findElement(By.name("toDay"));
       // BrowserUtils.selectBy(dayArrive, "20", "value");
        Select selectDayArrive = new Select(dayArrive);
        selectDayArrive.selectByValue("20");
        //Coach Business
        WebElement economyClass = driver.findElement(By.xpath("//input[@value='Coach']"));
        WebElement businessClass = driver.findElement(By.xpath("//input[@value='Business']"));
        WebElement firstClass = driver.findElement(By.xpath("//input[@value='First']"));
        firstClass.click();
        Assert.assertTrue(firstClass.isSelected() && !(economyClass.isSelected()) && !(businessClass.isSelected()));
        //input[@name='findFlights']
        WebElement continueButton = driver.findElement(By.xpath("//input[@name='findFlights']"));
        continueButton.click();
        Thread.sleep(2000);
        String expectedMessage = "After flight finder - No Seats Available";
        String actualMessage = driver.findElement(By.xpath("//tbody/tr[1]/td[1]/p[1]/font[1]/b[1]/font[1]")).getText();
        Assert.assertEquals(actualMessage,expectedMessage);
    }
}
