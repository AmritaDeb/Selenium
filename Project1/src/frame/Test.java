package frame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	static{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) throws InterruptedException{
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/QSpiders/SELENIUM/html/page1.html");
		driver.findElement(By.id("t1")).sendKeys("abcd");
		
			//by index
		driver.switchTo().frame(0);
		driver.findElement(By.id("t2")).sendKeys("A");
		Thread.sleep(2000);
		driver.switchTo().parentFrame();
		driver.findElement(By.id("t1")).clear();
		Thread.sleep(2000);
		
			//by id
		driver.switchTo().frame("f1");
		driver.findElement(By.id("t2")).sendKeys("B");
		Thread.sleep(2000);
		driver.switchTo().parentFrame();
		driver.findElement(By.id("t1")).sendKeys("D");
		Thread.sleep(2000);
		
			//by WebElement
		WebElement e = driver.findElement(By.xpath("//iframe"));
		driver.switchTo().frame(e);
		driver.findElement(By.id("t2")).sendKeys("E");
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.findElement(By.id("t1")).clear();
		Thread.sleep(2000);
		
		
	}
}