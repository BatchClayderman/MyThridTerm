package com.itheima.jdbc;

import java.util.*;
import java.sql.*;

public class Uaccuratesearch
{
	public static boolean checkValid(String toCheck, int char_length)//过滤特殊字符
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
	
	public static String joinArray(String sep, String[] arr)
	{
		if (arr.length <= 0)
			return "";
		String sRet = arr[0];
		for (int i = 1; i < arr.length; ++i)
			sRet += sep + arr[i];
		return sRet;
	}
	
	public static void main(String[] args) throws SQLException
	{
		/* 参数 */
		String sql_name = "jdbc", table_name = "user";
		int id_length = 15, char_length = 48, connection_port = 3306;
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
			System.out.print("请选择精准查询方式（序号查询请输入“A”，姓名查询请输入“B”）：");
			Scanner sc = new Scanner(System.in);
			String op = sc.nextLine();

			switch(op)
			{
			case "A":
			case "a":
				System.out.print("请输入待查询的 " + fields[0] + "：");
				String idsc = sc.nextLine();
				if (idsc.length() >= id_length)
				{
					System.out.println("无效 " + fields[0] + "，程序已退出。");
					if (stmt != null)
						stmt.close();
					if (conn != null)
						conn.close();
					sc.close();
					return;
				}
				for (int i = 0; i < idsc.length(); ++i)
					if (idsc.charAt(i) < '0' || idsc.charAt(i) > '9')
					{
						System.out.println("非法输入，程序已退出。");
						if (stmt != null)
							stmt.close();
						if (conn != null)
							conn.close();
						sc.close();
						return;
					}
				String sqlid = "select * from " + table_name + " where " + fields[0] + " like '" + idsc + "'";
				rs=stmt.executeQuery(sqlid);
				break;
			case "B":
			case "b":
				System.out.print("请输入待查询的 " + fields[1] + "：");
				String unamesc = sc.nextLine();
				if (!checkValid(unamesc, char_length))//检查可能导致的注入
				{
					System.out.println("非法输入，程序已退出。");
					if (stmt != null)
						stmt.close();
					if (conn != null)
						conn.close();
					sc.close();
					return;
				}
				String sqlname = "select * from " + table_name + " where " + fields[1] + " like '" + unamesc + "'";
				rs = stmt.executeQuery(sqlname);
				break;
			default:
				System.out.println("非法输入，程序已退出。");
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
				sc.close();
				return;
			}
			sc.close();
			
			int cnt = 0;
			while (rs.next())
			{
				long uid = rs.getLong(fields[0]);
				String toDump = "" + uid;
				for (int i = 1; i < fields.length; ++i)
					toDump += "," + rs.getString(fields[i]);
				if (!toDump.contains("~"))
				{
					++cnt;
					System.out.println("\n" + joinArray(",", fields));
					System.out.println(toDump);
				}
			}
			System.out.println("\n查询完毕，共查询到 " + cnt + " 条相关数据。");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
		return;
	}
}