package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import constants.FileConstants;
import pages.LoginPage;
import pages.UserMenuPage;

public class UserMenuTest extends BaseTest {
	
	@Test
	public void myProfile_TC06() throws IOException, InterruptedException {
//		ExtentTest test = extent.createTest("myProfile_TC06");
//		WebDriver 
		driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver, test);
		UserMenuPage ump = new UserMenuPage(driver, test);
		Assert.assertTrue(lp.loginToSFDC(driver), "Should launch the sfdc app");
		Assert.assertTrue(ump.clickOnUserMenu(driver),"Should open user menu");
		Assert.assertTrue(ump.verifyUserMenuItems(),"Should match user menu options");
		Assert.assertTrue(ump.selectOptionInUserMenuDropDown(driver, "My Profile"));
		Assert.assertTrue(ump.openEditProfileModal(driver),"Should open edit profile popup");
		Assert.assertTrue(ump.changeLastNameInAboutTab(driver, "ABCD"),"");
		Assert.assertTrue(ump.createAPost(driver, "Hello JAVA"),"Should create post");
		Assert.assertTrue(ump.uploadAFile(driver, FileConstants.FILE_UPLOAD_PATH),"Should upload a file");
		Assert.assertTrue(ump.uploadPhoto(driver, FileConstants.PHOTO_UPLOAD_PATH));
		
	}

}
