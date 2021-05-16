package TestCases;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObject.LoginPage;
import PageObject.MainMenuPage;
import PageObject.PimPage;
import org.openqa.selenium.TakesScreenshot;
public class TestCase_5 {
	WebDriver driver;
	LoginPage objLogin;
	MainMenuPage objmainMenu;
	PimPage objPim;
	/*
	 * 13- Execute followingscenario • Login to OrangeHRM • Click on PIM • Enter
	 * Employee Name-Linda Anderson in Search box (refer below image) • Validate and
	 * capture screenshot
	 * 
	 */
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login"); // 6. Launch a browser in open url
		driver.manage().window().maximize(); // @Beforesuite annotation and
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@Test(priority = 1)
	public void loginFunctionality() throws InterruptedException {

		objLogin = new LoginPage(driver);
		objmainMenu = new MainMenuPage(driver);
		objPim = new PimPage(driver);
		SoftAssert sa= new SoftAssert();
		Date d = new Date();
		try {
			objLogin.getUserName("Admin");
			objLogin.getPassword("admin123");
			objLogin.clickOnLoginBtn(); 
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
			objmainMenu.getPimTab();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			objPim.getEmployeeName().sendKeys("Linda Anderson");
			objPim.getSearchBtn();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
			sa.assertEquals(objPim.GetfirstNameTb(), "Linda Jane");
			sa.assertEquals(objPim.GetlastNameTb(), "Anderson");
			String FileName = d.toString().replace(":", "_").replace(" ", "_") + ".png";
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File("screenshots\\\\screenshot" + FileName));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@AfterTest
	public void close_browser() {
		driver.close();
	}
}
