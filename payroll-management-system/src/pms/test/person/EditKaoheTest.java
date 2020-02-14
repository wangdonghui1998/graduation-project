package pms.test.person;

import org.testng.annotations.Test;

/**
 * @author wdh
 * 添加和删除考核信息
 */
public class EditKaoheTest extends PersonBase{
	@Test
	public void addKaohe() {
		/**
		 * 添加考核信息
		 */
		this.pdoubleclick(1);
		webtest.getWindow(2);
		webtest.click("xpath=//a[contains(.,'06后考核信息')]");
		//点击添加按钮
		webtest.enterFrame("iframe_ryxx");
		webtest.click("xpath=//button[contains(.,'添加')]");
		webtest.leaveFrame();
	}
}
