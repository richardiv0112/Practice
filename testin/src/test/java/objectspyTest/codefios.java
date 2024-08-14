package objectspyTest;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class codefios {

	public WebDriver driver;
	
	By LOGIN_BUTTON_FIELD = By.xpath("//button");
	By USER_NAME_FIELD = By.xpath("//input[@id='user_name']");
	By PASSWORD_FIELD = By.xpath("//input[@id='password']");
	By LOGIN_FIELD = By.xpath("//*[@id='login_submit']");
	By DASHBOARD_HEADER_FIELD = By.xpath("html/body/div[1]/section/div/div[2]/div/div/header/div/strong");
	By ADD_CUSTOMER_TITLE_FIELD = By.xpath("//strong[text()='New Customer']");
	By CUSTOMERS_FIELD = By.xpath("/html/body/div[1]/aside[1]/div/nav/ul[2]/li[2]/a/span");
	By ADD_CUSTOMER_FIELD = By.xpath("//*[@id=\"customers\"]/li[2]/a/span");
	By FULL_NAME_FIELD = By.xpath("//*[@id=\"general_compnay\"]/div[1]/div/input");
	By COMPANY_DROPDOWN_FIELD = By.xpath("//select[@name='company_name']");
	
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
	public void login(){
		driver.findElement(USER_NAME_FIELD).sendKeys("demo@codefios.com");
		driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
		driver.findElement(LOGIN_BUTTON_FIELD).click();
	}
//	@Test
	public void pageVerification() {
		WebElement USER_NAME_ELEMENT = driver.findElement(By.xpath("//input[@id='user_name']"));
		WebElement PASSWORD_ELEMENT = driver.findElement(By.xpath("//input[@id='password']"));
		WebElement SIGN_IN_ELEMENT = driver.findElement(By.xpath("//*[@id='login_submit']"));
		
		USER_NAME_ELEMENT.sendKeys("demo@codefios.com");
		PASSWORD_ELEMENT.sendKeys("abc123");
		SIGN_IN_ELEMENT.click();
		
		By DISPLAY_TEXT_FIELD = By.xpath("html/body/div[1]/section/div/div[2]/div/div/header/div/strong");
		
		String displayHomepageText = driver.findElement(DISPLAY_TEXT_FIELD).getText();
		String displayTitle = driver.getTitle();
		
		Assert.assertEquals(displayTitle, "Codefios", "page not found");
	}
//	@Test
	public void alertTest() throws InterruptedException {
		driver.findElement(LOGIN_BUTTON_FIELD).click();
//		Thread.sleep(2000);
		driver.switchTo().alert().accept();
	}
	@Test
	public void learnIFrameTest() throws InterruptedException {
		login();
		driver.switchTo().frame("advertisement");
		driver.findElement(By.xpath("//div[@id='ad_one']")).click();
		Thread.sleep(2000);
//		Dont know how to get the driver onto other tabs
//		String ypfTitle = driver.findElement(By.xpath("//a[text()='Your Pet Fish']")).getText();
//		Assert.assertEquals(ypfTitle, "Your Pet Fish | Facebook", "page not found");
	}
	
	@After
	public void teardown() {
		driver.close();
	}
}
