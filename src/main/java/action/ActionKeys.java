package action;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionKeys {
    @Test
    public void Keys(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();

        Actions actions=new Actions(driver);

        WebElement googleSearch=driver.findElement(By.name("q"));
        actions.moveToElement(googleSearch).click().keyDown(Keys.SHIFT)
                .sendKeys("s").keyUp(Keys.SHIFT)
                .sendKeys("elenium")
                .doubleClick().keyDown(Keys.CONTROL)
                .sendKeys("c")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.ARROW_RIGHT)
                .keyDown(Keys.CONTROL)
                .sendKeys("v")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.RETURN)//or Keys.Enter
        .perform();
        //googleSearch.sendKeys("SeleniumSelenium");
        //IMPORTANT NOTES ABOUT KEYS:
        //Keys.ENTER or Keys,RETURN
        //Keys.Arrow right/left/up/down

    }


}
