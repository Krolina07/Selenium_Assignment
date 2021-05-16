package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GradePage {

	WebDriver driver;

	By tableGrade = By.xpath("//*[@id='resultTable']");
	By tableGradeRow = By.xpath("//*[@id='resultTable']/tbody/tr");
	By tableGradeCol = By.xpath("//*[@id='resultTable']/thead/tr/th");

	public GradePage(WebDriver driver) {
		this.driver = driver;
	}

	public int getGradeTableRowCnt() {
		return driver.findElements(tableGradeRow).size();
	}

	public int getGradeTableColCnt() {
		return driver.findElements(tableGradeCol).size();
	}

}
