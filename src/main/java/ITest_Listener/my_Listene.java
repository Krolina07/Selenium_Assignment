package ITest_Listener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.assertthat.selenium_shutterbug.core.Shutterbug;

public class my_Listene implements ITestListener {
	WebDriver driver;
	/*
	 * 11. Implement ITestListener for above scenario where full-page screenshot needs
	 * to be capture where ever test is pass or failed. Hint – Please use Shutterbug
	 * class
	 */
	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
	 Date date = new Date();
	 String date1= dateFormat.format(date);
	 
	public void onTestStart(ITestResult result) {
		
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Sucessfully Executed:" + result.getName());
		Shutterbug.shootPage(driver).withName("Test_Success").save();
	}

	public void onTestFailure(ITestResult result) {
		 System.out.println("Test Failed:" + result.getName());
		Shutterbug.shootPage(driver).withName("Test_Success").save();
		driver.quit();

	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped:" + result.getName());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Test Failed but within Successpercentage:" + result.getName());

	}

	public void onStart(ITestContext context) {
		System.out.println("On Start Method: " + context.getStartDate());
	}

	public void onFinish(ITestContext context) {
		driver.quit();
		System.out.println("On Finish Method:" + context.getEndDate());
		System.out.println("Failed Test:" + context.getFailedTests());
		System.out.println("Passed Test:" + context.getPassedTests());
		System.out.println("Skipped Test:" + context.getSkippedTests());

	}

}
