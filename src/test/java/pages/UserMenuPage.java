package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import constants.FileConstants;
import utilities.DataUtils;
import utilities.Utilities;

public class UserMenuPage extends BasePage{

	public UserMenuPage(WebDriver driver, ExtentTest test) {
		PageFactory.initElements(driver, this);
		this.test = test;
//		this.driver = driver;
	}

	@FindBy(id = "userNavLabel")
	public WebElement userMenu;

	@FindBy(xpath = "//div[@id='userNav-menuItems']/a")
	public List<WebElement> userMenuOptions;

	@FindBy(id = "userNav-menuItems/a[1]")
	public WebElement MyProfile;

	@FindBy(id = "userNav-menuItems/a[2]")
	public WebElement MySettings;

	@FindBy(id = "userNav-menuItems/a[3]")
	public WebElement DevelopersConsole;

	@FindBy(id = "userNav-menuItems/a[4]")
	public WebElement SwitchtoLightningExperience;

	@FindBy(id = "userNav-menuItems/a[4]")
	public WebElement Logout;

	// My profile
	@FindBy(xpath = "//a[@class='contactInfoLaunch editLink']")
	public WebElement editprofilebutton;

	@FindBy(xpath = "//div/h2[@id='contactInfoTitle']")
	public WebElement EditProfilePopupwindow;

	@FindBy(id = "aboutTab")
	public WebElement Abouttab;

	@FindBy(xpath = "//input[@id='lastName']")
	public WebElement Abouttablastname;

	@FindBy(xpath = "//*[@value='Save All']")
	public WebElement saveAllButton;

	@FindBy(xpath = "//*[@id=\"tailBreadcrumbNode\"]")
	public WebElement Userprofilepagenamedisplay;

	// Postlink
	@FindBy(css = "#publishereditablearea")
	public WebElement postLink;

	@FindBy(xpath = "/html/body")
	public WebElement postTextArea;

	@FindBy(xpath = "//input[@id='publishersharebutton']")
	public WebElement shareButton;

	// filelink

	@FindBy(xpath = "//*[@id='publisherAttachContentPost']")
	public WebElement filelink;

	@FindBy(xpath = "//a[@id='publisherAttachContentPost']/span[1]")
	public WebElement contentpost;

	@FindBy(css = "#chatterUploadFileAction")
	public WebElement Uploadfile; 
	
	@FindBy(css = "#chatterFile")
	public WebElement Fileopen;

	@FindBy(css = "#publishersharebutton")
	public WebElement publish;

	@FindBy(xpath = "//input[@value='Cancel Upload']")
	public WebElement cancelUpload;
	
	@FindBy(id = "uploadLink")
	public WebElement updateButton;
	// Photo link

	@FindBy(xpath = "//*[@id=\"publisherAttachLinkPost\"]/span[1]")
	public WebElement photolink;

	@FindBy(id = "j_id0:uploadFileForm:uploadInputFile")
	public WebElement uploadphoto;

	@FindBy(name = "j_id0:uploadFileForm:uploadBtn")
	public WebElement uploadbutton;

	@FindBy(id = "publishersharebutton")
	public WebElement photosharebutton;
	
	@FindBy(id = "uploadPhotoContentId")
	public WebElement photoUploadIframe;
	
	@FindBy(xpath = "//input[@id='j_id0:uploadFileForm:uploadBtn']")
	public WebElement photoSaveButton;
	
	@FindBy(xpath = "//input[@id='j_id0:j_id7:save']")
	public WebElement photoSaveButton2;
	// My Settings
	// personallink

	@FindBy(xpath = "//*[@id=\'PersonalInfo_font\']")
	public WebElement personallink;

	@FindBy(xpath = "//*[@id=\"LoginHistory_font\"]")
	public WebElement loginHistorylink;

	@FindBy(xpath = "//*[@id=\"RelatedUserLoginHistoryList_body\"]/div/a")
	public WebElement logindisplay;

	@FindBy (id = "contactInfoContentId")
	public WebElement iframeAboutTab;
	// Display&layoutlink

