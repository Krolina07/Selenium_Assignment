package PageObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DirectoryPage {

	WebDriver driver;

	By searchByName = By.xpath("//*[@id='searchDirectory_emp_name_empName']");
	By searchByJobTitle = By.xpath("//*[@id='searchDirectory_job_title']");
	By searchByLocation = By.xpath("//select[@id='searchDirectory_location']");
	By btnSearch = By.id("searchBtn");
	By btnReset = By.id("resetBtn");
	By tableResult = By.xpath("//*[@id='resultTable']");
	By tableResultRow = By.xpath("//*[@id='resultTable']/tbody/tr");

	public DirectoryPage(WebDriver driver) {
		this.driver = driver;
	}

	public void setSearchByName(String strName) {
		driver.findElement(searchByName).sendKeys(strName);
	}

	public void selectSearchByJobTitle(String strJobTitle) {

		Select sel = new Select(driver.findElement(searchByJobTitle));
		sel.selectByVisibleText(strJobTitle);

	}

	public void clickOnSearchBtn() {
		driver.findElement(btnSearch).click();
	}

	public void clickOnResetBtn() {
		driver.findElement(btnReset).click();
	}

	public int getRowCnt() {
		return driver.findElements(tableResultRow).size();
	}

	public List<HashMap<String, String>> readDirectoryTableData(int rw) {

		List<HashMap<String, String>> al = new ArrayList<HashMap<String, String>>();

		for (int i = 2; i <= rw; i++) {

			HashMap<String, String> hm = new HashMap<String, String>();
			String val = driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i + "]/td[2]/ul/li[1]/b"))
					.getText();
			hm.put("Name", val);
			System.out.println("Row:" + i + "Name:" + val);
			val = driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i + "]/td[2]/ul/li[2]")).getText();
			System.out.println("Row:" + i + "Designation:" + val);
			hm.put("Designation", val);
			val = driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i + "]/td[2]/ul/li[3]")).getText();
			System.out.println("Row:" + i + "Department:" + val);
			hm.put("Department", val);
			val = driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i + "]/td[2]/ul/li[4]")).getText();
			System.out.println("Row:" + i + "Location:" + val);
			hm.put("Location", val);

			al.add(hm);

		}

		return al;

	}

}
