package hw;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CodeFiosEntry {

	WebDriver driver;
	
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://codefios.com/ebilling/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	@Test
	public void test() throws InterruptedException {
		driver.findElement(By.cssSelector("input#user_name")).sendKeys("demo@codefios.com");
		driver.findElement(By.cssSelector("input#password")).sendKeys("abc123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//span[text()='Customers']")).click();
		driver.findElement(By.xpath("//span[text()='Add Customer']")).click();
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Bobby Joel");
//		driver.findElement(By.xpath("//button[@class='btn btn-link' and @data-target='#companyModal']")).click();
//		driver.findElement(By.xpath("//input[@id='company_name']")).sendKeys("Bob construction");
//		driver.findElement(By.xpath("//input[@id='company_email']")).sendKeys("cdwnj@gmail.com");
//		driver.findElement(By.xpath("//input[@id='company_phone']")).sendKeys("(972) 654-8941");
//		driver.findElement(By.xpath("//button[@id='companyformsubmit']")).click();
//		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@class='form-control email ']")).sendKeys("wlld@gmail.com");
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("9726718740");
		driver.findElement(By.cssSelector("input[name='address']")).sendKeys("1234 Busy St.");
		driver.findElement(By.cssSelector("input[name='city']")).sendKeys("Dallas");
		driver.findElement(By.xpath("//input[@id='port']")).sendKeys("78015");
		
//		driver.findElement(By.xpath("//span[@id='select2-country-2h-container']")).click();
//		driver.findElement(By.xpath("li[@id='select2-country-2h-result-eq1i-Afghanistan']")).click();
//		
		driver.findElement(By.xpath("//button[@id='save_btn']")).click();
		
		
	}
	
	@After
	public void teardown() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
}
