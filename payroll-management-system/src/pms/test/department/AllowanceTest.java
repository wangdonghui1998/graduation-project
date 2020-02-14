package pms.test.department;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author wdh
 * 添加津贴
 */
public class AllowanceTest extends DepartmentBase{
	@Test
	public void addAllowance() {
		webtest.click("xpath=//span[contains(.,'城建局')]");
		webtest.click("xpath=//a[@id='a_jbtxx']");
		webtest.getWindow(2);
		webtest.click("xpath=//button[contains(.,'添加')]");
		webtest.enterFrame("layui-layer-iframe1");
		webtest.click("xpath=//span[@id='treeDemo_2_span']");
		webtest.click("xpath=//input[contains(@id,'1')]");
		webtest.click("xpath=//button[contains(.,'保存')]");
		Assert.assertTrue(webtest.ifContains("河北省直"));
		
	}
	
	@Test
	public void deleteAllowance() {
		webtest.click("xpath=//span[contains(.,'城建局')]");
		webtest.click("xpath=//a[@id='a_jbtxx']");
		webtest.getWindow(2);
		webtest.click("xpath=//input[@class='cbox cbox']");
		webtest.click("xpath=//button[contains(.,'删除')]");
		webtest.click("xpath=//a[contains(.,'确定')]");
		Assert.assertFalse(webtest.ifContains("河北省直"));
	}
}
