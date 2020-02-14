package pms.test.reportcenter;

import java.io.File;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jacob.com.LibraryLoader;
import com.pms.core.BaseTest;

import autoitx4java.AutoItX;
import pms.action.LoginAction;

/**
 * @author wdh
 * 下载报表到本地
 */
public class DownloadTableTest extends BaseTest{
	@BeforeClass
	public void begin(){
		LoginAction lg = new LoginAction(webtest);
		lg.login("admin", "111111");
		webtest.click("xpath=//a[contains(.,'报表中心')]");
		//切换当前窗口
		webtest.getWindow(1);
	}
	
	@Test
	public void downloadTable() {
		webtest.type("xpath=//input[@id='_easyui_textbox_input1']","新录用");
		webtest.click("xpath=//span[contains(.,'新录用')]");
		webtest.type("xpath=//input[@id='_easyui_textbox_input2']", "城建局");
		webtest.click("xpath=//span[contains(.,'城建局')]");
		
		webtest.click("xpath=//a[contains(.,'检索人员')]");
		webtest.doubleclick("xpath=//span[contains(.,'一、机关在职日常变动审核表')]");
		webtest.click("xpath=//span[contains(.,'1.1工资方案表一')]");
		//切换当前窗口
		webtest.getWindow(2);
		webtest.click("xpath=//button[contains(.,'下载')]");
		//启用autoit

		AutoItX x = new AutoItX();
		x.controlClick("另存为", "保存(&S)", "1");
		
	}
}
