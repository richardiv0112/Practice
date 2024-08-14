package objectspyTest;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {

	public WebDriver driver;

	@Before
	public void init() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://objectspy.space/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void webTest() throws InterruptedException {
		//Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("Richard");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Bridgeman");
		driver.findElement(By.cssSelector("input#sex-0")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='sex-1']")).click();
		//driver.findElement(By.cssSelector("input#datepicker")).click();
		driver.findElement(By.xpath("//input[@id='profession-0']")).click();
		driver.findElement(By.cssSelector("input#profession-1")).click();
		driver.findElement(By.xpath("//input[@id='photo']")).sendKeys("C:\\Users\\richa\\Documents\\College\\Richard Bridgeman Experimental Lab.pdf");
		driver.findElement(By.cssSelector("a[href$='http://objectspy.com/os_api_prod/']")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		
	}
	
	@After
	public void teardown() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}
}
