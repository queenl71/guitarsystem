package com.guitar.servlet;
/**
 * 测试获取当前项目路径
 * @author lzm
 *
 */
public class TestClass {
	public static void main(String[] args) {
		try {
			Class clazz = Class.forName("com.guitar.tables.Guitar");
			String path = clazz.getClass().getResource("/").getPath();
			System.out.println(path);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}	
