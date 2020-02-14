package pms.test.changpinperson;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;

import com.pms.core.BaseTest;

import pms.action.LoginAction;

/**
 * @author wdh
 *  长聘人员的基础类，用来实现每个测试用例开始之前的登录和进入长聘人员模块
 */
public class CPPersonBase extends BaseTest{
	@BeforeClass
	public void begin(){
		LoginAction lg = new LoginAction(webtest);
		lg.login("admin", "111111");
		webtest.click("xpath=//a[contains(.,'长聘人员')]");
		//切换当前窗口
		webtest.getWindow(1);
	}
		

	public void pclick(int i) {
		/**
		 * 点击小方框---删除操作用
		 */
		Actions action = new Actions(this.getdriver());
		action.click(this.getMessage(i).get(1)).perform();  	
		webtest.pause(3000);
	}
	
	private List<WebElement> getMessage(int i) {
		/**
		 * 获取人员条例
		 * @param i 第几行信息
		 */
		List<WebElement> trlist = this.getdriver().findElement(By.className("datagrid-btable")).findElements(By.tagName("tr"));
		
		try {
			if(i>trlist.size() || i<=0) {
				System.out.print("选择人员不正确");
			}
		}catch(Exception e){
			System.out.println(e);
		}
		List<WebElement> tdlist = trlist.get(i-1).findElements(By.tagName("td"));
		
		return tdlist;
	}
	

}
