package variousConcepts;

import java.util.concurrent.TimeUnit;


import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class LearnDropdown {

	public WebDriver driver;
	
	
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://codefios.com/ebilling/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void loginTest() {
//		WebElement USER_NAME_ELEMENT = driver.findElement(By.xpath("//input[@id='user_name']"));
//		WebElement PASSWORD_ELEMENT = driver.findElement(By.xpath("//input[@id='password']"));
//		WebElement SIGN_IN_ELEMENT = driver.findElement(By.xpath("//*[@id='login_submit']"));
		
		By USER_NAME_FIELD = By.xpath("//input[@id='user_name']");
		By PASSWORD_FIELD = By.xpath("//input[@id='password']");
		By LOGIN_FIELD = By.xpath("//*[@id='login_submit']");
		By DASHBOARD_HEADER_FIELD = By.xpath("html/body/div[1]/section/div/div[2]/div/div/header/div/strong");
		
		//Have a choice between using FIELD or ELEMENT
		//Using field for this session
		driver.findElement(USER_NAME_FIELD).sendKeys("demo@codefios.com");
		driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
		driver.findElement(LOGIN_FIELD).click();
		
		//An error is popping up at this line NoSuchElementException
		//To get around this use a string variable
//		boolean homepageDisplayStatus = driver.findElement(DASHBOARD_HEADER_FIELD).isDisplayed();
		String homepageDisplayText = driver.findElement(DASHBOARD_HEADER_FIELD).getText();
		
		//Assert.assertEquals("page not found", "Dashboard", homepageDisplayText);
		
		String homepageTitle = driver.getTitle();
		Assert.assertEquals("page not found", "Codefios", homepageTitle);
		
		
		
}
}

