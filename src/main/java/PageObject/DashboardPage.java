package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class DashboardPage {
	WebDriver driver;

	By head = By.xpath("//*[@id=\"content\"]/div/div[1]/h1");
	By panel1 = By.id("panel_resizable_0_0");
	By srcAssignLevel = By.xpath("//*[@id=\\\"dashboard-quick-launch-panel-menu_holder\\\"]/table/tbody/tr/td[1]/div/a/img");
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	public String getTxtHead() {
		return driver.findElement(head).getText();
	}
	public String getTxtPanel1() {
		return driver.findElement(panel1).getText();
	}
	public void getSrcAssignLevel() {
		driver.findElement(srcAssignLevel);
	}
}
