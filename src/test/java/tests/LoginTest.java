package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;

import pages.LoginPage;
import pages.UserMenuPage;
import utilities.Utilities;

public class LoginTest extends BaseTest {

	@Test
	public void loginErrorMsg_TC01() {
		ExtentTest test = extent.createTest("loginErrorMsg_TC01");
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		Assert.assertTrue(lp.launchApp(driver), "Should launch the sfdc app");
		test.log(Status.PASS, "App is launched");
		Assert.assertTrue(lp.enterUsername("mithun.r@tekarch.com"), "User name should be entered");
		test.log(Status.PASS, "username is entered");
		lp.clearPassword();
		test.log(Status.PASS, "password is cleared");
		Assert.assertTrue(lp.clickLogin(), "Login button should be clicked");
		test.log(Status.PASS, "Login button clicked");
		Assert.assertEquals(lp.loginErrorMsg.getText(), "Please enter your password.");
	}

	@Test
	public void loginToSF_TC02() throws IOException {
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		ExtentTest test = extent.createTest("loginToSF_TC02");
		Assert.assertTrue(lp.launchApp(driver), "Should launch the sfdc app");
		test.log(Status.PASS, "App is launched");
		Assert.assertTrue(lp.enterUsername("jul22.mithun@ta.com"), "user name should be entered");
		test.log(Status.PASS, "username is entered");
		Assert.assertTrue(lp.enterPassword("Honda8511"), "password should be entered");
		Assert.assertTrue(lp.clickLogin(), "Login button should be clicked");
		test.log(Status.FAIL, "Login button clicked");
		Assert.assertTrue(lp.isFreeTrailSeen(), "Free trial should be seen");
		test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
	}
	
	@Test
	public void rememberMe_TC03() throws InterruptedException {
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		UserMenuPage ump = new UserMenuPage(driver);
		ExtentTest test = extent.createTest("rememberMe_TC03");
//		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Assert.assertTrue(lp.launchApp(driver), "Should launch the sfdc app");
		Assert.assertTrue(lp.enterUsername("jul22.mithun@ta.com"), "user name should be entered");
		Assert.assertTrue(lp.enterPassword("Honda8511"), "password should be entered");
		Assert.assertTrue(lp.selectRemeberMeCheckbox(), "should select remember me checkbox");
		test.log(Status.PASS, "Login button clicked");
		Assert.assertTrue(lp.clickLogin(), "Login button should be clicked");
		Assert.assertTrue(ump.clickOnUserMenu(),"Usermenu should be opened");
		Assert.assertTrue(ump.selectOptionInUserMenuDropDown(driver, "Logout"),"Logout should be clicked");
		Utilities.waitForElement(driver, lp.savedUsername);
		Assert.assertEquals(lp.getSavedUsername(), "jul22.mithun@ta.com");
		
	}
	

}
