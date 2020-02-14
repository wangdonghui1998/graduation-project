package pms.test.person;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pms.core.Checker;

/**
 * @author wdh
 * 删除人员
 */
public class DeletePersonTest extends PersonBase{
	@Test
	public void deletePerson() {
		Checker che = new Checker(this.getdriver()); 
		int oldsize=che.getSize("datagrid-btable");	
		this.pclick(1);
		webtest.click("xpath=//button[contains(.,'删除')]");
		webtest.click("xpath=//a[contains(.,'确定')]");
		int newsize=che.getSize("datagrid-btable");
		//利用删除前的表格长度与删除后的表格长度做对比
		Assert.assertTrue(oldsize-1==newsize);
	}

}
