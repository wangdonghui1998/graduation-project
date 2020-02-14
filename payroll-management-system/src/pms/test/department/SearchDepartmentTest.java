package pms.test.department;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pms.core.BaseTest;
import com.pms.core.Checker;
import com.pms.dataprovider.NsDataProvider;

/**
 * @author wdh
 * 搜索单位
 */
public class SearchDepartmentTest extends DepartmentBase{
	
	@Test(dataProvider="searchDepartment",dataProviderClass=NsDataProvider.class)
	public void searchtest(String text) {
		webtest.clearAndType("xpath=//input[@id='org_select']", text);
		//断言
		Checker che = new Checker(this.getdriver());
		che.checkUL("orgTree_1_ul","城建");
	
	}
}
