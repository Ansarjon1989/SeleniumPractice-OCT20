package com.peoplentech.seleniumpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium3 extends TestBase {


   @Test

   public static void validateUserCanTypeOnSearchBar(){


       setupDriver();
       navigateToURL("https://www.ebay.com");
       driver.findElement(By.xpath("//input[@id='gh-ac']")).click();

       sleepFor(3);
       closeDriver();
   }


   @Test
    public static void validateUserCanTypeInSearchBarAndClickInSearchButton(){
       setupDriver();
       navigateToURL("https://www.ebay.com");

       driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("Java Books");
       sleepFor(3);

       List<WebElement> dropDown = driver.findElements(By.xpath("//select[@id='gh-cat']/option"));
       System.out.println(dropDown.size());
       dropDown.get(4).click();

       sleepFor(3);

       driver.findElement(By.xpath("//input[@id='gh-btn']")).click();

       sleepFor(5);
       closeDriver();

   }

   @Test
    public static void validateJavaBooksString(){

       setupDriver();
       navigateToURL("https://www.ebay.com");

       driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("Java Books");
       driver.findElement(By.xpath("//input[@id='gh-btn']")).click();


       WebElement element = driver.findElement(By.xpath("//span[text()='Java Books']"));
       String actualText = element.getText();

       Assert.assertEquals(actualText, "Java Books");

       sleepFor(5);
       closeDriver();
   }


   @Test
    public static void validateSignInAndRegisterButtons(){
       setupDriver();
       navigateToURL("https://www.ebay.com");

       driver.findElement(By.xpath("(//a[text()='Sign in'])[1]")).click();

       sleepFor(3);
       closeDriver();

   }

}
