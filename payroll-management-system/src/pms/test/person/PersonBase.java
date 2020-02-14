package pms.test.person;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;

import com.pms.core.BaseTest;

import pms.action.LoginAction;

/**
 * @author wdh
 * 用来实现每个测试用例开始之前的登录和点击进入人员管理模块
 */
public class PersonBase extends BaseTest{
	@BeforeClass
	public void login(){
		LoginAction lg = new LoginAction(webtest);
		lg.login("admin", "111111");
		webtest.click("xpath=//a[contains(.,'[单人]')]");
		//切换当前窗口
		webtest.getWindow(1);
	}
	
	public void pdoubleclick(int i) {
		/**
		 * 双击小方框---进入个人页用
		 */
		Actions action = new Actions(this.getdriver());
		action.doubleClick(this.getMessage(i).get(1)).perform();  	
		webtest.pause(3000);
	}	

	public void pclick(int i) {
		/**
		 * 点击小方框---删除操作用
		 */
		Actions action = new Actions(this.getdriver());
		action.click(this.getMessage(i).get(1)).perform();  	
		webtest.pause(3000);
		
		
	}
	
	public List<WebElement> getMessage(int i) {
		/**
		 * 双击人员条例
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
		Actions action = new Actions(this.getdriver());
		action.doubleClick(tdlist.get(1)).perform();
		webtest.pause(3000);
		
		return tdlist;

	}
}
