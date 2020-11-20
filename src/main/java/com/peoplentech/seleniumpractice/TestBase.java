package com.peoplentech.seleniumpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class TestBase {


    public static WebDriver driver;

    public static void navigateBack() {
        driver.navigate().back();
    }

    public static void clickOnElement(String element) {
        driver.findElement(By.xpath(element)).click();
    }

    public static void setupDriver(String browserName) { // bu methodni parametrladim shu name bilan va if ni ishlatdim.
        // Bu ikkala browserni ishlatish ilojini beradi

        if (browserName.equalsIgnoreCase("firefox")) {
            // Web Driver for FireFox
            System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
            driver = new FirefoxDriver();
        }else {
            // Web Driver for Chrome
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
            driver = new ChromeDriver();
        }

        //bu code Browserni ochilish vaqtini belgilash uchun kerak boladi. masalan ayrim pytlarda Browser sekin
        // yoki uzoq vaqt ochilsa shu kodni ishlatib ichida nechi sekunda ochilishini buyurish mumnkin.
        // Browser properli ochilsa keyingi testga otadi. kutib utirmaydi.
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize(); // bu kod ekranni katta qilib korsatadi maximize

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
        driver.quit(); // bu kod Browserni umuman yopadi. ekranni pastidan.

        // driver.close();// bu kod browserni yopadi
    }


}
