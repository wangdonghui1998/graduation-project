package com.pms.utils;
/**
 * 读取properties文件中的参数
 * @author wangdonghui
 * @date 2020-01-03
*/
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadProperties {
	private static final String filePath="conf/config.properties";
	/**
	 * @param key	获得conf.properties文件中的变量名
	*/
	public static String getPropValue(String key){
		Properties prop = new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream(filePath);
			prop.load(fis);
			fis.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop.getProperty(key);
	}
}

