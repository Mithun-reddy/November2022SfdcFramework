package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserMenuPage {

	public UserMenuPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
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

	@FindBy(xpath = "//*[@id=\"publisherAttachContentPost\"]")
	public WebElement filelink;

	@FindBy(xpath = "//a[@id='publisherAttachContentPost']/span[1]")
	public WebElement contentpost;

	@FindBy(css = "#chatterUploadFileAction")
	public WebElement Uploadfile;

	@FindBy(css = "#chatterFile")
	public WebElement Fileopen;

	@FindBy(css = "#publishersharebutton")
	public WebElement publish;

	// Photo link

	@FindBy(xpath = "//*[@id=\"publisherAttachLinkPost\"]/span[1]")
	public WebElement photolink;

	@FindBy(id = "j_id0:uploadFileForm:uploadInputFile")
	public WebElement uploadphoto;

	@FindBy(name = "j_id0:uploadFileForm:uploadBtn")
	public WebElement uploadbutton;

	@FindBy(id = "publishersharebutton")
	public WebElement photosharebutton;

	// My Settings
	// personallink

	@FindBy(xpath = "//*[@id=\'PersonalInfo_font\']")
	public WebElement personallink;

	@FindBy(xpath = "//*[@id=\"LoginHistory_font\"]")
	public WebElement loginHistorylink;

	@FindBy(xpath = "//*[@id=\"RelatedUserLoginHistoryList_body\"]/div/a")
	public WebElement logindisplay;

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

	/**
	 * This function is responsible to verify user menu items in user menu drop down
	 * This function has to be called after clicking on user menu
	 * 
	 * @return {Boolean} true if all options are verified successfully else returns
	 *         false
	 */
	public boolean verifyUserMenuItems() {
		boolean isOptionVerified = true;
		String[] expectedUserMenuItems = { "My Profile", "My Settings", "Developer Console",
				"Switch to Lightning Experience", "Logout" };
//		List<WebElement> listOfuserMenuElements 
		for (int i = 0; i < userMenuOptions.size(); i++) {
			String actualUserMenuItemValue = userMenuOptions.get(i).getText();
			if (actualUserMenuItemValue.equals(expectedUserMenuItems[i])) {
				System.out.println("The option " + expectedUserMenuItems[i] + " passed");
			} else {
				System.out.println("The option " + expectedUserMenuItems[i] + " failed");
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
	 */
	public boolean createAPost(WebDriver driver, String message) {
		boolean isPostCreated = false;
		if (postLink.isDisplayed()) {
			postLink.click();
			System.out.println("Clicked on the text box");
			driver.switchTo().frame(0);
			postTextArea.sendKeys(message);
			driver.switchTo().defaultContent();
			System.out.println("Entered the text in text box");
			if (shareButton.isDisplayed()) {
				shareButton.click();
				System.out.println("Clicked on the post button");
				isPostCreated = true;
			}
		}
		return isPostCreated;
	}

	public boolean isUserMenuSeen() {
		if (userMenu.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean clickOnUserMenu() {
		if (userMenu.isDisplayed()) {
			userMenu.click();
			return true;
		} else {
			return false;
		}
	}

	public boolean openEditProfileModal() {
		boolean isEditProfileWindowSeen = false;
		if (editprofilebutton.isDisplayed()) {
			editprofilebutton.click();
			if (EditProfilePopupwindow.isDisplayed()) {
				isEditProfileWindowSeen = true;
			}
		}
		return isEditProfileWindowSeen;
	}

	public boolean changeLastNameInAboutTab(WebDriver driver, String lastName) {
		driver.switchTo().frame("contactInfoContentId");
		boolean isLastNameChanged = false;
		if (Abouttab.isDisplayed()) {
			Abouttab.click();
			if (Abouttablastname.isDisplayed()) {
				Abouttablastname.clear();
				Abouttablastname.sendKeys(lastName);
				saveAllButton.click();
				isLastNameChanged = true;
			}
		}
		driver.switchTo().defaultContent();
		return isLastNameChanged;
	}

}
