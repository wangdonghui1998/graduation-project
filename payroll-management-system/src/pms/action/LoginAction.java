package pms.action;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.pms.core.WebDriverEngine;
import com.pms.utils.ReadProperties;

/**
 * 登录方法的封装
 * @author wangdonghui
*/
public class LoginAction {
	public  WebDriverEngine webtest;
	
	public LoginAction(WebDriverEngine webtest) {
		this.webtest = webtest;
	}
	
	public void login(String username,String password) {
		webtest.open(ReadProperties.getPropValue("BaseUrl"));
		webtest.type("id=loginname", username);
		webtest.type("id=password", password);
		webtest.tapClick();
		webtest.tapEnter();
		webtest.pause(3000);
		
	}
}
 