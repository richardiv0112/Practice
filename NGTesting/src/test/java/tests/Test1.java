package tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
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
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	@BeforeMethod
	public void init() {
		if(browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("Edge")){
			System.setProperty("webdriver.edge.driver", "driver/msedgedriver.exe");
			driver = new EdgeDriver();
		} else {
			System.out.println("insert valid browser");
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
		Assert.assertEquals(driver.findElement(DASHBOARD_HEADER_FIELD).getText(), "Dashboard", "page not found");
		
		

	}
	@Test
	public void keyboardEvent() {
		driver.findElement(USER_NAME_FIELD).sendKeys(userName);
		driver.findElement(PASSWORD_FIELD).sendKeys(password);
		
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
	}
	
	
	
}
