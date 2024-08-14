package objectspyTest;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import junit.framework.Assert;

public class Dell {

	public WebDriver driver;
	
	By IT_INFRASTRUCTURE_FIELD = By.xpath("//span[text()='IT Infrastructure']");
	By INDUSTRY_FIELD = By.xpath("//button[text()='Industry']");
	By FINANCIAL_FIELD = By.xpath("//a[text()='Financial']");
	By COMPUTER_AND_ACCESSORIES_FIELD = By.xpath("//span[text()='Computers & Accessories']");
	By LAPTOPS_FIELD = By.xpath("//button[text()='Laptops']");
	By XPS_LAPTOPS_FIELD = By.xpath("//a[text()='XPS Laptops']");
	
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.dell.com/en-us");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void mouseHover() throws InterruptedException {
		Actions hover = new Actions(driver);
		hover.moveToElement(driver.findElement(IT_INFRASTRUCTURE_FIELD)).build().perform();
		hover.moveToElement(driver.findElement(INDUSTRY_FIELD)).build().perform();
		driver.findElement(FINANCIAL_FIELD).click();
		
		Assert.assertEquals("page not found", "Transforming the Financial Services Industry | Dell USA", driver.getTitle());
		
		hover.moveToElement(driver.findElement(COMPUTER_AND_ACCESSORIES_FIELD)).build().perform();
		hover.moveToElement(driver.findElement(LAPTOPS_FIELD)).build().perform();
		driver.findElement(XPS_LAPTOPS_FIELD).click();
		
		Thread.sleep(2000);
	}
}
