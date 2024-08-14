package testNG;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test1 {

	public WebDriver driver;

	String browser;
	String url;
	String userName;
	String password;
	
	public By USER_NAME_FIELD = By.xpath("//input[@id='user_name']");
	public By PASSWORD_FIELD = By.xpath("//input[@id='password']");
	public By LOGIN_FIELD = By.xpath("//*[@id='login_submit']");
	public By TITLE_FIELD = By.xpath("//title[text()='Codefios']");
	public By DASHBOARD_HEADER_FIELD = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/header/div/strong");
	public By ADD_CUSTOMER_TITLE_FIELD = By.xpath("//strong[text()='New Customer']");
	public By CUSTOMERS_FIELD = By.xpath("/html/body/div[1]/aside[1]/div/nav/ul[2]/li[2]/a/span");
	public By ADD_CUSTOMER_FIELD = By.xpath("//*[@id=\"customers\"]/li[2]/a/span");
	public By FULL_NAME_FIELD = By.xpath("//*[@id=\"general_compnay\"]/div[1]/div/input");
	public By COMPANY_DROPDOWN_FIELD = By.xpath("//select[@name='company_name']");

	@BeforeClass
	public void readConfig() {
		try {
			InputStream input = new FileInputStream("src/main/java/config/config.properties");

			Properties prop = new Properties();
			prop.load(input);

			browser = prop.getProperty("browser");
			url = prop.getProperty("url");
			userName = prop.getProperty("userName");
			password = prop.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	@BeforeMethod
	public void init() {
		if(browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.driver.chrome", "driver/chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.driver.edge", "driver/msedgedriver.exe");
			driver = new EdgeDriver();
		}else {
			System.out.println("enter valid browser");
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void loginTest() {
		driver.findElement(USER_NAME_FIELD).sendKeys(userName);
		driver.findElement(PASSWORD_FIELD).sendKeys(password);
		driver.findElement(LOGIN_FIELD).click();
	}
	
	@Test
	public void windowHandles() throws InterruptedException {
		loginTest();
		
		String mainHandle = driver.getWindowHandle();
		
		driver.switchTo().frame("advertisement");
		driver.switchTo().frame("portals");
		driver.findElement(By.xpath("//div[@id='portal_one']")).click();
		
			
		Set<String> handles = driver.getWindowHandles();
		
		for (String str : handles) {
			driver.switchTo().window(str);
		}
		
		driver.findElement(By.xpath("//li[@id='pg946302974818680048'][@class='wsite-menu-item-wrap      wsite-nav-3']")).click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JavascriptExecutor scroll = (JavascriptExecutor) driver;
		
		scroll.executeScript("scroll(0,8000)");
		
		Thread.sleep(2000);
		
		driver.switchTo().window(mainHandle);
		
		driver.findElement(By.xpath("//span[text()='List Accounts']")).click();
		
		Thread.sleep(2000);
		Assert.assertEquals(driver.getTitle(), "Manage Account", "Page not found");
	}
	
	@Test
	public void dropdownTest() throws InterruptedException {
		loginTest();
		
		driver.findElement(CUSTOMERS_FIELD).click();
		driver.findElement(ADD_CUSTOMER_FIELD).click();
		
		Assert.assertEquals(driver.getTitle(), "Manage Client", "Page not found");
		
		WebElement COMPANY_DROPDOWN_ELEMENT = driver.findElement(COMPANY_DROPDOWN_FIELD);
		Select companyDropdown = new Select(COMPANY_DROPDOWN_ELEMENT);
		companyDropdown.selectByVisibleText("ARIENNE");
		
		Thread.sleep(2000);
		
	}
		
	
	
	@AfterMethod
	public void teardown() {
		driver.close();
		driver.quit();
	}

}
