
/*
	Go to plus2net.com, select the checkbox and check the textbox is enabled or not
*/

package automation1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test4 {
	static{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
	}

	public static void main(String[] args) throws InterruptedException {
		
		//Open chrome browser
	WebDriver driver = new ChromeDriver();
		//Enter the URL
	driver.get("https://www.plus2net.com/javascript_tutorial/enable-disable-demo.php");
	
		//find element of checkbox
	WebElement chbx = driver.findElement(By.xpath("//input[@type='checkbox']"));
		//click on the checkbox
	chbx.click();
	
	boolean condition1=chbx.isSelected();
	WebElement tbx = driver.findElement(By.name("other_text"));
	boolean condition2 = tbx.isEnabled();
	
	Thread.sleep(2000);
	
	if(condition1 && condition2)
	{
		System.out.println("Pass");
	}
	else
	{
		System.out.println("Fail..");
	}
		//Close the browser
	driver.close();
	}
}
