package pms.test.department;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pms.core.BaseTest;

import pms.action.LoginAction;

/**
 * @author wdh
 * 添加单位
 */
public class AddDepartmentTest extends DepartmentBase{

	@Test
	public void addDepartment(){

		webtest.click("xpath=//span[contains(.,'河北省')]");
		//新增按钮
		webtest.click("xpath=//div[@class='input-group-addon h40 btn-success']");
		webtest.type("id=orgname", "财务部");
		webtest.click("id=orgtype");
		webtest.click("xpath=//option[contains(.,'行政机关')]");
		webtest.type("id=organizationCode", "85009");
		webtest.click("xpath=//a[@class='textbox-icon combo-arrow']");
		webtest.click("xpath=//span[contains(.,'桥西区')]");
		webtest.click("xpath=//button[contains(.,'保 存')]");
		Assert.assertTrue(webtest.ifContains("财务部"));
		
		
	}
	
}
