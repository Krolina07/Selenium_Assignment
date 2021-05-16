package TestCases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import PageObject.DashboardPage;
import PageObject.LoginPage;
import PageObject.MainMenuPage;

public class TestCase_2 {
	static WebDriver driver;
	LoginPage logPag;
	MainMenuPage MainMenuPage;
	DashboardPage dbPage;

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login"); // 6. Launch a browser in open url
		driver.manage().window().maximize(); // @Beforesuite annotation and
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test(priority = 0)
	public void LoginTestCase() {
		logPag = new PageObject.LoginPage(driver);
		MainMenuPage = new PageObject.MainMenuPage(driver);
		dbPage = new PageObject.DashboardPage(driver);
		logPag.getUserName("Admin");
		logPag.getPassword("admin123");
		logPag.clickOnLoginBtn();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		MainMenuPage.getAdminTab().click();
		System.out.println("Page title Admin :" + driver.getTitle());
		MainMenuPage.getPimTab();
		System.out.println("Page title PIM:" + driver.getTitle());
		MainMenuPage.getLeaveTab().click();
		System.out.println("Page title Leave:" + driver.getTitle());
		MainMenuPage.getDashboardTab().click();
		System.out.println("Page title Leave:" + driver.getTitle());
		MainMenuPage.getDirecTab().click();
		System.out.println("Page title Directory:" + driver.getTitle());
		MainMenuPage.getMantoTabb().click();
		System.out.println("Page title Maintenance:" + driver.getTitle());
		setSize(800, 600);
		/*
		 * 10- Read Dashboard heading using [driver.findelement(by.xpath()).gettext()].
		 * Refer below screenshot-
		 */
		MainMenuPage.getDashboardTab().click();
		System.out.println("Dashboard heading is:" + dbPage.getTxtHead());
		String txthead = dbPage.getTxtHead();
		Assert.assertEquals(txthead, "Dashboard");

	}

	public static void setSize(int hight, int width) {
		// 9- Write a method (avoid using Test annotation) to minimize the window.
		Dimension dimension = new Dimension(hight, width);
		driver.manage().window().setSize(dimension);
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
