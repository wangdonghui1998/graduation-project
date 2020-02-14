package pms.action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;

import com.pms.core.WebDriverEngine;

/**
 * 注销操作
 * @author wangdonghui
*/
public class LogoutAction {
	public  WebDriverEngine webtest;
	public LoginAction lg;
	
	public LogoutAction(WebDriverEngine webtest) {
		this.webtest = webtest;
		lg = new LoginAction(webtest);
	}
	
	public void logout() {
		lg.login("admin", "111111");
		
		webtest.tapClick();
		webtest.tapEnter();		
		webtest.click("class=layui-layer-btn0");
		
		Assert.assertTrue(webtest.ifContains("登录"));
	}
}

