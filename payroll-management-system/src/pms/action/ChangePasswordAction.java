package pms.action;

import org.testng.Assert;

import com.pms.core.WebDriverEngine;
import com.pms.utils.ReadProperties;

/**
 * @author wdh
 */
public class ChangePasswordAction {
	
	public  WebDriverEngine webtest;
	public ChangePasswordAction(WebDriverEngine webtest) {
		this.webtest = webtest;
	}
	
	public void ChangePassword(String oldpass,String newpassword) {		
		webtest.tapClick();
		webtest.tapClick();
		webtest.tapEnter();	
		//进入ifream
		webtest.enterFrame("layui-layer-iframe1");
		webtest.type("id=oldpwd", oldpass);
		webtest.type("id=pwd", newpassword);
		webtest.type("id=pwd1", newpassword);
		webtest.tapClick();
		webtest.tapEnter();	
		//退出ifream
		webtest.leaveFrame();
	}
	
}
