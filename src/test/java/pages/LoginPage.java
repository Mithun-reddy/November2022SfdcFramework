package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * This class contains the object repository of login page
 * @author mithun.r
 */
public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
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
	 */
	public Boolean enterUsername(String userName) {
		if (username.isDisplayed()) {
			username.sendKeys(userName);
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * This method enters the password. Call this when you are on login page
	 * @param pass string type
	 * @param driver webDriver type
	 * @return true if password is entered
	 */
	public Boolean enterPassword(String pass) {
		if (password.isDisplayed()) {
			password.sendKeys(pass);
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * This method clicks on login button
	 * @param driver
	 * @return true if click is successful
	 */
	public Boolean clickLogin() {
		if (loginButton.isDisplayed()) {
			loginButton.click();
			return true;
		} else {
			return false;
		}
	}
	
	public void clearPassword() {
		password.clear();
	}

	public boolean isErrorMessageSeen() {
		if (loginErrorMsg.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isFreeTrailSeen() {
		return false;
	}

	public boolean isSavedUsernameSeen() {
		if (savedUsername.isDisplayed()) {
			return true;
		} else {
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
		} else {
			rememberMe.click();
			checkboxStatus = true;
		}
		return checkboxStatus;
	}
	
	public Boolean launchApp(WebDriver driver) {
		driver.get("https://login.salesforce.com");
		return true;
	}


}
