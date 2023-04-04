package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Utility {
	
	ChromeDriver driver;
	ChromeOptions opt;
	
	public void doActiuvity() throws InterruptedException {
		
		Thread.sleep(3000);
		
		int totalPeople = driver.findElements(By.xpath("(//a[@class='CoveoResultLink'])")).size();
		int hasNext =5;
		int x = 0;
		do {
			
			x++;
			
			for (int i = 1; i <= totalPeople; i++) {
				System.out.println("Emp Number: "+ i);
				String name = driver.findElement(By.xpath("(//span[@class='CoveoFieldValue']/span)["+i+"]")).getText();
				System.out.println("Emp Name is: "+ name);
				
				String url = driver.findElement(By.xpath("(//a[@class='CoveoResultLink'])["+i+"]")).getAttribute("href");
				System.out.println("Profile Link is: "+ url);
			}
			
			driver.findElement(By.xpath("//li[contains(@class,'coveo-active')]/following-sibling::li[1]/a")).click();
			
			
		} while (hasNext != x);
		
		
		
		
		
	}
	
	
	public void setup() {
		System.out.println("I setup");
		
		opt = new ChromeOptions();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.lw.com/en/people#sort=%40peoplerankbytitle%20ascending%3B%40peoplelastname%20ascending");
		
		
		
	}

}
