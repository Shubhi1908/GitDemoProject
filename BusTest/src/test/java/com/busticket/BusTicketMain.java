package com.busticket;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BusTicketMain {
	//asda
	public static String busTime = "";
	
	public static void main(String[] args) throws InterruptedException{        
	    // declaration and instantiation of objects/variables
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\shubh\\OneDrive\\Documents\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    
	    // Launch website  
	    driver.navigate().to("https://www.busonlineticket.com/");
	    WebElement originDropdown = driver.findElement(By.xpath("//input[@id = 'txtOrigin']"));
	    originDropdown.click();
	    Thread.sleep(1000);
	    WebElement selectOrigin = driver.findElement(By.xpath("//div[text() = 'Cameron Highlands']"));
	    selectOrigin.click();
	    Thread.sleep(1000);
	    WebElement selectDestination = driver.findElement(By.xpath("//div[text() = 'Kuala Lumpur']"));
	    selectDestination.click();
	    Thread.sleep(1000);
	    WebElement nextMonthButton = driver.findElement(By.xpath("//a[contains(@class,'ui-datepicker-next')]"));
	    nextMonthButton.click();
	    String month = driver.findElement(By.xpath("//span[@class = 'ui-datepicker-month']")).getAttribute("innerText");	    
	    String year = driver.findElement(By.xpath("//span[@class = 'ui-datepicker-year']")).getAttribute("innerText");	    
	    List<WebElement> dateElement = driver.findElements(By.xpath("//a[contains(@class, 'ui-state-default')]"));
	    for(WebElement date : dateElement) {
	    	if(Integer.parseInt(date.getAttribute("innerText")) == 20){
	    		date.click();
	    		break;
	    	}
	    }
	    Thread.sleep(1000);	   
	    System.out.println("departDate -- "+20+"th "+month+" "+year);
	    
	    WebElement searchButton = driver.findElement(By.xpath("//button[@id = 'btnBusSearchNew']"));
	    searchButton.click();
	    
	    //driver.close(); 
    }
	
	
	
}
