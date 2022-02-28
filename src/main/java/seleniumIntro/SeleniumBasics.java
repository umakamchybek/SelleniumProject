package seleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasics {
    public static void main(String[] args) {
      // STEP 1: we need to define the chrome driver into the project
      //as a property
        //for windows
       System.setProperty("webdriver.chrome.driver","chromedriver.exe");

       //STEP 2: WE need to instantiate (declare) our driver

        WebDriver driver = new ChromeDriver();
        // driver is a reference name. WebDriver-->Interface
        //new ChromeDriver() --->new object

        //IQ 1: where do you use polymorphysm in your testing framework
        //i sused to instantiate my driver.example
        // WebDriver driver = new ChromeDriver();
        //IQ 2: can you instantiate your driver like  WebDriver driver = new WebDriver();// No we can't

        //FIRST METHOD:

        // get()--> methods navigates to the url.
        driver.get("https://www.techtorialacademy.com/");

        // getTitle() gets the title of the page
        String title = driver.getTitle();
        System.out.println(title);
        if(title.equals("Home Page - Techtorial")){
            System.out.println(" Your test is passed");
        }else{
            System.out.println("your test is failed");
        }

        // getCurrentUrl() --> it gets the current ul of the website
        String actual= driver.getCurrentUrl();
        String expected = "https://www.techtorialacademy.com/";

        if(actual.equals(expected)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }


    }

}
