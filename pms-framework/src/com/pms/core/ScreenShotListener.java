package com.pms.core;
/**
 * 截屏
 * @author wangdonghui
 * @date 2020-01-06
*/

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.pms.utils.ReadProperties;


public class ScreenShotListener  extends TestListenerAdapter{
	
	@Override
	public void onTestFailure(ITestResult tr){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
		String nowDateTime=sdf.format(new Date());
		BaseTest tb = (BaseTest) tr.getInstance();
        WebDriver driver = tb.getdriver();
		File s_file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(s_file, new File(ReadProperties.getPropValue("screenshot_path")+nowDateTime+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}

