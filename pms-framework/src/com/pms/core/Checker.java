package com.pms.core;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * @author wdh 查询功能后的断言
 */
public class Checker {
	public WebDriver driver = null;

	public Checker(WebDriver driver) {
		this.driver = driver;
	}

	public void checkUL(String ulid, String checktext) {
		/**
		 * 检查ul li 列表
		 * 
		 * @param ulid
		 *            第一次筛选的ul的id
		 * @param checktext
		 *            要检查的内容
		 */
		List<WebElement> ulstr = driver.findElement(By.id(ulid)).findElements(By.tagName("li"));
		int i = 0;
		while (i < ulstr.size()) {
			if (ulstr.get(i).getText().contains(checktext)) {
				System.out.printf(ulstr.get(i).getText());
				i++;
			} else {
				System.out.printf("断言失败");
				Assert.assertEquals(" ", "");
			}
		}
	}

	public void checkTable(String tableid,String option, String name) {
		/**
		 * 检查table表格
		 */

		// 查询表格
		List<WebElement> trlist = driver.findElement(By.className(tableid)).findElements(By.tagName("tr"));
		int i = 0;
		while (i < trlist.size()) {

			// 得到表格中所有的td
			List<WebElement> tdlist = trlist.get(i).findElements(By.tagName("td"));
			String name1 = null;
			// 看是按姓名还是身份证查询人员
			switch (option) {
			case "xm":
				name1 = tdlist.get(this.getnum("姓名")).getText();
				break;
			case "sfz":
				name1 = tdlist.get(this.getnum("身份证")).getText();
				break;
			}

			System.out.printf(name1);

			if (name1.contains(name)) {
				i++;
			} else {
				System.out.println("断言失败");
				Assert.assertEquals(" ", "");
			}
		}

	}

	
	private int getnum(String option) {
		/**
		 * 查询表头,找到身份证和姓名的位置
		 * @return num 姓名或者身份证行所在表格的第几列
		 */
		List<WebElement> headtd = driver.findElement(By.className("datagrid-header-row"))
				.findElements(By.tagName("td"));
		int count = 0;
		int num = 0;
		while (count < headtd.size()) {
			String op = headtd.get(count).getText();
			if(op.contains(option)) {
				num=count;
				break;
			}
			count++;
		}
		System.out.println(num);
		return num;
	}
	
	public int getSize(String tableid) {
		List<WebElement> trlist = driver.findElement(By.className(tableid)).findElements(By.tagName("tr"));
		return trlist.size();
	}
	
}
