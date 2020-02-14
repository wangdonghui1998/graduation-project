package pms.test.changpinperson;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author wdh
 * 添加长聘人员
 */
public class AddcpPersonTest extends CPPersonBase{

	@Test
	public void addPerson_CP() {
		webtest.click("xpath=//button[contains(.,'添加')]");
		webtest.enterFrame("layui-layer-iframe1");
		webtest.type("xpath=//input[@id='xm']", "陆一");
		webtest.click("xpath=//input[@id='orgname']");
		webtest.doubleclick("xpath=//span[contains(.,'城建局')]");
		webtest.type("id=sfzh", "130928199001073830");
		webtest.type("xpath=//input[@id='cjgzsj']", "2016-10-01");
		webtest.type("xpath=//input[@id='jdwsj']", "2017-10-01");
		webtest.type("xpath=//input[@id='bdrq']", "2018-01-01");
		webtest.click("xpath=//button[@class='btn btn-info']");
		webtest.leaveFrame();
		//断言
		Assert.assertTrue(webtest.ifContains("130928199001073830"));
	}
	
	
}
