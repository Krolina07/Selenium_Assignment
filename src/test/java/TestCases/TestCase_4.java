package TestCases;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import PageObject.AdminPage;
import PageObject.LoginPage;

public class TestCase_4 {
	//Implement Retry analyzer – retry 3 times only for the above scenario. 
	WebDriver driver;
	LoginPage objLogin;
	AdminPage objAdPage;
    
	@Test(retryAnalyzer = SeleniumUtils.IRetryAnalyzer_test.class)
	public void loginFunctionality() throws InterruptedException {
				
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Page title :"+ driver.getTitle());
		objLogin = new LoginPage(driver);
		objAdPage = new AdminPage(driver);
		objLogin.getUserName("Admin");
		objLogin.getPassword("admin123");
		objAdPage.getAdmin().click();
		Assert.assertEquals(true, false);
		driver.close();
	}
	
}
