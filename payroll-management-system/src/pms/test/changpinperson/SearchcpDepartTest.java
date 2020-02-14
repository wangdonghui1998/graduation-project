package pms.test.changpinperson;

import org.testng.annotations.Test;

import com.pms.core.Checker;

/**
 * @author wdh
 * 搜索单位
 */
public class SearchcpDepartTest extends CPPersonBase{
	
	@Test
	public void searchDepart() {
		webtest.type("xpath=//input[@value='单位搜索']","城建");
		//断言
		Checker che = new Checker(this.getdriver());
		che.checkUL("orgTresalcp_1_ul","城建");
		
	}
}
