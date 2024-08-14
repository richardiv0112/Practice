package objectspyTest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class cnn {

	public WebDriver driver;
	
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.cnn.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void cnn() {
		By TITLE_FIELD = By.xpath("//html[@class='userconsent-cntry-us userconsent-state-tx userconsent-reg-us']/descendant::title");
		
		driver.findElement(By.xpath("//section[@class='layout__wrapper layout-homepage__wrapper']/descendant::div[@class='container container_lead-package  lazy'][1]/descendant::a[4]")).click();
		
		boolean titleVisibility;
		
		try {
			WebElement TITLE_ELEMENT = driver.findElement(By.xpath("//section[@class='layout-live-story__top']"));
			titleVisibility = true;
		}
		catch(NoSuchElementException e) {
			titleVisibility = false;
			e.printStackTrace();		
			
		}
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(TITLE_FIELD));
		
		Assert.assertTrue("title not visible", titleVisibility);
		
	}
	
	@After
	public void teardown() {
		driver.close();
		driver.quit();
	}
}
