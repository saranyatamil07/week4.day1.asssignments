package week4.day1.assignment;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver=new EdgeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		
		File source = driver.findElement(By.id("Click")).getScreenshotAs(OutputType.FILE);
		File destination = new File("./images/ClickMe1.png");
		FileUtils.copyFile(source, destination);
		
		driver.findElement(By.id("Click")).click();
		
		driver.switchTo().parentFrame();
		
		driver.switchTo().frame(1);
		driver.switchTo().frame(driver.findElement(By.id("frame2")));	
		driver.findElement(By.id("Click1")).click();
		
	
		driver.switchTo().defaultContent();
		
		
		List<WebElement> findElements = driver.findElements(By.tagName("iframe"));
		
		System.out.println("Total Number of Frames :"+findElements.size());
		
		
		
		
		
		
		

	}

}
