package tests;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;

import pages.LoginPage;
import pages.UserMenuPage;
import utilities.DataUtils;
import utilities.Utilities;

@Listeners(tests.Listeners.class)
public class LoginTest extends BaseTest {

	@Test
	public void loginErrorMsg_TC01(Method name) throws IOException {
//		ExtentTest 
//		test = extent.createTest(name.getName());
		logger.info("started test " +name.getName());
//		WebDriver 
		driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver, test);
		Assert.assertTrue(lp.launchApp(driver), "Should launch the sfdc app");
		Assert.assertTrue(lp.enterUsername(driver, DataUtils.readAccounts("valid.username")), "User name should be entered");
		lp.clearPassword();
		Assert.assertTrue(lp.clickLogin(driver), "Login button should be clicked");
		Assert.assertEquals(lp.loginErrorMsg.getText(), DataUtils.readErrorMessages("login.error.message"));
		logger.info("ending test " +name.getName());
	}

	@Test
	public void loginToSF_TC02() throws IOException {
//		WebDriver
		driver = BaseTest.getDriver();
//		ExtentTest 
//		test = extent.createTest("loginToSF_TC02");
		LoginPage lp = new LoginPage(driver, test);
		Assert.assertTrue(lp.launchApp(driver), "Should launch the sfdc app");
		Assert.assertTrue(lp.enterUsername(driver,DataUtils.readAccounts("valid.username")), "user name should be entered");
		Assert.assertTrue(lp.enterPassword(driver, DataUtils.readAccounts("valid.password")), "password should be entered");
		Assert.assertTrue(lp.clickLogin(driver), "Login button should be clicked");
		Assert.assertTrue(lp.isFreeTrailSeen(driver), "Free trial should be seen");
		
	}
//	
	@Test
	public void rememberMe_TC03() throws InterruptedException, IOException {
//		WebDriver 
		driver = BaseTest.getDriver();
//		ExtentTest 
//		test = extent.createTest("rememberMe_TC03");
		LoginPage lp = new LoginPage(driver, test);
		UserMenuPage ump = new UserMenuPage(driver,test);
//		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Assert.assertTrue(lp.launchApp(driver), "Should launch the sfdc app");
		Assert.assertTrue(lp.enterUsername(driver,DataUtils.readAccounts("valid.username")), "user name should be entered");
		Assert.assertTrue(lp.enterPassword(driver, DataUtils.readAccounts("valid.password")), "password should be entered");
		Assert.assertTrue(lp.selectRemeberMeCheckbox(), "should select remember me checkbox");
		Assert.assertTrue(lp.clickLogin(driver), "Login button should be clicked");
		Assert.assertTrue(ump.clickOnUserMenu(driver),"Usermenu should be opened");
		Assert.assertTrue(ump.selectOptionInUserMenuDropDown(driver, "Logout"),"Logout should be clicked");
		Utilities.waitForElement(driver, lp.savedUsername);
		Assert.assertEquals(lp.getSavedUsername(), DataUtils.readAccounts("valid.username"));
		
	}
}

