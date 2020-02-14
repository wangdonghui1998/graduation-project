package pms.test.department;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pms.core.BaseTest;

import pms.action.LoginAction;

/**
 * @author wdh
 * 删除单位
 */
public class DeleteDepartmentTest extends DepartmentBase{

	@Test
	public void deleteDepartment(){
		
		webtest.click("xpath=//span[contains(.,'财务部')]");
		//删除按钮
		webtest.click("xpath=//div[@class='input-group-addon h40 btn-danger']");
		webtest.click("xpath=//a[contains(.,'确定')]");
		Assert.assertFalse(webtest.ifContains("财务部"));
	}
}
