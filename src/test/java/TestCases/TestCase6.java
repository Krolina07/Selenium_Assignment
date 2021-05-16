package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.LoginPage;

public class TestCase6 {

	WebDriver driver;
	LoginPage objLogin;
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login"); // 6. Launch a browser in open url
		driver.manage().window().maximize(); // @Beforesuite annotation and
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@Test 
	//14- Write CSS Selector of highlighted Rectangular object (in Red) in below Image
	public void highlighterCssSelector() {
		objLogin = new LoginPage(driver);
		
		objLogin.getUserName("Admin");
		objLogin.getPassword("admin123");
		objLogin.clickOnLoginBtn(); 
		
		WebElement branding = driver.findElement(By.cssSelector("#branding > a:nth-child(1)"));
		highLighterMethod(driver, branding);
		
		WebElement pimModule = driver.findElement(By.cssSelector("#menu_pim_viewPimModule"));
		highLighterMethod(driver, pimModule);
		WebElement timeModule = driver.findElement(By.cssSelector("#menu_time_viewTimeModule"));
		highLighterMethod(driver, timeModule);
		WebElement maintenance = driver.findElement(By.cssSelector("#menu_maintenance_purgeEmployee"));
		highLighterMethod(driver, maintenance);
		
		WebElement assignLeave = driver.findElement(By.cssSelector("#dashboard-quick-launch-panel-menu_holder > table > tbody > tr > td:nth-child(1)"));
		highLighterMethod(driver, assignLeave);
		WebElement myTimesheet = driver.findElement(By.cssSelector("#dashboard-quick-launch-panel-menu_holder > table > tbody > tr > td:nth-child(6)"));
		highLighterMethod(driver, myTimesheet);
		
		WebElement panelResizable= driver.findElement(By.cssSelector("#panel_resizable_1_0"));
		highLighterMethod(driver, panelResizable);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}

		
	@AfterTest
	public void close_browser() {
		driver.close();
	}
	
	// Creating a custom function
	public void highLighterMethod(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'border: 4px solid red;');", element);
	}

}
