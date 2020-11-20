package com.uber;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SeleniumAmazon extends TestBase {

    @Test
    public static void validateSignUpButton(){

        setupDriver();
        navigateToURL("https://www.uber.com");


        driver.findElement(By.xpath("//button[text()='Sign up']")).click();
        sleepFor(3);

        driver.findElement(By.xpath("//h2[text()='Sign up to drive']")).click();
        sleepFor(3);

        driver.findElement(By.xpath("(//input[@type='email'])[2]")).sendKeys("ansarjon1989@gmail.com");
        sleepFor(2);

        driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("Ansar");
        sleepFor(2);

        driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Rakhmankulov");

        driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("+13472797267");
        sleepFor(2);

        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("abcd1234");

        driver.findElement(By.xpath("//input[@placeholder='City']")).sendKeys("New York City, NY, USA");

        driver.findElement(By.xpath("")).sendKeys("");






        sleepFor(5);
        closeDriver();
    }
}
