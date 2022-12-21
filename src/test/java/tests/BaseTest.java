package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	/**
	 * This method configures the browser dynamically with headless mode.
	 * @param browserName should be either of the string 'chrome', 'firefox', 'edge', 'safari'
	 * @param headless set to true to run in headless mode
	 * @return driver object, on wrong param returns null
	 */
	public static WebDriver getBrowserType(String browserName, boolean headless) {
		String browser = browserName.toLowerCase();
		WebDriver driver = null;
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			if(headless) {
				ChromeOptions co = new ChromeOptions();
				co.addArguments("--headless");
				driver = new ChromeDriver(co);
			} else {
				driver = new ChromeDriver();
			}
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			if(headless) {
				FirefoxOptions fo = new FirefoxOptions();
				fo.addArguments("--headless");
				driver = new FirefoxDriver(fo);
			} else {
				driver = new FirefoxDriver();
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
