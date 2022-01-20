package week4.day1.assignment;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {
	


	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver=new EdgeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		
       driver.findElement(By.xpath("//input[@id='partyIdFrom']/following-sibling::a")).click();
       
       Set<String> window=driver.getWindowHandles();
       List<String> nextwindows=new ArrayList<String>(window);
       
       driver.switchTo().window(nextwindows.get(1));
       Thread.sleep(2000);
       
       driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[1]")).click();
      
       driver.switchTo().window(nextwindows.get(0));
       
       driver.findElement(By.xpath("//input[@id='partyIdTo']/following-sibling::a")).click();
       
       Thread.sleep(4000);
       
       Set<String> window1=driver.getWindowHandles();
       List<String> nextwindows1=new ArrayList<String>(window1);
       
       driver.switchTo().window(nextwindows1.get(1));
       Thread.sleep(5000);
       driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/b[1]")).click();
       Thread.sleep(3000);

       driver.switchTo().window(nextwindows1.get(0));
       
       driver.findElement(By.linkText("Merge")).click();
       
       
    

	}}

