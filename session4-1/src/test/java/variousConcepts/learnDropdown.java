package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class learnDropdown {
	public WebDriver driver;
	
	
	
	public By USER_NAME_FIELD = By.xpath("//input[@id='user_name']");
	public By PASSWORD_FIELD = By.xpath("//input[@id='password']");
	public By LOGIN_FIELD = By.xpath("//*[@id='login_submit']");
	public By DASHBOARD_HEADER_FIELD = By.xpath("html/body/div[1]/section/div/div[2]/div/div/header/div/strong");
	public By ADD_CUSTOMER_TITLE_FIELD = By.xpath("//strong[text()='New Customer']");
	public By CUSTOMERS_FIELD = By.xpath("/html/body/div[1]/aside[1]/div/nav/ul[2]/li[2]/a/span");
	public By ADD_CUSTOMER_FIELD = By.xpath("//*[@id=\"customers\"]/li[2]/a/span");
	public By FULL_NAME_FIELD = By.xpath("//*[@id=\"general_compnay\"]/div[1]/div/input");
	public By COMPANY_DROPDOWN_FIELD = By.xpath("//select[@name='company_name']");
	
	

	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://codefios.com/ebilling/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	//@Test
	public void loginTest() {

//		WebElement USER_NAME_ELEMENT = driver.findElement(By.xpath("//input[@id='user_name']"));
//		WebElement PASSWORD_ELEMENT = driver.findElement(By.xpath("//input[@id='password']"));
//		WebElement SIGN_IN_ELEMENT = driver.findElement(By.xpath("//*[@id='login_submit']"));

		//Helpful to make your fields global variables if you are going to use them for multiple tests		
//		By USER_NAME_FIELD = By.xpath("//input[@id='user_name']");
//		By PASSWORD_FIELD = By.xpath("//input[@id='password']");
//		By LOGIN_FIELD = By.xpath("//*[@id='login_submit']");
//		By DASHBOARD_HEADER_FIELD = By.xpath("html/body/div[1]/section/div/div[2]/div/div/header/div/strong");

		// Have a choice between using FIELD or ELEMENT
		// Using field for this session
		driver.findElement(USER_NAME_FIELD).sendKeys("demo@codefios.com");
		driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
		driver.findElement(LOGIN_FIELD).click();

		// An error is popping up at this line NoSuchElementException
		// To get around this use a string variable
//		boolean homepageDisplayStatus = driver.findElement(DASHBOARD_HEADER_FIELD).isDisplayed();
		String homepageDisplayText = driver.findElement(DASHBOARD_HEADER_FIELD).getText();

		// Assert.assertEquals("page not found", "Dashboard", homepageDisplayText);

		// Don't actually save the String just use the latter half of the code
		String homepageTitle = driver.getTitle();
		Assert.assertEquals("page not found", "Codefios", driver.getTitle());

	}
	
	@Test
	public void testDropdown() {

//		Instead of typing out ceratin steps every time call on the method		
//		driver.findElement(USER_NAME_FIELD).sendKeys("demo@codefios.com");
//		driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
//		driver.findElement(LOGIN_FIELD).click();
//		Assert.assertEquals("page not found", "Codefios", driver.getTitle());
		
		loginTest();
		driver.findElement(CUSTOMERS_FIELD).click();
		driver.findElement(ADD_CUSTOMER_FIELD).click();
		
		//Assert.assertEquals("PAGE NOT FOUND", "Manage Client", driver.getTitle());
		Assert.assertEquals("PAGE NOT FOUND", "New Customer", driver.findElement(ADD_CUSTOMER_TITLE_FIELD).getText());
		
		driver.findElement(FULL_NAME_FIELD).sendKeys("selenium");
		
		//for dropdowns identify the webelement with the select tag
		//call the obj using sel.
		WebElement COMPANY_DROPDOWN_ELEMENT = driver.findElement(COMPANY_DROPDOWN_FIELD);
		Select sel = new Select(COMPANY_DROPDOWN_ELEMENT);
		sel.selectByVisibleText("Techfios");
	}
	@After
	public void teardown() {
		driver.close();
		driver.quit();
	}
}
