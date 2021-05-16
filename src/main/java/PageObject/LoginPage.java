package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
//3- Write Xpath and CssSelector of login page for following web objects - All Text box’s, All - Hyperlinks, All Images.
	WebDriver driver;

	By userName = By.id("txtUsername");
	By passwd = By.id("txtPassword");
	By loginBtn = By.id("btnLogin");
	By forgotPswdLnk = By.linkText("Forgot your password?");
	By img = By.cssSelector("#divLogo > img");
	By content = By.xpath("//*[@id=\\\"content\\\"]/div[2]/span");
	By panel = By.id("logInPanelHeading");
	

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void getUserName(String user) {
		driver.findElement(userName).sendKeys(user);
	}

	public void getPassword(String pswd) {
		driver.findElement(passwd).sendKeys(pswd);
	}

	public void clickOnLoginBtn() {
		driver.findElement(loginBtn).click();
	}

	public void clickOnForgotLink() {
		driver.findElement(forgotPswdLnk).click();
	}
	
	public void getImg() {
		driver.findElement(img);
	}
	public void getContent() {
		driver.findElement(content);
	}
	public void getPanel() {
		driver.findElement(panel);
	}
}