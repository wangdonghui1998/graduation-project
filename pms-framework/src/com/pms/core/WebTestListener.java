package com.pms.core;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * 监听器 : 用例运行中失败时,测试执行结束时发送测试报告
 * @author wangdonghui
 * @date 2020-01-06
*/
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.TestListenerAdapter;

import com.pms.utils.MailUtils;
import com.pms.utils.ReadProperties;
import com.pms.utils.ZipUtils;


public class WebTestListener extends TestListenerAdapter{
	
	public WebTestListener() {
		super();
	}
	
	
	
	@Override
	public void onFinish(final ITestContext testContext) {

		//生成压缩包
		boolean KeepDirStructure =true;
		try {
			FileOutputStream out = new FileOutputStream(ReadProperties.getPropValue("out"));			
			ZipUtils.toZip(ReadProperties.getPropValue("srcDir"),out, KeepDirStructure);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//发送邮件
		String filepath = ReadProperties.getPropValue("filepath");
		String receive = ReadProperties.getPropValue("receive");

		try {
			MailUtils.sendEmail(receive, "测试报告", "测试", filepath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

