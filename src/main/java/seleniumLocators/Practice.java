package seleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.Credentials;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");

        WebElement title = driver.findElement(By.xpath("//h3"));
        System.out.println(title.getText());

        WebElement paragraph =driver.findElement(By.xpath("//h4[@class='subheader']"));// //h4 also works
        System.out.println(paragraph.getText());

        //CONTAINS:  it works with text.

        //tagname[contains(text(),'Horizontalline')] // %60

        WebElement contains = driver.findElement(By.xpath("//h3[contains(text(), 'Horizontal Slider')]"));
        System.out.println(contains.getText());

        //TEXT: it works with text as well. This is simpler than contains method.

        //text.
                //h3[.='text']


    }
}
