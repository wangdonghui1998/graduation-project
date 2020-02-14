package com.pms.demo;

import java.io.File;

import com.jacob.com.LibraryLoader;

import autoitx4java.AutoItX;

/**调试autoit :打开记事本
 * @author wangdonghui
 */
public class opennote {

	public static void main(String[] args) {

		File file = new File("lib", "jacob-1.19-x64.dll"); // path to the jacob dll
		System.setProperty(LibraryLoader.JACOB_DLL_PATH, file.getAbsolutePath());

		AutoItX x = new AutoItX();
		
		String notepad = "无标题";
		String testString = "this is a test.";
		// x.run("notepad.exe");这个不行，必须要加参数
		x.run("notepad", "C:/Windows/System32", AutoItX.SW_MAXIMIZE);
	}
}