	@FindBy(xpath = "//*[@id=\"DisplayAndLayout_font\"]")
	public WebElement DisplayLayoutlink;

	@FindBy(id = "CustomizeTabs_font")
	public WebElement CustomizedTab;

	@FindBy(xpath = "//*[@id=\"p4\"]/option[9]")
	public WebElement customApp;

	@FindBy(xpath = "//*[@id=\"duel_select_0\"]/option[73]")
	public WebElement Availabletab;

	@FindBy(xpath = "//*[@id=\"duel_select_0_right\"]/img")
	public WebElement Add;

	@FindBy(xpath = "//*[@id=\"bottomButtonRow\"]/input[1]")
	public WebElement save;

	@FindBy(id = "tabBar")
	public WebElement tabList;

	// Emaillink

	@FindBy(xpath = "//*[@id=\"EmailSetup_font\"]")
	public WebElement Emaillink;

	@FindBy(id = "EmailSettings_font")
	public WebElement MyEmailSettings;

	@FindBy(id = "sender_name")
	public WebElement Emailname;

	@FindBy(xpath = "//*[@id=\"sender_email\"]")
	public WebElement Emailaddress;

	@FindBy(xpath = "//*[@id=\"useremailSection\"]/table/tbody/tr[7]/td[2]/div")
	public WebElement BCCradiobutton;

	@FindBy(xpath = "//*[@id=\"bottomButtonRow\"]/input[1]")
	public WebElement Saveonemail;

	// Calendar and Remainders
	@FindBy(id = "CalendarAndReminders_font")
	public WebElement CalendarAndReminders;

	@FindBy(xpath = "//*[@id=\"Reminders_font\"]")
	public WebElement ActivityRemainder;

	@FindBy(id = "testbtn")
	public WebElement OpenaTestRemainder;

	@FindBy(xpath = "//*[@id=\"summary\"]")
	public WebElement SampleEventPopup;
	
	@FindBy (css = "#displayBadge")
	public WebElement moderatorButton;

	/**
	 * This function is responsible to verify user menu items in user menu drop down
	 * This function has to be called after clicking on user menu
	 * 
	 * @return {Boolean} true if all options are verified successfully else returns
	 *         false
	 * @throws IOException 
	 */
	public boolean verifyUserMenuItems() throws IOException {
		boolean isOptionVerified = true;
		logger.info("verifyUserMenuItems() : Verifying user menu items.. ");
		String[] expectedUserMenuItems = DataUtils.readErrorMessages("usermenu.items").split(",");
//		List<WebElement> listOfuserMenuElements 
		for (int i = 0; i < userMenuOptions.size(); i++) {
			String actualUserMenuItemValue = userMenuOptions.get(i).getText();
			logger.info("verifyUserMenuItems() : User menu item value is: "+actualUserMenuItemValue);
			if (actualUserMenuItemValue.equals(expectedUserMenuItems[i])) {
				System.out.println("The option " + expectedUserMenuItems[i] + " passed");
			} else {
				System.out.println("Actual "+actualUserMenuItemValue+" The option " + expectedUserMenuItems[i] + " failed");
				isOptionVerified = false;
			}
		}
		return isOptionVerified;
	}

	/**
	 * This function is responsible to select user menu item in user menu drop down
	 * by passing an option name
	 * 
	 * @param optionName example: {"My profile", "Settings", Logout}
	 * @return true if option is selected else false
	 */
	public boolean selectOptionInUserMenuDropDown(WebDriver driver, String optionName) {
		boolean isOptionSelected = false;
		WebElement userMenuOption = driver.findElement(By.xpath("//*[text()='" + optionName + "']"));
		if (userMenuOption.isDisplayed()) {
			userMenuOption.click();
			isOptionSelected = true;
		} else {
			System.out.println("Option " + optionName + " not selected");
		}
		return isOptionSelected;
	}

