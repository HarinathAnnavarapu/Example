package wd.methods;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeMethods implements WdMethods{

	public RemoteWebDriver driver = null;
	int i = 1;
	/**
	 * This method will launch the given browser and 
	 * maximise the browser and set the wait for 30 seconds 
	 * and load the url
	 * @author Babu - TestLeaf
	 * @param browser - The browser of the application to be launched
	 * @param url - The url with http or https
	 * 		 * 
	 */
	public void startApp(String browser, String url) {

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}		
		driver.get(url);		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("The browser "+browser+" is launched");
		takeSnap();
	}

	public WebElement locateElement(String locator, String locValue) {
		WebElement element = null;
		switch (locator) {
		case "id":element = driver.findElementById(locValue);			
		break;
		case "class":element = driver.findElementByClassName(locValue);			
		break;
		}
		return element;
	}

	public void type(WebElement ele, String data) {
		ele.clear();
		ele.sendKeys(data);
		System.out.println("The text field is entered with "+data);
		takeSnap();
	}

	public void click(WebElement ele) {
		ele.click();
		System.out.println("The button/link is clicked");
		takeSnap();
	}

	public void clickWithNoSnap(WebElement ele) {
		// TODO Auto-generated method stub

	}

	public String getText(WebElement ele) {
		// TODO Auto-generated method stub
		return null;
	}

	public void selectDropDownUsingText(WebElement ele, String value) {
		// TODO Auto-generated method stub

	}

	public void selectDropDownUsingIndex(WebElement ele, int index) {
		// TODO Auto-generated method stub

	}

	public void verifyTitle(String expectedTitle) {
		// TODO Auto-generated method stub

	}

	public void verifyExactText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub

	}

	public void verifyPartialText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub

	}

	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub

	}

	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub

	}

	public void verifySelected(WebElement ele) {
		// TODO Auto-generated method stub

	}

	public void verifyDisplayed(WebElement ele) {
		// TODO Auto-generated method stub

	}

	public void switchToWindow(int index) {
		// TODO Auto-generated method stub

	}

	public void switchToFrame(WebElement ele) {
		// TODO Auto-generated method stub

	}

	public void acceptAlert() {
		// TODO Auto-generated method stub

	}

	public void dismissAlert() {
		// TODO Auto-generated method stub

	}

	public String getAlertText() {
		// TODO Auto-generated method stub
		return null;
	}

	public void takeSnap() {
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snaps/snap"+i+".jpg");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		i++;		

	}

	public void closeBrowser() {
		driver.close();
		System.out.println("The browser is closed");

	}

	public void closeAllBrowsers() {
		driver.quit();
		System.out.println("All the browsers are closed");
	}

}
