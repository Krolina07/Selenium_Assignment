package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import PageObject.AdminPage;
import PageObject.DashboardPage;
import PageObject.LoginPage;
public class TestCase_1 {
	WebDriver driver;
	LoginPage objLogin;
	DashboardPage objDbPage;
	AdminPage objAdPage;

	@Test(priority = 1) //7- Login to application again in @Test method, set priority 1 of the same method Afterlogging
	public void loginFunctionality() throws InterruptedException {
				
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe"); //1. - Open the above URL in Chrome browser
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Page title :"+ driver.getTitle());//2- Print the title of this application.
		objLogin = new LoginPage(driver);
		objDbPage = new DashboardPage(driver);
		objAdPage = new AdminPage(driver);
		
		objLogin.getUserName("Admin");
		objLogin.getPassword("admin123");
		objLogin.clickOnLoginBtn(); //4. Login with given User Name and Password and validate Dashboard 
		String txthead = objDbPage.getTxtHead();
		Assert.assertEquals(txthead, "Dashboard");
			
		objAdPage.getAdmin().click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String txtMnUserMan = objAdPage.getMnUserMan().getText();
		String txtMnJob = objAdPage.getMnJob().getText();
		String txtMnOrg = objAdPage.getMnOrg().getText();
		String txtMnQa = objAdPage.getMnQa().getText();	

/*5. Click on Admin Link in Home Page and validate following text-
• User Management
• Job
• Organization
• Qualifications*/
		
		Assert.assertEquals(txtMnUserMan,"User Management","Text doesn't match" );
		Assert.assertEquals(txtMnJob, "Job" ,"Text doesn't match" );
		Assert.assertEquals(txtMnOrg,"Organization","Text doesn't match" );
		Assert.assertEquals(txtMnQa,"Qualifications","Text doesn't match" );
		
		driver.close();
	}
	
	
	
}
