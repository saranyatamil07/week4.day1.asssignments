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

public class ScreenShot {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver=new EdgeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		
		WebElement cliclMe=driver.findElement(By.xpath("//button[text()='Click Me']"));
		
		File source=cliclMe.getScreenshotAs(OutputType.FILE);
		File destination=new File("./images/clickme.png");
		FileUtils.copyFile(source, destination);
		
		driver.switchTo().defaultContent();
		
		List<WebElement> elements= driver.findElements(By.tagName("iframe"));
		Thread.sleep(3000);
		int size=elements.size();
		System.out.print(size);

	}

}
