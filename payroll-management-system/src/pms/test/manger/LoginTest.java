package pms.test.manger;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pms.core.BaseTest;

import pms.action.LoginAction;

/**
 * @author wangdonghui
 * @date 2020-01-06
*/
public class LoginTest extends BaseTest{
	
	@Test
	public void login_success() {
		LoginAction login = new LoginAction(webtest);
		login.login("admin", "111111");
		Assert.assertTrue(webtest.ifContains("注销"));
	}
	
	@Test
	public void login_fail() {
		LoginAction login = new LoginAction(webtest);
		login.login("admin", "11111");
		Assert.assertFalse(webtest.ifContains("注销"));
	}
}
