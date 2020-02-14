package pms.test.changpinperson;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pms.core.Checker;

/**
 * @author wdh
 * 删除长聘人员
 */
public class DeletecpPersonTest extends CPPersonBase{
	@Test
	public void deletePerson_CP() {
		this.pclick(2);
		webtest.click("xpath=//button[contains(.,'删除')]");
		
		Checker che = new Checker(this.getdriver()); 
		int oldsize=che.getSize("datagrid-btable");	
		
		webtest.click("xpath=//a[contains(.,'确定')]");
		
		//断言,利用删除前的表格长度与删除后的表格长度做对比
		int newsize=che.getSize("datagrid-btable");
		Assert.assertTrue(oldsize-1==newsize);
	}
}
