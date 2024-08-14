package variousConcepts;

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

public class CrmTest {

	public WebDriver driver;

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
	public void loginTest() {
		WebElement USER_NAME_ELEMENT = driver.findElement(By.xpath("//input[@id='user_name']"));
		WebElement PASSWORD_ELEMENT = driver.findElement(By.xpath("//input[@id='password']"));
		WebElement SIGN_IN_ELEMENT = driver.findElement(By.xpath("//*[@id='login_submit']"));
		//When this was first added and the test ran there was an error
		//this happened since the element is not on the page
//		WebElement DASHBOARD_ELEMENT = driver.findElement(By.xpath("html/body/div[1]/section/div/div[2]/div/div/header/div/strong"));
		
		By USER_NAME_FIELD = By.xpath("//input[@id='user_name']");
		By PASSWORD_FIELD = By.xpath("//input[@id='password']");
		By DASHBOARD_HEADER_FIELD = By.xpath("html/body/div[1]/section/div/div[2]/div/div/header/div/strong");
		
		
		//Instead of using driver.findElement(By.xpath("//input[@id='user_name']")); Turn it into a WebElement
		//Helpful when using the same code more than once
		//FIELD
		
		//.clear() will clear any text for an input webelement
		USER_NAME_ELEMENT.clear();
		USER_NAME_ELEMENT.sendKeys("demo@codefios.com");
		PASSWORD_ELEMENT.sendKeys("abc123");
		SIGN_IN_ELEMENT.click();
		//WebElement DASHBOARD_ELEMENT = driver.findElement(By.xpath("html/body/div[1]/section/div/div[2]/div/div/header/div/strong"));
		
		//WebElement DASHBOARD_ELEMENT = driver.findElement(By.xpath("html/body/div[1]/section/div/div[2]/div/div/header/div/strong"));
		

		boolean dashBoardVisibility;
		
		try {
			
			WebElement DASHBOARD_ELEMENT = driver.findElement(By.xpath("html/body/div[1]/section/div/div[2]/div/div/header/div/strong"));
			dashBoardVisibility = true;
			
		}catch(NoSuchElementException e) {
			
			dashBoardVisibility = false;
			e.printStackTrace();
		}
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(DASHBOARD_HEADER_FIELD));
		
		//The code does not know that I have landed on the right page when I ran the test
		//Using Asserts will fix that
		//Assert.assertTrue("dashboard page not available", DASHBOARD_ELEMENT.isDisplayed());
		
		//this line uses a boolean variable to get rid of the previous error
		Assert.assertTrue("dashboard page not available", dashBoardVisibility);
		
		//Used this line as practice for XPATH Axes
		//driver.findElement(By.xpath("//div[@class='wrapper ']/descendant::button")).click();
	}

	@After
	public void teardown() {
		driver.close();
		driver.quit();
	}
}