	/**
	 * This function will create a post, Should be called in my profile page
	 * 
	 * @param textBox WebElement
	 * @param message to be posted in text box
	 * @param button
	 * @return true if post is created else false
	 * @throws InterruptedException 
	 */
	public boolean createAPost(WebDriver driver, String message) throws InterruptedException {
		boolean isPostCreated = false;
		if (Utilities.waitForElement(driver, postLink)) {
			postLink.click();
			System.out.println("Clicked on the text box");
			driver.switchTo().frame(0);
			postTextArea.sendKeys(message);
			driver.switchTo().parentFrame();
			System.out.println("Entered the text in text box");
			if (shareButton.isDisplayed()) {
				shareButton.click();
				Thread.sleep(3000);
				System.out.println("Clicked on the post button");
				isPostCreated = true;
			}
		}
		return isPostCreated;
	}

	public boolean isUserMenuSeen(WebDriver driver) throws IOException {
		if (userMenu.isDisplayed()) {
			test.info("user menu is seen");
			return true;
		} else {
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
			test.info("user menu is not seen");
			return false;
		}
	}

	public boolean clickOnUserMenu(WebDriver driver) throws IOException {
		if (userMenu.isDisplayed()) {
			userMenu.click();
			test.info("user menu is opened");
			return true;
		} else {
			test.fail("");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
			return false;
		}
	}

	public boolean openEditProfileModal(WebDriver driver) throws IOException {
		boolean isEditProfileWindowSeen = false;
		if (Utilities.waitForElement(driver, editprofilebutton)) {
			Utilities.jsClick(driver, editprofilebutton);
			test.info("edit profile button is  seen");
			if (Utilities.waitForElement(driver, EditProfilePopupwindow)) {
				isEditProfileWindowSeen = true;
			}
		} else {
			test.fail("edit profile button is not seen");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
		}
		return isEditProfileWindowSeen;
	}

	public boolean changeLastNameInAboutTab(WebDriver driver, String lastName) throws IOException, InterruptedException {
		driver.switchTo().frame(iframeAboutTab);
		boolean isLastNameChanged = false;
		if (Abouttab.isDisplayed()) {
			Abouttab.click();
			test.info("about tab is seen");
			if (Abouttablastname.isDisplayed()) {
				Abouttablastname.clear();
				Abouttablastname.sendKeys(lastName);
				saveAllButton.click();
				test.info("clicked on save all button");
				Thread.sleep(3000);
				isLastNameChanged = true;
			} else {
				test.fail("About name tab is not visible");
				test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
			}
		} else {
			test.fail("About tab is not visible");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
		}
		driver.switchTo().parentFrame();
		return isLastNameChanged;
	}

	
	public boolean uploadAFile(WebDriver driver, String filepath) throws InterruptedException {
		boolean isFileUploadSuccess = false;
		if(Utilities.waitForElement(driver, filelink)) {
			Utilities.jsClick(driver, filelink);
		}
		if(Utilities.waitForElement(driver, Uploadfile)) {
			Uploadfile.click();
			if(Utilities.waitForElement(driver, Fileopen)) {
				Fileopen.sendKeys(filepath);
				if(Utilities.waitForElement(driver, shareButton)) {
					shareButton.click();
					if(Utilities.waitForElementToDisappear(driver, cancelUpload)) {
						isFileUploadSuccess = true;
					}
				}
			}
		}
		return isFileUploadSuccess;
	}
	
	
	public void clickOnUpdatePhoto(WebDriver driver) {
		Utilities.moveToElement(driver, moderatorButton);
		if(Utilities.waitForElement(driver, updateButton)) {
			updateButton.click();
		}
	}
	
	public boolean uploadPhoto(WebDriver driver, String filePath) throws InterruptedException {
		clickOnUpdatePhoto(driver);
		boolean isPhotoUploadSuccess = false;
		driver.switchTo().frame(photoUploadIframe);
		if(Utilities.waitForElement(driver, uploadphoto)) {
			uploadphoto.sendKeys(filePath);
			photoSaveButton.click();
			Thread.sleep(5000);
			isPhotoUploadSuccess = true;
		}
		if(Utilities.waitForElement(driver, photoSaveButton2)) {
			photoSaveButton2.click();
			Thread.sleep(3000);
		}
		driver.switchTo().parentFrame();
		return isPhotoUploadSuccess;
	}
	
}
