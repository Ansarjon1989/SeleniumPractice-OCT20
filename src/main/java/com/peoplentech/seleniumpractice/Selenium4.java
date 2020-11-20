package com.peoplentech.seleniumpractice;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Selenium4 extends TestBase {

    // Logger objectni yasashdan maqsad, System.out.println(); joyiga ishlatiladi. U soat  va detaillari bilan hamma infoni chiqorib beradi.
    // Masalan : 2020-11-20 07:56:25 main INFO  Selenium4:234 - Do you really want to delete this Customer?
    //           2020-11-20 07:56:27 main INFO  Selenium4:240 - Customer Successfully Delete!
    private static Logger LOGGER = Logger.getLogger(Selenium4.class);

    @Test
    // Drag and Drop ni Test qilish yo'li. Masalan : http://demo.guru99.com/test/drag_drop.html
    public static void validateDrugAndDrop() {

        setupDriver("chrome");
        navigateToURL("http://demo.guru99.com/test/drag_drop.html");
        sleepFor(3);

        WebElement source = driver.findElement(By.xpath("(//li[@data-id=\"2\"])[1]"));
        WebElement destination = driver.findElement(By.xpath("//ol[@id=\"amt8\"]"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, destination).build().perform();

        sleepFor(5);
        closeDriver();
    }

    @Test(enabled = false)//Selenium4 Classni ichida shu Test Caseni uqimaydi (ishlamaydi)
    public void validateiFrame() {
        setupDriver("chrome");
        navigateToURL("https://demoqa.com/frames");
        sleepFor(3);

        //frame ID
        //frame Name
        // frame Index

        driver.switchTo().frame("frame1");
        // perform all actions that required in the child page
        driver.findElement(By.xpath("xpath from child page")).click();

        driver.switchTo().defaultContent();
        // perform all actions that required in the main page
        driver.findElement(By.xpath("xpath from main page")).click();

        sleepFor(3);
        closeDriver();

    }

    @Test
    public static void validateDropDown() {

        setupDriver("chrome");
        navigateToURL("https://www.ebay.com");
        sleepFor(3);


        WebElement element = driver.findElement(By.id("gh-cat"));

        Select select = new Select(element);
        select.selectByVisibleText("Music");

        sleepFor(3);
        closeDriver();

    }

    @Test
    public static void validateMouseHover() {

        setupDriver("chrome");
        navigateToURL("https://www.ebay.com");
        sleepFor(2);

        WebElement motors = driver.findElement(By.linkText("Motors"));

        Actions actions = new Actions(driver);
        actions.moveToElement(motors).build().perform();
        sleepFor(2);
        driver.findElement(By.linkText("Cars & Trucks")).click();

        sleepFor(3);
        closeDriver();
    }

    @Test
    public static void validateMouseHover2() {
        setupDriver("firefox");
        navigateToURL("https://www.ebay.com");
        sleepFor(2);

        WebElement motors = driver.findElement(By.linkText("Motors"));

        Actions actions = new Actions(driver);
        actions.moveToElement(motors).build().perform();
        sleepFor(2);
        driver.findElement(By.linkText("Business & Industrial")).click();

        sleepFor(3);
        closeDriver();

    }

    @Test
    public static void validateMouseHover3() {
        setupDriver("firefox");
        navigateToURL("https://www.ebay.com");

        WebElement fashion = driver.findElement(By.linkText("Fashion"));
        Actions actions = new Actions(driver);
        actions.moveToElement(fashion).build().perform();

        sleepFor(3);
        driver.findElement(By.linkText("Jewelry")).click();
        sleepFor(3);

        navigateBack();

        WebElement electronics = driver.findElement(By.linkText("Electronics"));
        sleepFor(3);

        Actions action = new Actions(driver);
        action.moveToElement(electronics).build().perform();
        sleepFor(3);

        driver.findElement(By.linkText("Laptops")).click();


        sleepFor(4);
        closeDriver();
    }



    @Test
    public static void validateMouseHover4() {
        setupDriver("firefox");
        navigateToURL("https://www.ebay.com");

        WebElement sportingGoods = driver.findElement(By.linkText("Sporting Goods"));

        Actions actions = new Actions(driver);
        actions.moveToElement(sportingGoods).build().perform();
        sleepFor(3);

        driver.findElement(By.linkText("Golf")).click();
        sleepFor(3);

        navigateBack();
        sleepFor(3);

        WebElement toys = driver.findElement(By.linkText("Toys"));
        sleepFor(3);

        Actions action = new Actions(driver);
        actions.moveToElement(toys).build().perform();
        sleepFor(3);


        driver.findElement(By.linkText("Action Figures")).click();

        sleepFor(4);
        closeDriver();
    }

    @Test
    public static void validateScroll(){

        setupDriver("firefox");
        navigateToURL("https://www.ebay.com");

        //driver  JavascriptExecutor bilan ishlay oladi shu kod bilan
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,1000)");

        sleepFor(4);
        closeDriver();
    }

    @Test
    public static void validateScrollToElement(){

        setupDriver("firefox");
        navigateToURL("https://www.ebay.com");

        //driver  JavascriptExecutor bilan aniq elementni scroll qilish mumkin masalan: "arguments[0].scrollIntoView(true)"
        // ("Announcements")ga tushiradi. bu yerda arguement aniq element.

        WebElement element = driver.findElement(By.linkText("Announcements"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true)", element);

        sleepFor(5);
        closeDriver();
    }

    @Test
    public static void validateScrollToElement2(){

        setupDriver("firefox");
        navigateToURL("https://www.ebay.com");

        //driver  JavascriptExecutor bilan aniq elementni scroll qilish mumkin masalan: "arguments[0].scrollIntoView(true)"
        // ("Announcements")ga tushiradi. bu yerda arguement aniq element.

        WebElement element = driver.findElement(By.linkText("News"));

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true)", element);

        sleepFor(5);
        closeDriver();
    }

    @Test
    public void validatePopUp(){

        setupDriver("chrome");
        navigateToURL("http://demo.guru99.com/test/delete_customer.php");
        sleepFor(2);

        driver.findElement(By.xpath(" //input[@name=\"cusid\"]")).sendKeys("1");
        driver.findElement(By.xpath(" //input[@name=\"submit\"]")).click();

        String popup1 = driver.switchTo().alert().getText();
        LOGGER.info(popup1);

        driver.switchTo().alert().accept();
        sleepFor(2);

        String popup2 = driver.switchTo().alert().getText();
        LOGGER.info(popup2);

        driver.switchTo().alert().accept();

        sleepFor(5);
        closeDriver();
    }


}

