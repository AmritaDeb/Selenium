
/* Qs. Open the browser, enter the URL of naukri.com, 
 * 	   print the window handle of each window along with their title,
 * 	   close the window which title is "Amazon"
*/

package qsp;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoF {
	static{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
	}

	public static void main(String[] args) throws InterruptedException {
		
	WebDriver driver = new ChromeDriver();        //open chrome browser
	driver.get("http://www.naukri.com");         //Enter naukri.com
	driver.manage().window().maximize();        //maximize the browser
	
	Set<String> allWHS = driver.getWindowHandles();        //get window handles of all the browser and print the address
	for(String wh:allWHS)
	{
		System.out.println(wh);
		driver.switchTo().window(wh);
		String t = driver.getTitle();
		System.out.println(t);
		//close only one child browser
		if(t.equals("Amazon"))
		{
			driver.close();        //close all the browser
		}
	}
	}
}