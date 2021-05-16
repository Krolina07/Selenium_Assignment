package TestCases;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import PageObject.DashboardPage;
import PageObject.LoginPage;

@Listeners(ITest_Listener.my_Listene.class)

public class TestCase_3 {
	WebDriver driver;
	LoginPage objLogin;
	DashboardPage objDbPage;
	
	@Test
	public void test1_Listener() {
		System.out.println("Test 1 Executed.........");		
	}
	@Test
	public void test2_Listener() {
		System.out.println("Test 2 Executed.........");
		
	}
}
