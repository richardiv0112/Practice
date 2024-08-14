package variousConcepts;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnWindowHandle {

	public WebDriver driver;

	By SEARCH_BAR_FIELD = By.xpath("//*[@id='ybar-sbq']");
	By SEARCH_BUTTON_FIELD = By.xpath("//*[@id='ybar-search']");
	By SELENIUM_LINK_FIELD = By.xpath("//*[@id='web']/ol/li[3]/div/div[1]/h3/a");
	

	@Before
	public void init() {
		System.getProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.yahoo.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void keyboardEventTest() throws InterruptedException {
		driver.findElement(SEARCH_BAR_FIELD).sendKeys("selenium");
		driver.findElement(SEARCH_BUTTON_FIELD).click();
		String handle1 = driver.getWindowHandle();
		
//		driver.getWindowHandle()
		
		Thread.sleep(2000);
		Set<String> handles = driver.getWindowHandles();
//		System.out.println(handles);
		
		for (String str : handles) {
//			System.out.println(str);
			driver.switchTo().window(str);
		}
		
		driver.findElement(SELENIUM_LINK_FIELD).click();
		
		Thread.sleep(2000);
		Set<String> handles2 = driver.getWindowHandles();
		for (String str : handles2) {
			System.out.println(str);
			driver.switchTo().window(str);
		}
		
		driver.switchTo().window(handle1);
		System.out.println(driver.getTitle());
		
//		driver.findElement(SELENIUM_LINK_FIELD).click();
		
		

	}
}
