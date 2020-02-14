package com.pms.core;
/**
 * 元素定位
 * @author wangdonghui
 * @date 2020-01-06
*/
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pms.utils.Log;



public class ElementFinder {
	WebDriver driver;
	public ElementFinder(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public WebElement findElement(String target) {
		WebElement element = null;

		try {
			element = findElementByPrefix(target);
		} catch (Exception e) {

			Log.info(e.toString());
		}
		return element;

	}
	
	/**
	 * 通过前缀进行元素定位
	 * @param locator 元素位置
	 */
	public WebElement findElementByPrefix(String locator) {
		String target = locator.trim();  //去掉字符串首尾空格
		if(target.startsWith("id=")) 
		{
			target = target.substring("id=".length());
			return driver.findElement(By.id(target)); 
		}else if(target.startsWith("class=")) 
		{
			target = target.substring("class=".length());
			return driver.findElement(By.className(target)); 
		}else if(target.startsWith("name=")) 
		{
			target = target.substring("name=".length());
			return driver.findElement(By.name(target)); 
		}else if(target.startsWith("xpath=")) 
		{
			target = target.substring("xpath=".length());
			return driver.findElement(By.xpath(target)); 
		}else if(target.startsWith("link=")) 
		{
			target = target.substring("link=".length());
			return driver.findElement(By.linkText(target)); 
		}else if(target.startsWith("css=")) 
		{
			target = target.substring("css=".length());
			return driver.findElement(By.cssSelector(target)); 
		}else if(target.startsWith("tag=")) 
		{
			target = target.substring("tag=".length());
			return driver.findElement(By.tagName(target)); 
		}
		else {
			Log.info(locator+"can't find element by prefix.");
			return null;
		}
		
	}
	

}
