package week4.day1.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver=new EdgeDriver();
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		String parentwindow=driver.getWindowHandle();
		
		String parentTitle=driver.getTitle();
		System.out.println(parentTitle);
		
		driver.findElement(By.id("home")).click();
		
		Set<String> WindowHandles=driver.getWindowHandles();
		List<String> WindowList=new ArrayList<String>(WindowHandles);
		
		driver.switchTo().window(WindowList.get(1));
		
		driver.findElement(By.xpath("//img[@class='wp-categories-icon svg-image']")).click();
		driver.close();
		
		driver.switchTo().window(parentwindow);
		
		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		
		WindowList = new ArrayList<String>(driver.getWindowHandles());
		
	
		
		System.out.println("Multiple Window Handles Size: "+WindowList.size());
	
		driver.switchTo().window(WindowList.get(1));
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.close();
		
		driver.switchTo().window(WindowList.get(2));
		Thread.sleep(5000);
		driver.close();
		
	
		driver.switchTo().window(WindowList.get(0));
		
		driver.quit();
		
		
		
		
		
		
		
		
		
	}

}
