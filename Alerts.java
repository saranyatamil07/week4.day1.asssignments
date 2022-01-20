package week4.day1.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver=new EdgeDriver();
		driver.get("http://www.leafground.com/pages/Alert.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[text()='Alert Box']")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
		driver.switchTo().alert().accept();
		
		
		driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
		driver.switchTo().alert().sendKeys("xyz");
		driver.switchTo().alert().accept();
		
        driver.findElement(By.xpath("//button[text()='Sweet Alert']")).click();
		
		Thread.sleep(5000);

	
		driver.findElement(By.xpath("//button[text()='OK']")).click();

			
		
		
	}
	

}
