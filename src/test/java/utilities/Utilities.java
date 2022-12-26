package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.dockerjava.core.WebTarget;

import constants.WaitConstants;

public class Utilities {
	
	public static boolean waitForElement(WebDriver driver, WebElement element) {
		Boolean isElementClickable = false;
		WebDriverWait wait = new WebDriverWait(driver, WaitConstants.EXPLICIT_WAIT_CONSTANT);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			isElementClickable = true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return isElementClickable;
	}
	
	public static boolean waitForElementToDisappear(WebDriver driver, WebElement element) {
		Boolean isElementDisappeared = false;
		WebDriverWait wait = new WebDriverWait(driver, WaitConstants.EXPLICIT_WAIT_CONSTANT);
		try {
			wait.until(ExpectedConditions.invisibilityOf(element));
			isElementDisappeared = true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return isElementDisappeared;
	}
	public static String captureScreenshot(WebDriver driver) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		String dateFormat = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String dstPath = System.getProperty("user.dir")+"\\src\\test\\java\\screenshots\\"+dateFormat+"_sfdc.PNG";
		File dstFile = new File(dstPath);
		FileUtils.copyFile(sourceFile, dstFile);
		return dstPath;
	}
	
	public static void moveToElement(WebDriver driver, WebElement element) {
		
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		
	}
	
	public static void jsClick(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
			
}
