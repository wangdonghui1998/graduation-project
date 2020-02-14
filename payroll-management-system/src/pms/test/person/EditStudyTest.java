package pms.test.person;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pms.core.Checker;

/**
 * @author wdh
 * 添加学历信息和删除学历信息
 */
public class EditStudyTest extends PersonBase{

	@Test
	public void addXLXX() {
		/**
		 * 添加学历信息
		 */
		this.pdoubleclick(1);
		webtest.getWindow(2);
		
		webtest.click("xpath=//a[contains(.,'学历信息')]");
		//点击添加按钮
		webtest.enterFrame("iframe_ryxx");
		webtest.click("xpath=//button[contains(.,'添加')]");
		webtest.leaveFrame();
		
		webtest.enterFrame("layui-layer-iframe1");
		webtest.click("id=xl");
		webtest.click("xpath=//option[@value='000100070007']");
		webtest.type("id=rxrq", "2010-09-01");
		webtest.type("id=byrq", "2014-06-01");
		webtest.click("xpath=//button[@class='btn btn-info']");
		//断言
		//Assert.assertTrue(webtest.ifContains("大学本科"));
	}
	
//	@Test
//	public void deleteXLXX() {
//		/**
//		 * 删除学历信息
//		 */
//		this.pdoubleclick(1);
//		webtest.getWindow(2);
//		
//		webtest.click("xpath=//a[contains(.,'学历信息')]");
//		webtest.enterFrame("iframe_ryxx");
//		webtest.click("xpath=//input[@class='cbox']");
//		webtest.click("xpath=//button[contains(.,'删除')]");	
//		webtest.click("xpath=//a[contains(.,'确定')]");	
//		
//		//断言
//		//Assert.assertFalse(webtest.ifContains("大学本科"));
//	}
//	

}
