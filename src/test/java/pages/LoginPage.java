package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import utilities.Utilities;


/**
 * This class contains the object repository of login page
 * @author mithun.r
 */
public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver, ExtentTest test) {
		PageFactory.initElements(driver, this);
		this.test = test;
	}
	
	@FindBy(id = "username")
	public WebElement username;

	@FindBy(name = "pw")
	public WebElement password;

	@FindBy(id = "Login")
	public WebElement loginButton;

	@FindBy(xpath = "//*[@id='rememberUn']")
	public WebElement rememberMe;

	@FindBy(css = "#error")
	public WebElement loginErrorMsg;

	@FindBy(id = "un")
	public WebElement forgotUsername;

	@FindBy(partialLinkText = "Forgot Your")
	public WebElement forgotPassword;
	
	@FindBy(id = "continue")
	public WebElement continueButton;

	@FindBy(id = "forgotPassForm")
	public WebElement passwordResetScreen;

	@FindBy(xpath = "//a[text()='Return to Login']")
	public WebElement returnToLoginButton;
	
	@FindBy(id = "idcard-identity")
	public WebElement savedUsername;

	
	/**
	 * This method enters the user name. Call this when you are on login page
	 * @param userName string type
	 * @param driver webDriver type
	 * @return true if userName is entered
	 * @throws IOException 
	 */
	public Boolean enterUsername(WebDriver driver,String userName) throws IOException {
		if (username.isDisplayed()) {
			username.sendKeys(userName);
			test.info("username is entered as "+userName);
			return true;
		} else {
			test.fail("username element is not displayed");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
			return false;
		}
	}
	
	/**
	 * This method enters the password. Call this when you are on login page
	 * @param pass string type
	 * @param driver webDriver type
	 * @return true if password is entered
	 * @throws IOException 
	 */
	public Boolean enterPassword(WebDriver driver, String pass) throws IOException {
		if (password.isDisplayed()) {
			password.sendKeys(pass);
			test.info("password is entered as "+pass);
			return true;
		} else {
			test.fail("password element is not displayed");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
			return false;
		}
	}
	
	/**
	 * This method clicks on login button
	 * @param driver
	 * @return true if click is successful
	 * @throws IOException 
	 */
	public Boolean clickLogin(WebDriver driver) throws IOException {
		if (loginButton.isDisplayed()) {
			loginButton.click();
			test.pass("clicked on login button");
			return true;
		} else {
			test.fail("failed to click on login button");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
			return false;
		}
	}
	
	public void clearPassword() {
		test.info("password cleared");
		password.clear();
	}

	public boolean isErrorMessageSeen() {
		if (loginErrorMsg.isDisplayed()) {
			test.info("login error message is seen");
			return true;
		} else {
			test.info("login error message is not seen");
			return false;
		}
	}

	public boolean isFreeTrailSeen(WebDriver driver) throws IOException {
		test.fail("No free trial seen");
		test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
		return false;
	}

	public boolean isSavedUsernameSeen() {
		if (savedUsername.isDisplayed()) {
			test.info("saved user name is seen");
			return true;
		} else {
			test.info("saved user name is not seen");
			return false;
		}
	}

	public String getSavedUsername() {
		return savedUsername.getText();
	}

	public boolean selectRemeberMeCheckbox() {
		boolean checkboxStatus = false;
		if (rememberMe.isSelected()) {
			checkboxStatus = true;
			test.info("remember me check box is already selected");
		} else {
			rememberMe.click();
			checkboxStatus = true;
		}
		return checkboxStatus;
	}
	
	public Boolean launchApp(WebDriver driver) {
		driver.get("https://login.salesforce.com");
		test.info("App launched");
		return true;
	}


}
