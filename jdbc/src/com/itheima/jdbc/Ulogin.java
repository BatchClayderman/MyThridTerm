package com.itheima.jdbc;

import java.sql.*;
import java.util.*;

import com.itheima.jdbc.InitialData.MD5Util;

public class Ulogin
{
	public static boolean checkValidString(String toCheck, int char_length)//过滤特殊字符
	{
		if (toCheck.length() >= char_length)
			return false;
		for (int i = 0; i < toCheck.length(); ++i)
			if (
				(toCheck.charAt(i) != ' ' && toCheck.charAt(i) <= '/')
				|| (toCheck.charAt(i) >= ':' && toCheck.charAt(i) <= '@')
				|| (toCheck.charAt(i) >= '[' && toCheck.charAt(i) <= '`')
				|| (toCheck.charAt(i) >= '{' && toCheck.charAt(i) <= 127)
			)
				return false;
		return true;
	}
	
	public static void main(String[] args) throws SQLException
	{
		/* 参数 */
		String sql_name = "jdbc", table_name = "user";
		int char_length = 48, connection_port = 3306;
		String username = "root", password = "123456";
		String[] fields = { "uid", "uname", "upwd", "umajor", "utype" };
		
		/* 初始化连接变量 */
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:" + connection_port + "/" + sql_name + "?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
			conn = DriverManager.getConnection(url, username, password);
			stmt = conn.createStatement();
			System.out.println("/********** 用户登录 **********/");
			System.out.print("请输入用户名：");
			Scanner sc = new Scanner(System.in);
			String uname = sc.nextLine();
			if (!checkValidString(uname, char_length))
				System.out.println("非法用户！");
			else
			{
				System.out.print("请输入密码：");
				String upwd = sc.nextLine();// IDE 无法实现字符隐藏
				sc.close();
				String md5pwd = MD5Util.getMD5str(upwd);
				String sql = "select " + fields[0] + " from " + table_name + " where " + fields[1] + "='" + uname + "' and " + fields[2] + "='" + md5pwd + "'";//用户名与密码同时匹配才可登录
				rs = stmt.executeQuery(sql);
				if (rs.next())
					System.out.println("登录成功！");
				else
					System.out.println("登录失败，请检查您的用户名或密码是否有误！");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (rs !=  null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
		return;
	}
}
