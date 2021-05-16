package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PimPage {
	WebDriver driver;
	By employeeName = By.id("empsearch_employee_name_empName");
	By searchBtn = By.id("searchBtn");
	By firstNameTb = By.xpath("//*[@id='resultTable']/tbody/tr[1]/td[3]");
	By lastNameTb = By.xpath("//*[@id='resultTable']/tbody/tr[1]/td[4]");
	
	public PimPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getEmployeeName() {
		return driver.findElement(employeeName);
	}
	public void getSearchBtn() {
		 driver.findElement(searchBtn).click();
	}
	public String GetfirstNameTb() {
		 return driver.findElement(firstNameTb).getText();
	}
	public String GetlastNameTb() {
		 return driver.findElement(lastNameTb).getText();
	}

}
