package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Utility {
	
	ChromeDriver driver;
	ChromeOptions opt;
	
	public void doActiuvity() throws InterruptedException {

		boolean nextPage = driver.findElements(By.xpath("//a[@class='next ajax-page']")).isEmpty();
		System.out.println("1st == "+nextPage);
		
		while (nextPage == false) { // True == Stop
			System.out.println("2nd  == "+nextPage);
			int totalBusiness = driver.findElements(By.xpath("//a[@class='business-name']")).size();
			
			
			ArrayList<String> links = new ArrayList<String>();
			for (int i = 1; i <= totalBusiness; i++) {
				
				String link = driver.findElement(By.xpath("(//a[@class='business-name'])["+i+"]")).getAttribute("href");
				System.out.println(link);
				links.add(link);
			}
			
			for (int i = 0; i < links.size(); i++) {
				
				driver.switchTo().newWindow(WindowType.TAB);
				Set<String> winHan = driver.getWindowHandles();
				List<String> is = new ArrayList<String>(winHan);
				driver.get(links.get(i));
				
				String name = driver.findElement(By.xpath("//h1[@class='dockable business-name']")).getText();
				System.out.println("Buiness name: "+name);
				
				String phone = driver.findElement(By.xpath("//a[contains(@href,'tel:')]")).getText();
				System.out.println("Phone Number is: "+phone);
				
				driver.close();
				driver.switchTo().window(is.get(0));
			}
			
			
			
			
			
			
			nextPage = driver.findElements(By.xpath("//a[@class='next ajax-page']")).isEmpty();
			System.out.println("After Next Page Check:   "+nextPage);
			
			try {
				driver.findElement(By.xpath("//a[@class='next ajax-page']")).click();
				Thread.sleep(5000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
	}
	
	
	public void setup() {
		System.out.println("I setup");
		
		opt = new ChromeOptions();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.yellowpages.com/search?search_terms=gun+shop&geo_location_terms=Fresno%2C+CA");
		
		
		
	}

}
