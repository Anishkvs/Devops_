package com.stc.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class STCKw {
	public static void main(String[] args) throws InterruptedException {
		
		EdgeOptions opt = new EdgeOptions();
		opt.addArguments("--guest");
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver(opt);
		driver.get("https://www.stc.com.kw/en");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
//Wait
		WebElement numberBox = driver.findElement(By.xpath("//input[@name='quickpay-number']"));
		wait.until(ExpectedConditions.visibilityOf(numberBox));
		//Thread.sleep(5000);
		
		String number = "51195933";
		driver.findElement(By.xpath("//input[@name='quickpay-number']")).sendKeys(number);
		driver.findElement(By.xpath("//div[@class='StcEmbedQuickpay-styles__buttonsWrapper__1EG8y']/button[1]")).click();
		
//Wait		
		WebElement enterValue = driver.findElement(By.xpath("//label[@for='username']/*[@name='username']"));
		wait.until(ExpectedConditions.visibilityOf(enterValue));
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//label[@for='username']/*[@name='username']")).sendKeys("2");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[contains(text(),'Continue')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(text(),'Confirm')]")).click();
		Thread.sleep(5000);
//Wait		
		wait.until(ExpectedConditions.titleContains("KNET Payment Page"));
			
		String expectedTitle = driver.getTitle();
		String actualTitle = "KNET Payment Page";
		
		Assert.assertEquals(expectedTitle, actualTitle);
		System.out.println("Mobile Number is: "+number);
		System.out.println(expectedTitle+": is successfully navigated");

	}
}
