package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnMouseHover {

	public WebDriver driver;
	
	By COMPUTERS_ACCESSORIES_FIELD = By.xpath("//span[text()='Computers & Accessories']");
	By COMPUTER_MONITORS_FIELD = By.xpath("//button[text()='Computer Monitors']");
	By VIEW_ALL_COMPUTER_MONITORS_FIELD = By.xpath("//a[text()='View All Computer Monitors']");
	
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
	public void mouseHoverTest() throws InterruptedException {
		Actions action = new Actions(driver);
		//Need to know how .build().perform(); works in an interview
		action.moveToElement(driver.findElement(COMPUTERS_ACCESSORIES_FIELD)).build().perform();
		action.moveToElement(driver.findElement(COMPUTER_MONITORS_FIELD)).build().perform();
		driver.findElement(VIEW_ALL_COMPUTER_MONITORS_FIELD).click();
	}
}
