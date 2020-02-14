package pms.test.manger;
/**
 * @author wangdonghui
 * @date 2020-01-07
*/
import org.testng.annotations.Test;

import com.pms.core.BaseTest;

import pms.action.LogoutAction;

public class LogoutTest extends BaseTest{
	@Test
	public void logout_success() {
		LogoutAction lgt = new LogoutAction(webtest);
		lgt.logout();
	}
	
	
}

