package com.pms.core;
import static org.testng.Assert.assertTrue;

/**
 * 元素操作
 * @author wangdonghui
 * @date 2020-01-06
*/
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.pms.utils.Log;

public class WebDriverEngine {
	public WebDriver driver = null;
	ElementFinder finder = null;
	Actions action = null;
	
	
	public WebDriverEngine(WebDriver driver) {
		this.driver = driver;
		driver.manage().window().maximize();
		finder = new ElementFinder(driver);
		action = new Actions(driver);
	}
	
	
	
	public void runJs(String js) {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript(js);
	}
	
	/**打开网址*/
	public void open(String url) {

		try {
			driver.get(url);
			pause(3000);
		} catch (Exception e) {
			e.printStackTrace();

		}
		Log.info("Opened url " + url);
	}
		
	public void enterFrame(String frameID) {
		this.pause(3000);
		driver.switchTo().frame(frameID);
		Log.info("进入ifream " + frameID);	
	}
	
	public void enterFrame(int frameID) {
		this.pause(3000);
		driver.switchTo().frame(frameID);
		Log.info("进入ifream " + frameID);	
	}
	
	public void leaveFrame() {
		driver.switchTo().defaultContent();
		Log.info("退出ifream ");
	}
	
	/**点击对话框中的确认*/
	public void acceptAlert() {
		driver.switchTo().alert().accept();;
		Log.info("进入alert ");	
	}
	
	public void click(String locator) {
		WebElement element = finder.findElement(locator);
		if(element != null) {
			element.click();
			this.pause(3000);
		}
	}
	public void click(int weight,int hight) {
		action.moveByOffset(weight, hight).click().perform();
	}
	
	public void doubleclick(String locator) {
		WebElement element = finder.findElement(locator);
		action.doubleClick(element).perform();
		this.pause(3000);
	}
	
	public void type(String locator,String value) {
		WebElement element = finder.findElement(locator);
		if(element != null) {
			element.sendKeys(value);
			this.pause(3000);
		}
	}
	
	public void clearAndType(String locator,String value) {
		WebElement element = finder.findElement(locator);
		if(element != null) {
			element.clear();
			element.sendKeys(value);
			this.pause(3000);
		}
	}
	
	/**
	 * 得到定位元素的value值
	 * @param locator 元素位置
	 */
	public String getValue(String locator) {

		return finder.findElement(locator).getAttribute("value");
	}
	
	/**得到现在的URL*/
	public String getUrl() {
		return driver.getCurrentUrl();
	}
	
	public void goBack() {
		driver.navigate().back();
	}
	
	public void goForward() {
		driver.navigate().forward();
	}
	
	/**返回弹出框*/
	public Alert getAlert() {
		Alert alert = driver.switchTo().alert();
		return alert;
	}
	
	public Select getSelect(String locator) {
		Select inputSelect = new Select(finder.findElement(locator));
		return inputSelect;
	}
	
	/**
	 * 根据元素的value值进行筛选
	 * @param locator 元素位置
	 * @param value  
	 */
	public void selectByValue(String locator, String value) {
		getSelect(locator).selectByValue(value);
		this.pause(3000);
	}
	
	/**根据已显示的文本进行筛选*/
	public void selectByVisibleText(String locator, String value) {
		getSelect(locator).selectByVisibleText(value);
	}
	
	/**根据序号进行筛选*/
	public void selectByIndex(String locator, int index) {
		getSelect(locator).selectByIndex(index);
	}
	
	/**得到弹出框文字*/
	public String getAlertText() {
		return getAlert().getText();
	}
	
	/**得到页面源代码*/
	public String getHtmlSource() {
		return driver.getPageSource();
	}
	
	public void tapClick(){		
		action.sendKeys(Keys.TAB).perform();
		this.pause(2000);
	}
	
	public void tapDown(){	
		action.sendKeys(Keys.DOWN).perform();
		this.pause(1000);
	}
	
	public void tapEnter(){	
		action.sendKeys(Keys.ENTER).perform();
		this.pause(2000);
	}
	
	public void tapBack(){
		action.sendKeys(Keys.BACK_SPACE).perform();
		this.pause(1000);
	}
	
	public void tapType(String content){	
		action.sendKeys(content).perform();
		this.pause(1000);
	}
	
	/**
	 * 不同窗口之间进行跳转
	 * @param order  第几个窗口
	 */
	public void getWindow(int order){
		List<String> windows = new ArrayList<String>();
		for (String handle : driver.getWindowHandles())
		{
			//System.out.println(handle); 
			windows.add(handle);
		}
		driver.switchTo().window(windows.get(order));
	}

	/**
	 * 页面中是否包含指定内容
	 * @param content  指定包含的内容
	 */
	public boolean ifContains(String content) {
		return driver.getPageSource().contains(content);
	}
	
	public void pause(int time) {
		if(time <= 0) {
			return;
		}
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
