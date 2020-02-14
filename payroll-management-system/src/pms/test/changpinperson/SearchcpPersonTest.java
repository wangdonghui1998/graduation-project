package pms.test.changpinperson;

import org.testng.annotations.Test;

import com.pms.core.Checker;

/**
 * @author wdh
 * 搜索人员
 */
public class SearchcpPersonTest extends CPPersonBase{
	
	@Test
	public void SearchByXM() {
		webtest.type("xpath=//input[@id='xm']","陆");
		webtest.click("xpath=//button[contains(.,'查询')]");
		//断言
		Checker che = new Checker(this.getdriver());
		che.checkTable("datagrid-btable","xm","陆");
	}
	
	@Test
	public void SearchBySFZ() {
		webtest.type("xpath=//input[@id='sfzh']","130928");
		webtest.click("xpath=//button[contains(.,'查询')]");
		//断言
		Checker che = new Checker(this.getdriver());
		che.checkTable("datagrid-btable","sfz","130928");
	}
}
