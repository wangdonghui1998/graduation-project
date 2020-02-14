package pms.test.person;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pms.core.BaseTest;

import pms.action.LoginAction;

/**
 * @author wdh
 * 添加人员
 */
public class AddPersonTest extends PersonBase{
	
	@Test
	public void addPerson() {
		//点击新增
		webtest.tapClick();
		webtest.tapEnter();
		webtest.enterFrame("layui-layer-iframe1");
		webtest.click("id=orgname");
		webtest.doubleclick("xpath=//span[contains(.,'城建局')]");
		webtest.click("id=rylbname");
		webtest.doubleclick("xpath=//span[contains(.,'事业')]");
		webtest.type("id=xm", "李一");
		webtest.type("id=sfz", "110101199003072674");
		webtest.type("id=cjgzrq", "2016-01-01");
		webtest.click("id=mz");
		webtest.click("xpath=//option[contains(.,'汉族')]");
		webtest.click("id=ryzt");
		webtest.click("xpath=//option[contains(.,'在职')]");
		webtest.click("xpath=//button[@type='submit']");
		Assert.assertTrue(webtest.ifContains("110101199003072674"));
	}
}
