
/* Automate following scenario, go to UnitConverters.net website, enter 100 from textbox. 
 * get the value present in a 'to' textbox and printed
 * */

package automation1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test10 {
	static{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
	}

	public static void main(String[] args) {
		//Open chrome browser
	WebDriver driver = new ChromeDriver();
		//Enter the URL
	driver.get("https://www.unitconverters.net/");
		//find the from textfield element
	WebElement from = driver.findElement(By.name("fromVal"));
		//send the keys to the from textfield
	from.sendKeys("100");
		//find the to textfield element
	WebElement to = driver.findElement(By.name("toVal"));
		//get the value of attribute value
	String value = to.getAttribute("value");
		//print the value
	System.out.println(value);
		
		//Close the browser
	driver.close();
	}
}