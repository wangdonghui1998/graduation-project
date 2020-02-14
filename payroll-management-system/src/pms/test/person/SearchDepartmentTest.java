package pms.test.person;

import org.testng.annotations.Test;

import com.pms.core.Checker;

/**
 * @author wdh
 * 在人员管理中搜索部门
 */
public class SearchDepartmentTest extends PersonBase{
	@Test
	public void searchDepart() {
		webtest.type("xpath=//input[@id='org_select']", "城建");
		
		//断言
		Checker che = new Checker(this.getdriver());
		che.checkUL("orgTrebasry_1_ul","城建");
	}
}
