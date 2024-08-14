package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearningLocators {
	
	WebDriver driver;

	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://objectspy.space/index.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void testLocator() {
		//Finding elements by Name, ID and Class
		driver.findElement(By.name("firstname")).sendKeys("kjdcwnj");
		driver.findElement(By.id("sex-1")).click();
		
		//For uploading a file use the .sendKeys(); class and upload the file path.
		//Make sure you include the extension
		//If there is no input tag on the element use the robot class (INTERVIEW QUESTION)
		driver.findElement(By.className("input-file")).sendKeys("C:\\Users\\richa\\Documents\\TechFios\\selenium\\ppt's\\2024-03-16--Session 1.pptx");
		
		//Hyperlinks find the link text from the web element and use .click(); 
//		driver.findElement(By.linkText("OS-API Product FrontEnd")).click();
		
		//Use driver.navigate().back(); to go back to a page.
		//Highly unlike;y you will use in the job but could come up during an INTERVIEW
//		driver.navigate().back();
		
		//Partial Link Text use .partialLinkText(); and do the same thing for hyperlinks
//		driver.findElement(By.partialLinkText("Backend")).click();
		
		//CSS selector
		driver.findElement(By.cssSelector("input#profession-1")).click();
		driver.findElement(By.cssSelector("input[value='Selenium Webdriver'][type='checkbox']")).click();;
		driver.findElement(By.cssSelector("a[href$='http://www.objectspy.space']")).click();
		
		//XPath
		driver.findElement(By.xpath("//input[@value='Selenium Webdriver' and @type='checkbox']")).click();
		
		//For xpath hyperlinks look for the strong tag 
		//Contains is the preferred method
		driver.findElement(By.xpath("//strong[text()='Link Test : New Page']")).click();
		driver.findElement(By.xpath("//a[contains(text(), 'OS-API Product FrontEnd')]")).click();
	}
	
//	@After
	public void teardown() {
		driver.close();
	}
}
