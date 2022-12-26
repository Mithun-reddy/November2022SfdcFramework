package tests;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.observer.ExtentObserver;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.BasePage;

public class BaseTest {
	
	protected static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();
	public static ExtentReports extent = null;
	protected static Logger logger = LogManager.getLogger(BasePage.class.getName());
	
	@BeforeMethod
	public void setDriver() {
		logger.info("setDriver(): Initiated");
		WebDriver driver = BaseTest.getBrowserType("chrome", false);
		threadLocalDriver.set(driver);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}
	
	public static WebDriver getDriver() {
		return threadLocalDriver.get();
	}
	
	@AfterMethod
	public void removeDriver() {
		getDriver().quit();
		threadLocalDriver.remove();
		logger.info("removeDriver(): success");
	}
	
	@BeforeSuite
	public void setUp() {
		configureExtentReport();
		logger.info("setUp(): success");
	}
	
	@AfterSuite
	public void tearDown() {
		extent.flush();
		logger.info("tearDown(): success");
	}
	
	public static void configureExtentReport() {
		String dateFormat = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String reportPath = System.getProperty("user.dir")+"\\src\\test\\java\\reports\\"+ dateFormat+"_sfdc.html";
		extent = new ExtentReports();
		ExtentSparkReporter sparkHtml = new ExtentSparkReporter(reportPath);
		extent.attachReporter(sparkHtml);
		logger.info("configureExtentReport(): success");
		
	}

	/**
	 * This method configures the browser dynamically with headless mode.
	 * @param browserName should be either of the string 'chrome', 'firefox', 'edge', 'safari'
	 * @param headless set to true to run in headless mode
	 * @return driver object, on wrong param returns null
	 */
	public static WebDriver getBrowserType(String browserName, boolean headless) {
		logger.info("getBrowserType(): Initiated");
		String browser = browserName.toLowerCase();
		WebDriver driver = null;
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			logger.info("getBrowserType(): Chromedriver setup complete");
			if(headless) {
				ChromeOptions co = new ChromeOptions();
				co.addArguments("--headless");
				driver = new ChromeDriver(co);
				logger.info("getBrowserType(): Chromedriver configured with headless mode");
			} else {
				driver = new ChromeDriver();
				logger.info("getBrowserType(): Chromedriver configured");
			}
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			logger.info("getBrowserType(): firefox setup complete");
			if(headless) {
				FirefoxOptions fo = new FirefoxOptions();
				fo.addArguments("--headless");
				logger.info("getBrowserType(): firefox configured with headless mode");
				driver = new FirefoxDriver(fo);
			} else {
				driver = new FirefoxDriver();
				logger.info("getBrowserType(): firefox browser configured");
			}
			break;

		case "safari":
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			break;
		
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
			
		default:
			System.out.println("Provide a right input browsers supported are: 'chrome', 'firefox', 'edge', 'safari'");
			
		}
		return driver;
	}

}
