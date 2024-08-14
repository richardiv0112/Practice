package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnKeyBoardEvent {
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
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://codefios.com/ebilling/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void keyboardEventTest() {
		driver.findElement(USER_NAME_FIELD).sendKeys("demo@codefios.com");
		driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
		
		//this will help you access any KEY on the keyboard
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();

	}
}
