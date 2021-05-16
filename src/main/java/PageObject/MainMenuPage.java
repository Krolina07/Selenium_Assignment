package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MainMenuPage {

	WebDriver driver;
	/*- Write Test method and page title for different menus- in order(Admin, PIM,
	Leave, Dashboard, Directory and Maintenance)*/

	By adminTab = By.xpath("//*[@id='menu_admin_viewAdminModule']/b");
	By pimTab= By.id("menu_pim_viewPimModule");
	By leaveTab = By.id("menu_leave_viewLeaveModule");
	By timeTab=By.id("menu_time_viewTimeModule");
	By dashboardTab = By.id("menu_dashboard_index");
	By direcTab=By.id("menu_directory_viewDirectory");
	By mantoTab =By.id("menu_maintenance_purgeEmployee");
	
	By adminJob = By.xpath("//*[@id='menu_admin_Job']");
	By adminJobTitle = By.xpath("//*[@id='menu_admin_viewJobTitleList']");
	By adminJobPayGrades = By.xpath("//*[@id='menu_admin_viewPayGrades']");


	public MainMenuPage(WebDriver driver) {
		this.driver = driver;
	}

	public void moveToAdminJobGrades() {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(adminTab)).moveToElement(driver.findElement(adminJob))
				.moveToElement(driver.findElement(adminJobPayGrades)).build().perform();
		
		act.click().perform();
	}

	public void moveToAdminJobTitles() {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(adminTab)).moveToElement(driver.findElement(adminJob))
				.moveToElement(driver.findElement(adminJobTitle)).build().perform();
		act.click().perform();
	}

	public WebElement getAdminTab() {
		return driver.findElement(adminTab);
	}
	public void getPimTab() {
		driver.findElement(pimTab).click();
	}
	public WebElement getLeaveTab() {
		return driver.findElement(leaveTab);
	}
	public WebElement getTimeTab() {
		return driver.findElement(timeTab);
	}
	public WebElement getDashboardTab() {
		return driver.findElement(dashboardTab);
	}
	public WebElement getDirecTab() {
		return driver.findElement(direcTab);
	}
	public WebElement getMantoTabb() {
		return driver.findElement(mantoTab);
	}

}
