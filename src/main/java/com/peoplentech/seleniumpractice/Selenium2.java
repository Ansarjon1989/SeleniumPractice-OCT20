package com.peoplentech.seleniumpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium2 {


    private static WebDriver driver;

    public static void main(String[] args) {
        userShouldBeAbleToClickOnSignInAndRegister();

    }
    //     //a[text()='Sign in']
    //      //a[text()='register']
    //      //tagName[text()='______']
    //      (//a[text()='Sign in'])[1]


    public static void userShouldBeAbleToClickOnSignInAndRegister() {
        //open the browser
        setupDriver();

        // navigate to the url
        navigateToURL("https://www.ebay.com");

        //wait 2 seconds
        sleepFor(2);

        //click on sign in
        clickOnElement("//a[text()='Sign in'])[1]");

        //wait 2 seconds
        sleepFor(2);

        //navigate back
        navigateBack();

        //wait 2 seconds
        sleepFor(2);

        //click on register
        clickOnElement("//a[text()='register']");

        //wait 2 seconds
        sleepFor(2);

        //close the browser
        closeDriver();
    }

    public static void navigateBack() {
        driver.navigate().back();
    }

    public static void clickOnElement(String element) {
        driver.findElement(By.xpath(element)).click();
    }

    public static void setupDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
    }

    public static void navigateToURL(String url) {
        driver.get(url);
    }

    public static void sleepFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void closeDriver() {
        driver.close();
    }


}
