package test;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class Codefios1 {

	public WebDriver driver;
	
	By LOGIN_BUTTON_FIELD = By.xpath("//button");
	By USER_NAME_FIELD = By.xpath("//input[@id='user_name']");
	By PASSWORD_FIELD = By.xpath("//input[@id='password']");
	By LOGIN_FIELD = By.xpath("//*[@id='login_submit']");
	By DASHBOARD_HEADER_FIELD = By.xpath("//strong[text()='Dashboard']");
	By COMPANY_LIST_HEADER_FIELD = By.xpath("//strong[text()='Company List']");
	By ADD_CUSTOMER_TITLE_FIELD = By.xpath("//strong[text()='New Customer']");
	By CUSTOMERS_FIELD = By.xpath("/html/body/div[1]/aside[1]/div/nav/ul[2]/li[2]/a/span");
	By ADD_CUSTOMER_FIELD = By.xpath("//*[@id=\"customers\"]/li[2]/a/span");
	By FULL_NAME_FIELD = By.xpath("//*[@id=\"general_compnay\"]/div[1]/div/input");
	By COMPANY_DROPDOWN_FIELD = By.xpath("//select[@name='company_name']");
	
	@Before
	public void init() {
		System.getProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://codefios.com/ebilling/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void loginTest() {
		driver.findElement(USER_NAME_FIELD).sendKeys("demo@codefios.com");
		driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
		driver.findElement(LOGIN_BUTTON_FIELD).click();
		
		Assert.assertEquals("page not found", "Codefios", driver.getTitle());
	}
	
	@Test
	public void iframeTest() {
		loginTest();
		
		driver.switchTo().frame("advertisement");
		driver.findElement(By.xpath("//div[@id='ad_three']")).click();
		
		driver.switchTo().frame("portals");
		driver.findElement(By.xpath("//div[@id='portal_four']")).click();
		
		driver.switchTo().parentFrame();
		driver.findElement(By.xpath("//div[@id='ad_three']")).click();
		
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("/html/body/div[1]/aside[1]/div/nav/ul[2]/li[5]/a/span")).click();
		
		Assert.assertEquals("page not found", "Company List", driver.getTitle());
	}
	
	@Test
	public void dropdownTest() {
		loginTest();
		
		driver.findElement(CUSTOMERS_FIELD).click();
		driver.findElement(ADD_CUSTOMER_FIELD).click();
		
		WebElement COMPANY_DROPDOWN_ELEMENT = driver.findElement(COMPANY_DROPDOWN_FIELD);
		Select dropdown = new Select(COMPANY_DROPDOWN_ELEMENT);
		dropdown.selectByVisibleText("0629Adnan");
		
		WebElement COUNTRY_DROPDOWN_ELEMENT = driver.findElement(By.xpath("//select[@name='country']"));
		Select country = new Select(COUNTRY_DROPDOWN_ELEMENT);
		country.selectByVisibleText("Afghanistan");
		
		
		
	}
	
	@Test
	public void alertTest() throws InterruptedException {
		driver.findElement(LOGIN_BUTTON_FIELD).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		
		loginTest();
	}
	
	@Test
	public void mouseHoverTest() throws InterruptedException {
		loginTest();
		
		Actions hover = new Actions(driver);
		
		hover.moveToElement(driver.findElement(CUSTOMERS_FIELD)).build().perform();;
		Thread.sleep(2000);
		hover.moveToElement(driver.findElement(DASHBOARD_HEADER_FIELD)).build().perform();
		Thread.sleep(2000);
	}
	@Test
	public void scrollTest() {
		loginTest();
		
		JavascriptExecutor scroll = (JavascriptExecutor) driver;
		
		scroll.executeScript("scroll(0,8000)");
	}
	@After
	public void teardown() {
		driver.close();
		driver.quit();
	}
}
