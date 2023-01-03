package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;

public class AccountsPage extends BasePage {
	
	public AccountsPage(WebDriver driver, ExtentTest test) {
		PageFactory.initElements(driver, this);
		this.test = test;
	}

	@FindBy(xpath="//*[@id=\'lexBanner\']/a[3]")
	public WebElement contactsPageTellMeMoreButton;

	@FindBy(xpath="//*[@id=\'lexBanner\']/a[2]")
	public WebElement contactsPageCheckReadiness;

	@FindBy(css="#fcf")
	public WebElement contactsPageViewDropdownList;

	@FindBy(name = "go")
	public WebElement contactsPageGoButton ;

	@FindBy(css="#filter_element > div > span > span.fFooter > a:nth-child(1)")
	public WebElement contactsPageEditLink ;

	@FindBy(css="#filter_element > div > span > span.fFooter > a:nth-child(2)")
	public WebElement contactsPageCreateNewView ;

	@FindBy(css="#hotlist > table > tbody > tr > td.pbButton > input")
	public WebElement contactsPageNewButton ;

	@FindBy(xpath="//*[@id=\'hotlist_mode\']")
	public WebElement contactsPageRecentlyCreatedDropdownList ;
	
	@FindBy(css="#bodyCell > div.bRelatedList > div.hotListElement > div > div.pbBody > table")
	public WebElement contactsPageRecentContactsTable;

	@FindBy(xpath="//*[@id=\'toolsContent\']/tbody/tr/td[1]/div/div/div[2]/div/a")
	public WebElement contactsPageGoToReportsLink;

	@FindBy(xpath="//*[@id=\'sidebarDiv\']/div[3]/div/a/span")
	public WebElement contactsPageRecycleBin;

	@FindBy(xpath="#name_first")
	public WebElement contactsPageQuickCreateFirstNameTextBox;
	
	@FindBy(id="name_last")
	public WebElement contactsPageQuickCreateLastNameTextBox;

	@FindBy(css="#account")
	public WebElement contactsPageQuickCreateAccountTextBox ;

	@FindBy(css="#phone1")
	public WebElement contactsPageQuickCreatePhoneTextBox ;

	@FindBy(css="#email")
	public WebElement contactsPageQuickCreateEmailTextBox ;
	
	@FindBy(css="#account_lkwgt > img")
	public WebElement contactsPageQuickCreateAccountSearchButton ;

	@FindBy(css="#qcreate > input.btn")
	public WebElement contactsPageSaveButton;

	@FindBy(css="#toolsContent > tbody > tr > td:nth-child(2) > div > div > div")
	public WebElement contactsPageToolsTable;

	@FindBy(xpath="//*[@id=\'bodyCell\']/div[1]/div[1]/div[2]/a[1]")
	public WebElement contactsPageTellmemore;

	@FindBy(css="#bodyCell > div.bPageTitle > div.ptBody > div.links > a:nth-child(2)")
	public WebElement contactsPageHelpForThisPage;

	@FindBy(css="#lexBanner > a.zen-btn.zen-closeBtn.lexBanner.closeBtn")
	public WebElement contactsPageCloseButton;

	@FindBy(css="#createNewLabel")
	public WebElement contactsPageCreateNewDropdownList;
	
	public void selectOptionInDropdown(String  value) {
		Select select = new Select(contactsPageViewDropdownList);
		select.selectByVisibleText(value);
	}
	


}
