/*
 * Write a code to scroll a webpage by the proper location
 * */

package automation1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test24 {
	static{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
	}

	public static void main(String[] args) throws InterruptedException {
		
		//Open chrome browser
	WebDriver driver = new ChromeDriver();
		//Enter the URL
	driver.get("https://www.actitime.com/license-agreement");
		//(type-casting)
	JavascriptExecutor j = (JavascriptExecutor) driver;
		//xpath of Miscellaneous
	String xp = "//h2[contains(text(),'Miscellaneous')]";
		//get y axis location
	int y = driver.findElement(By.xpath(xp)).getLocation().getY();
	int x = driver.findElement(By.xpath(xp)).getLocation().getX();
	
	System.out.println(y);
	System.out.println(x);
		//Scroll Down
	j.executeScript("window.scrollBy(" + x + "," + y + ")");
	
	Thread.sleep(2000);
		//Close the browser
	driver.close();
	}
}