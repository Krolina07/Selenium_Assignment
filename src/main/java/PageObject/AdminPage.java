package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminPage {
	WebDriver driver;
	
	By admin = By.id("menu_admin_viewAdminModule");
	By mnUserMan = By.id("menu_admin_UserManagement");
	By mnJob = By.id("menu_admin_Job");
	By mnOrg =By.id("menu_admin_Organization");
	By mnQa =By.id("menu_admin_Qualifications");
	By mnNat = By.id("menu_admin_nationality");
	By mnConfig = By.id("menu_admin_Configuration");
	By h1 = By.xpath("//*[@id=\"systemUser-information\"]/div[1]/h1");
	By mainMenu = By.id("mainMenuFirstLevelUnorderedList");

	public AdminPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getAdmin() {
		return driver.findElement(admin);
	}
	public WebElement getMnUserMan() {
		return driver.findElement(mnUserMan);
	}
	public WebElement getMnJob() {
		return driver.findElement(mnJob);
	}
	public WebElement getMnOrg() {
		return driver.findElement(mnOrg);
	}
	public WebElement getMnQa() {
		return driver.findElement(mnQa);
	}
	public WebElement getMnNat() {
		return driver.findElement(mnNat);
	}
	public WebElement getMnConfig() {
		return driver.findElement(mnConfig);
	}
	public WebElement geth1() {
		return driver.findElement(h1);
	}
	
}

/*5. Click on Admin Link in Home Page and validate following text-
• User Management
• Job
• Organization
• Qualifications*/