package variousConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
//		
//		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.manage().deleteAllCookies();
//		driver.manage().window().maximize();
//		
//		driver.get("https://codefios.com/ebilling/");
//		driver.findElement(By.name("user_name")).sendKeys("demo@codefios.com");
//		driver.findElement(By.name("password")).sendKeys("abc123");
//		driver.findElement(By.id("login_submit")).click();
//		Thread.sleep(2000);
//		driver.close();
		negUsernameTest();
		
	}
	
	public static void test1() {
		driver.findElement(By.name("user_name")).sendKeys("demo@codefios.com");
		driver.findElement(By.name("password")).sendKeys("abc123");
		driver.findElement(By.id("login_submit")).click();
	}
	public static void test2() {
		driver.findElement(By.name("user_name")).sendKeys("emo@codefios.com");
		driver.findElement(By.name("password")).sendKeys("abc123");
		driver.findElement(By.id("login_submit")).click();
	}
	public static void init() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://codefios.com/ebilling/");
	}
	public static void teardown() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}
	public static void posTest() throws InterruptedException {
		init();
		test1();
		teardown();
	}
public static void negUsernameTest() throws InterruptedException {
		init();
		test2();
		teardown();
	}

}
