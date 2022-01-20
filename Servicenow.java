package week4.day1.assignment;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Servicenow {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver=new EdgeDriver();
		driver.get("https://dev82417.service-now.com/");
		driver.manage().window().maximize();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Tamil@1993");
		driver.findElement(By.id("sysverb_login")).click();
		driver.findElement(By.id("filter")).sendKeys("Incident",Keys.ENTER);
		
		driver.findElement(By.xpath("((//div[text()='All'])[2])/ancestor::a")).click();
		Thread.sleep(3000);
		
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("sysverb_new")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//span[@class='icon icon-search']")).click();
		
		Set<String> windowHandles=driver.getWindowHandles();
		List<String> windows=new ArrayList<String>(windowHandles);	
		
		driver.switchTo().window(windows.get(1));
		
		driver.findElement(By.xpath("//a[@class='glide_ref_item_link']")).click();
		driver.switchTo().window(windows.get(0));
		driver.switchTo().frame("gsft_main");
		
	
		driver.findElement(By.id("lookup.incident.short_description")).click();
		
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> window2 = new ArrayList<String>(windowHandles2);
		driver.switchTo().window(window2.get(1));
		
		driver.findElement(By.xpath("//tbody[@class='list2_body']/tr[1]/td[3]/a")).click();
		driver.switchTo().window(window2.get(0));
		driver.switchTo().frame("gsft_main");
		
		//incident storing in variable
		String incnum=driver.findElement(By.id("incident.number")).getAttribute("value");
		System.out.println(incnum);
		
		driver.findElement(By.id("sysverb_insert_bottom")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		
		driver.switchTo().frame("gsft_main");
		
		driver.findElement(By.xpath("//div[@class='input-group']")).sendKeys(incnum);
		driver.findElement(By.xpath("//dic[@class='input-group']")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		String incnum1=driver.findElement(By.xpath("//tbody[@class='list2_body']/tr[1]/td[3]/a")).getText();
		System.out.println(incnum1);

		if (incnum1.equals(incnum)) {

			System.out.println("Incident created successfully");

		} else {

			System.out.println("No incident found");

		}

		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File Destination = new File("./images/incident.png");
		FileUtils.copyFile(screenshotAs, Destination);

		
	
				
	
	}}