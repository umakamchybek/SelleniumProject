package action;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class ActionClassMethods {

    @Test
    public void ContexClick(){ // contexClick---> right click

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        WebElement contexMenu= driver.findElement(By.partialLinkText("Context"));
        contexMenu.click();
        WebElement box=driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        //ACTION CLASS YOU MUST USE PERFORM AT THE END
        actions.contextClick(box).perform();



    }
    @Test
    public void HoverOver() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        WebElement hover=driver.findElement(By.linkText("Hovers"));
        hover.click();
        Thread.sleep(2000);
        Actions actions=new Actions(driver);
        List<WebElement>names=driver.findElements(By.tagName("h5"));
        List <WebElement> pictures = driver.findElements(By.xpath("//div[@class='figure']/img"));
        List<String> expectedNames= Arrays.asList("name: user1","name: user2","name: user3");
        for(int i=0; i<names.size();i++){
            Thread.sleep(2000);
            actions.moveToElement(pictures.get(i)).perform();
            Assert.assertEquals(BrowserUtils.getTextMethod(names.get(i)),expectedNames.get(i));
            System.out.println( BrowserUtils.getTextMethod(names.get(i)));
        }

    }
    @Test
    public void DoubleClick(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        driver.manage().window().maximize();
        WebElement doubleClickButton=driver.findElement(By.tagName("button"));
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickButton).perform();


    }
    //TASK FOR STUDENTS
        /*
        Scenario to Automate:
1. Launch the Chrome web browser.
2. Open a URL "https://selenium08.blogspot.com/2019/11/double-click.html".
3. Locate the element "Double-click".
4.  click on the current location (i.e. on Double-click element).
5. Close the web browser.
         */

    @Test
    public void DoubleClickPractice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://selenium08.blogspot.com/2019/11/double-click.html");
        driver.manage().window().maximize();
        WebElement button =driver.findElement(By.xpath("//button[.='Double-Click me to see Alert message']"));
        Actions actoions= new Actions(driver);
        actoions.doubleClick(button).perform();
        driver.close();
    }

    @Test
    public void dragAndDrop()throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        driver.manage().window().maximize();
        WebElement acceptCoockies=driver.findElement(By.id("onetrust-accept-btn-handler"));
        Thread.sleep(3000);
        acceptCoockies.click();
        Actions actions=new Actions(driver);
       for(int i=0; i<5;i++){
           actions.click().sendKeys(Keys.ARROW_DOWN).perform();
       }

        WebElement draggable=driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement orangeBox=driver.findElement(By.xpath("//div[@class='test2']"));
        String actualMessage=BrowserUtils.getTextMethod(orangeBox);
        String expectedMessage="... Or here.";
        Assert.assertEquals(actualMessage,expectedMessage);
        Thread.sleep(3000);
        actions.dragAndDrop(draggable,orangeBox).perform();

        orangeBox=driver.findElement(By.xpath("//div[@class='test2']"));
        String actualAfterDragAndDrop=BrowserUtils.getTextMethod(orangeBox);
        String expectedAfterDragAndDrop="You did great!";
        Assert.assertEquals(actualAfterDragAndDrop,expectedAfterDragAndDrop);

        String actualcssValue=orangeBox.getCssValue("background-color");
        String expectedCssValue="rgba(238, 111, 11, 1)";

        Assert.assertEquals(actualcssValue,expectedCssValue);


    }
    @Test
    public void ClickAndHold()throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        WebElement acceptCoockies=driver.findElement(By.id("onetrust-accept-btn-handler"));
        Thread.sleep(3000);
        acceptCoockies.click();
        Actions actions=new Actions(driver);
        for(int i=0; i<5;i++){
            actions.click().sendKeys(Keys.ARROW_DOWN).perform();
        }
        WebElement blueBox=driver.findElement(By.xpath("//div[@class='test1']"));
        String actualBlueBoxMessage=BrowserUtils.getTextMethod(blueBox);
        String expectedBlueBoxMessage="Drag the small circle here ...";
        Assert.assertEquals(actualBlueBoxMessage,expectedBlueBoxMessage);
        WebElement draggable=driver.findElement(By.xpath("//div[@id='draggable']"));
        Thread.sleep(1000);
        actions.clickAndHold(draggable).moveToElement(blueBox).release().build().perform();


    }
    @Test
    public void DragAndDropPractice(){//please use drag and drop
        /*\
        1)Navigate to the website :"https://demoqa.com/droppable"
        2)Drag Drag me box and drop to drop box
        3)Validate the message is changed to "Dropped"
        4)Validate the css color is steel blue

         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://demoqa.com/droppable");
        driver.manage().window().maximize();
        WebElement accept = driver.findElement(By.xpath("//a[.='Accept']"));
        accept.click();
        WebElement notAcceptable = driver.findElement(By.xpath("//div[.='Not  Acceptable']"));
        WebElement dropBox = driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[.='Drop here']"));
        Actions action = new Actions(driver);
        action.clickAndHold(notAcceptable).moveToElement(dropBox).release().perform();




    }
    @Test
    public void ClickAndHoldPractice(){
        /*
        1)Navigate to the website :"https://demoqa.com/droppable"
        2)Click Accept
        3)ClickAndHold notAccepted box and release to Drop box
        4)validate the background is still white and message is still Drop here
        5)ClickAndHold acceptable box and release to Drop box
        6)Validate the background is blue and message is dropped
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/droppable");
        driver.manage().window().maximize();
        WebElement accept = driver.findElement(By.xpath("//a[.='Accept']"));
        accept.click();
        WebElement notAcceptable = driver.findElement(By.xpath("//div[.='Not  Acceptable']"));
        WebElement dropBox = driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[.='Drop here']"));
        Actions action = new Actions(driver);
        action.clickAndHold(notAcceptable).moveToElement(dropBox).release().perform();
        WebElement Acceptable = driver.findElement(By.xpath("//div[.='Acceptable']"));
        dropBox = driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[.='Drop here']"));
        action.clickAndHold(Acceptable).moveToElement(dropBox).release().perform();
        String actualCssValue = dropBox.getCssValue("background-color");
        String expectedCssValue = "rgba(70, 130, 180, 1)";
        Assert.assertEquals(actualCssValue, expectedCssValue);
    }
    @Test
    public void MoveByOffSet(){
      WebDriverManager.chromedriver().setup();
      WebDriver driver=new ChromeDriver();
      driver.get("https://the-internet.herokuapp.com/horizontal_slider");
      driver.manage().window().maximize();
      WebElement slider =driver.findElement(By.xpath("//input"));
      Actions actions = new Actions(driver);
      //x---> means horizontal y means vertical
      actions.clickAndHold(slider).moveByOffset(-30,0).perform();




    }
    @Test
    public void sliderShortCut(){  // this shortcut for testing slider
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        driver.manage().window().maximize();
        WebElement slider =driver.findElement(By.xpath("//input"));
        WebElement range=driver.findElement(By.xpath("//span[@id='range']"));
        String myRange="5";
        while(!range.getText().trim().equals(myRange)){
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
        /*
        TASK FOR STUDENTS:
1)navigate to the Website "https://text-compare.com/"
2)Type with the Keys --> "Good Bye Keys"
3)with CTRL(COMMAND)+A --> select all text
4)Copy this text CTRL(COMMAND) + C --> it will copy the text
5)Go to the second box and paste CTRL(COMMAND) + V-->it will paste the text
6) Validate this two boxes text are matching
         */

    }




}
