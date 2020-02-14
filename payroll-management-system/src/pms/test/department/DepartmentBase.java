package pms.test.department;


import org.testng.annotations.BeforeClass;

import com.pms.core.BaseTest;

import pms.action.LoginAction;


/**
 * @author wdh
 * 单位管理的基础类，用来实现每个测试用例开始之前的登录和进入单位管理模块
 */
public class DepartmentBase extends BaseTest{


	@BeforeClass
	public void begin(){
		LoginAction lg = new LoginAction(webtest);
		lg.login("admin", "111111");
		webtest.click("xpath=//a[contains(.,'单位管理')]");
		//切换当前窗口
		webtest.getWindow(1);
	}
	
	

}
