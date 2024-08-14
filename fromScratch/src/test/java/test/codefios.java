package test;

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

public class codefios {

	public WebDriver driver;
	
	By USER_NAME_FIELD = By.xpath("//input[@id='user_name']");
	By PASSWORD_FIELD = By.xpath("//input[@id='password']");
	By LOGIN_BUTTON_FIELD = By.xpath("//button[@id='login_submit']");
	By CUSTOMERS_FIELD = By.xpath("//span[text()='Customers']");
	By ADD_CUSTOMERS_FIELD = By.xpath("//span[text()='Add Customer']");
	By FULL_NAME_FIELD = By.xpath("//input[@class='form-control name ']");
	By DASHBOARD_FIELD = By.xpath("//strong[text()='Dashboard']");
	By ADD_CUSTOMER_DROPDOWN_FIELD = By.xpath("//select[@name='company_name']");
	By EMAIL_FIELD = By.xpath("//input[@class='form-control email ']");
	By PHONE_FIELD = By.xpath("//input[@class='form-control phone ']");
	By CITY_FIELD = By.xpath("//input[@name='city']");
	By ADDRESS_FIELD = By.xpath("//input[@name='address']");
	By ZIP_CODE_FIELD = By.xpath("//input[@name='address']");
	By COUNTRY_FIELD = By.xpath("//select[@name='country']");
	By GROUP_FIELD = By.xpath("//select[@id='customer_group']");
	By ADD_CUSTOMER_BUTTON_FIELD = By.xpath("//BUTTON[@id='save_btn']");
	
	
	
	
	
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://codefios.com/ebilling/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void loginTest() {
		driver.findElement(USER_NAME_FIELD).sendKeys("demo@codefios.com");
		driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
		driver.findElement(LOGIN_BUTTON_FIELD).click();
	}
	@Test
	public void homework() throws InterruptedException {
		loginTest();
		
		Assert.assertEquals("page not found", "Dashboard", driver.findElement(DASHBOARD_FIELD).getText());
		
		driver.findElement(CUSTOMERS_FIELD).click();
		driver.findElement(ADD_CUSTOMERS_FIELD).click();
		
		Assert.assertEquals("page not found", "Manage Client", driver.getTitle());
		
		driver.findElement(FULL_NAME_FIELD).sendKeys("Usama Malik");
		
		WebElement ADD_CUSTOMER_DROPDOWN_ELEMENT = driver.findElement(ADD_CUSTOMER_DROPDOWN_FIELD);
		Select sel = new Select(ADD_CUSTOMER_DROPDOWN_ELEMENT);
		sel.selectByVisibleText("Dream Team");
		
		driver.findElement(EMAIL_FIELD).sendKeys("malik@yahoo.com");
		driver.findElement(PHONE_FIELD).sendKeys("9724102478");
		driver.findElement(ADDRESS_FIELD).sendKeys("123 Fake St.");
		driver.findElement(CITY_FIELD).sendKeys("Austin");
		driver.findElement(ZIP_CODE_FIELD).sendKeys("73301");
		
		WebElement COUNTRY_ELEMENT = driver.findElement(COUNTRY_FIELD);
		Select country = new Select(COUNTRY_ELEMENT);
		country.selectByVisibleText("Afghanistan        ");
		
		WebElement GROUP_ELEMENT = driver.findElement(GROUP_FIELD);
		Select group = new Select(GROUP_ELEMENT);
		group.selectByVisibleText("SDLC");
		
		driver.findElement(ADD_CUSTOMER_BUTTON_FIELD).click();
		
		Thread.sleep(2000);
		
		
		
		
		
		
	}
	@After
	public void teardown() {
		driver.close();
	}
}
