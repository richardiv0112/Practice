package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login_JUnit {

	WebDriver driver;

	@Test
	public void test1() {
		System.out.println("test 1");
		driver.findElement(By.name("user_name")).sendKeys("demo@codefios.com");
		driver.findElement(By.name("password")).sendKeys("abc123");
		driver.findElement(By.id("login_submit")).click();
	}
	@Test
	public void test2() {
		System.out.println("test 2");
		driver.findElement(By.name("user_name")).sendKeys("emo@codefios.com");
		driver.findElement(By.name("password")).sendKeys("abc123");
		driver.findElement(By.id("login_submit")).click();
	}
	@Before
	public void init() {
		System.out.println("before");
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		//Use this for implicit waits
		//in this case 2 second waits will apply any time the driver is called
		//Also it will not use the amount of time selected if it is not needed
		//Ex. If it takes 2 Seconds to get an element it will not wait another 8 seconds to execute code
		//If the element cannot be found within the set time the system will give you an error
		//Implicit wait also works remotely
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://codefios.com/ebilling/");
	}
	@After
	public void teardown() throws InterruptedException {
		System.out.println("after");
		//Threa.sleep(); is an explicit wait. Without it the driver will immediately close which makes
		//it hard to see the result
		//Implicit waiting is local
		//Thread.sleep(); is mostly unacceptable. Use it to check errors then replace with WebDriverWait
		//		Thread.sleep(2000);
		driver.close();
	}

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before class");
	}
	@AfterClass
	public static void afterClass() {
		System.out.println("After class");
	}

}
