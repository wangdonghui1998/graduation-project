package pms.test.person;

import org.testng.annotations.Test;

import com.pms.core.Checker;

/**
 * @author wdh
 * 搜索人员
 */
public class SearchPersonTest extends PersonBase{
	
	@Test
	public void searchPersonByXM() {
		webtest.type("id=xm", "王");
		webtest.click("xpath=//button[@class='btn btn-success mr10']");
		//断言
		Checker che = new Checker(this.getdriver());
		che.checkTable("datagrid-btable","xm","王");
		
	}
	
	@Test
	public void searchPersonBySFZ() {
		webtest.type("id=sfz", "130928");
		webtest.click("xpath=//button[@class='btn btn-success mr10']");
		//断言
		Checker che = new Checker(this.getdriver());
		che.checkTable("datagrid-btable","sfz","130928");
		
	}
}
