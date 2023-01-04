package tests;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;

import pages.AccountsPage;
import pages.LoginPage;
import pages.UserMenuPage;
import utilities.DataUtils;
import utilities.Utilities;

public class LoginTest extends BaseTest {

//	@Test
	public void loginErrorMsg_TC01() throws IOException {
		ExtentTest test = extent.createTest("loginErrorMsg_TC01");
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver, test);
		Assert.assertTrue(lp.launchApp(driver), "Should launch the sfdc app");
		Assert.assertTrue(lp.enterUsername(driver, DataUtils.readAccounts("valid.username")), "User name should be entered");
		lp.clearPassword();
		Assert.assertTrue(lp.clickLogin(driver), "Login button should be clicked");
		Assert.assertEquals(lp.loginErrorMsg.getText(), DataUtils.readErrorMessages("login.error.message"));
	}

//	@Test
	public void loginToSF_TC02() throws IOException {
		WebDriver driver = BaseTest.getDriver();
		ExtentTest test = extent.createTest("loginToSF_TC02");
		LoginPage lp = new LoginPage(driver, test);
		Assert.assertTrue(lp.launchApp(driver), "Should launch the sfdc app");
		Assert.assertTrue(lp.enterUsername(driver,DataUtils.readAccounts("valid.username")), "user name should be entered");
		Assert.assertTrue(lp.enterPassword(driver, DataUtils.readAccounts("valid.password")), "password should be entered");
		Assert.assertTrue(lp.clickLogin(driver), "Login button should be clicked");
		Assert.assertTrue(lp.isFreeTrailSeen(driver), "Free trial should be seen");
		
	}
//	
//	@Test
	public void rememberMe_TC03() throws InterruptedException, IOException {
		WebDriver driver = BaseTest.getDriver();
		ExtentTest test = extent.createTest("rememberMe_TC03");
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
	
//	@Test
	public void tableHandling() throws IOException, InterruptedException {
		WebDriver driver = BaseTest.getDriver();
		ExtentTest test = extent.createTest("loginToSF_TC02");
		LoginPage lp = new LoginPage(driver, test);
		AccountsPage ap = new AccountsPage(driver, test);
		
		Assert.assertTrue(lp.launchApp(driver), "Should launch the sfdc app");
		Assert.assertTrue(lp.enterUsername(driver,DataUtils.readAccounts("valid.username")), "user name should be entered");
		Assert.assertTrue(lp.enterPassword(driver, DataUtils.readAccounts("valid.password")), "password should be entered");
		Assert.assertTrue(lp.clickLogin(driver), "Login button should be clicked");
		driver.findElement(By.id("Contact_Tab")).click();
		Thread.sleep(2000);
		ap.selectOptionInDropdown("My Contacts");
		ap.contactsPageGoButton.click();
		Thread.sleep(3000);
//		//thead/tr/td[6]
		
		for(int i=4; i<=7; i++) {
				String name = driver.findElement(By.xpath("//thead/tr/td["+i+"]")).getText();
				System.out.print(name+"    ");
			
		}
		
		for(int i=1; i<=20; i++) {
			for(int j=4; j<=7; j++) {
				String name = driver.findElement(By.xpath("(//table[@class='x-grid3-row-table'])["+i+"]//tr//td["+j+"]")).getText();
				System.out.print(name+"    ");
			}
			System.out.println();
		}
		
		Utilities.fluentlyWait(ap.contactsPageGoButton, driver).click();
		
	}
		
	@Test(dataProvider = "login test data")
	public void loginToSFDC(String username, String pass) throws IOException, InterruptedException {
		WebDriver driver = BaseTest.getDriver();
		ExtentTest test = extent.createTest("loginToSFDC");
		LoginPage lp = new LoginPage(driver, test);
		AccountsPage ap = new AccountsPage(driver, test);
		
		Assert.assertTrue(lp.launchApp(driver), "Should launch the sfdc app");
		Assert.assertTrue(lp.enterUsername(driver,username), "user name should be entered");
		Assert.assertTrue(lp.enterPassword(driver, pass), "password should be entered");
		Assert.assertTrue(lp.clickLogin(driver), "Login button should be clicked");
	}
	
	
	@DataProvider(name = "login test data")
	public Object[][] loginCreds(){
		
		
		return new String[][] {
			{"jul22.mithun@ta.com","Honda8511"},
			{"abcd@abcd.com","1234"}
		};
	}
	
	@DataProvider(name = "login test accounts")
	public String[][] loginAccounts(){
		
		
		return Utilities.readExcelArray();
	}
	
}
				


