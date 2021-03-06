package btm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class TestLogin2 {
	
	static{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
	}
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.actitime.com/login.do");
		LoginPage1 lp = new LoginPage1();
		
		//StaleElementReferenceException can be handled by initElements() static method of PageFactory class
		PageFactory.initElements(driver, lp);
		
		System.out.println("Click login1");		
		lp.clickLogin();
		Thread.sleep(1000);
		System.out.println("Click login2");
		lp.clickLogin();
	}

}
