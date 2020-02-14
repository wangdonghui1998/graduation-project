package com.pms.core;
/**
 * 初始化WebDriver，建立连接
 * @author wangdonghui
 * @date 2020-01-06
*/
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.pms.utils.Log;
import com.pms.utils.ReadProperties;



public class BaseTest {
	public  WebDriverEngine webtest;
	private WebDriver driver;
	public String driverType;

	private WebDriver newWebDriver(String driverType) throws IOException {
		WebDriver driver = null;
	 if (driverType.equalsIgnoreCase("firefox")) {
		    String firefox_driver =ReadProperties.getPropValue("gecko_driver");
			String firefox_path = ReadProperties.getPropValue("firefox_path");
			System.setProperty("webdriver.gecko.driver", firefox_driver);
			System.setProperty("webdriver.firefox.bin", firefox_path);
			driver = new FirefoxDriver();
	
			Log.info("Using Firefox");
		}  else if (driverType.equalsIgnoreCase("chrome")) {
			String chrome_driver =ReadProperties.getPropValue("chrome_driver");
			//String chrome_path = ReadProperties.getPropValue("chrome_path");
			System.setProperty("webdriver.chrome.driver", chrome_driver);
			//System.setProperty("webdriver.chrome.bin",chrome_path);
		
			driver = new ChromeDriver();
			Log.info("Using Chrome");
			
		}else{
			return null;
		}
		
		return driver;

	}
	
	public WebDriver getdriver() {
		return driver;
	}
	
	
	@BeforeClass
	public void doBeforeSuite() throws Exception {

		driverType=ReadProperties.getPropValue("driverType");
		driver = this.newWebDriver(driverType);
		driver.manage().window().maximize();
		Log.info(driverType);
		webtest = new WebDriverEngine(driver);

	}


	@AfterClass
	public void doAfterMethod() {
		if(this.driver != null){
			this.driver.quit();
			}
		Log.info("Quitted Browser");
	}
	
}

