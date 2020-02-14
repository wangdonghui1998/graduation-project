package pms.test.manger;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pms.core.BaseTest;

import pms.action.ChangePasswordAction;
import pms.action.LoginAction;

/**
 * 修改密码
 * @author wdh
 */
public class ChangePasswordTest extends BaseTest{
	@BeforeClass
	public void login() {
		LoginAction lg = new LoginAction(webtest);
		lg.login("admin", "111111");
	}
	
	@Test
	public void ChangePassword_success() {
		ChangePasswordAction cpa = new ChangePasswordAction(webtest);
		cpa.ChangePassword("111111", "123456");
		//断言新密码能登录成功
		LoginAction lg = new LoginAction(webtest);
		lg.login("admin", "123456");
		//再次把密码改回，方便接下来的测试
		cpa.ChangePassword("123456", "111111");
	}
	
}
