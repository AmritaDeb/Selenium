package script;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import generic.WebGeneric;
import page.LoginPage;

public class GmailTC1 {
	
	static{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}

	@Test
	public void testGmailTC1(){
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.gmail.com");
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName("amritadebbarman@gmail.com");
		lp.clickNext();
		lp.setPassword("161amrita2541");
		lp.clickNext();
		
		WebGeneric.verifyPageIsDisplayed(driver,10,"inbox");
		
		WebElement inbox = driver.findElement(By.partialLinkText("Inbox"));
		Actions actions = new Actions(driver);
		actions.moveToElement(inbox).perform();
		//driver.close();
	}
}