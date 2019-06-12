/*
 * 	Go to yatra.com, enter Bangalore in the hotel search field
 	get all the auto suggestions,
 	select the first 1, proceed with all the options and click on search,
 	print all the hotel's names and price
*/

package automation1;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Test72 {
	static{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
	}

	public static void main(String[] args) throws Exception {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.yatra.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//span[.='Hotels']")).click();
		driver.findElement(By.id("BE_hotel_destination_city")).sendKeys("bangalore");
		
		String xp = "//strong[text()='Bangalore']/..";
		List<WebElement> allResult = driver.findElements(By.xpath(xp));
		
		int count = allResult.size();
		System.out.println(count);
		System.out.println("~~~~~~~~~~~~~~~~~~");
		for(WebElement e:allResult){
			System.out.println(e.getText());
			
		}
		System.out.println("-------------------------------------------");
		allResult.get(0).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("04/10/2018")).click();
		driver.findElement(By.id("BE_hotel_checkout_date")).click();
		driver.findElement(By.id("09/10/2018")).click();
		driver.findElement(By.id("BE_Hotel_pax_info")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Done')]")).click();
		driver.findElement(By.id("BE_hotel_htsearch_btn")).click();
		
		driver.findElement(By.xpath("//img[contains(@ng-src,'flexistay')]")).click();
		
		Thread.sleep(9000);
		
		String name_xp = "//span[contains(text(),'Reviews')]/../../..//a";
		String price_xp = "//span[contains(text(),'For')]/following-sibling::span";
		List<WebElement> allName = driver.findElements(By.xpath(name_xp));
		List<WebElement> allPrice = driver.findElements(By.xpath(price_xp));
		//System.out.println(allPrice.getText());
		
		Thread.sleep(9000);
		
		int count_hotel = allName.size();
		System.out.println(count_hotel);
		System.out.println("~~~~~~~~~~~~~~~~~");
		
		for(int i=0; i<count_hotel; i++)
		{
			WebElement name = allName.get(i);
			WebElement price = allPrice.get(i);
			String name_text = name.getText();
			String price_text = price.getText();
			System.out.println(name_text + "-->" + price_text);
		}
		
	}
}