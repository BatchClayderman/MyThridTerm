package com.itheima.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteData
{
	public static boolean checkValidLong(String toCheck, int uid_length)
	{
		if (toCheck.length() >= uid_length)
			return false;
		for (int i = 0; i < toCheck.length(); ++i)
			if (toCheck.charAt(i) < '0' || toCheck.charAt(i) > '9')
				return false;
		return true;
	}
	
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
	
	public static String joinArray(String sep, String[] arr)
	{
		if (arr.length <= 0)
			return "";
		String sRet = arr[0];
		for (int i = 1; i < arr.length; ++i)
			sRet += sep + arr[i];
		return sRet;
	}
	
	public static String getNewName(String ori_name, long timeStamp, int char_length)
	{
		String timeStampStr = String.format("%08x", timeStamp);//时间戳的十六进制
		if (ori_name.length() + 1 + timeStampStr.length() >= char_length)//太长
			return ori_name.substring(0, ori_name.length() - 1 - timeStampStr.length()) + "~" + timeStampStr;
		else
			return ori_name + "~" + timeStampStr;
	}
	
	public static void main(String[] args) throws SQLException
	{
		/* 参数 */
		String sql_name = "jdbc", table_name = "user";
		int uid_length = 15, char_length = 48, connection_port = 3306;
		String username = "root", password = "123456";
		String[] fields = { "uid", "uname", "upwd", "umajor", "utype" };
		
		/* 初始化连接变量 */
		Connection conn = null;
		Statement stmt = null;
		Statement state = null;
		ResultSet rs = null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:" + connection_port + "/" + sql_name + "?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
			conn = DriverManager.getConnection(url, username, password);
			stmt = conn.createStatement();
			state = conn.createStatement();
			System.out.print("请选择查询的方式（序号查询请输入“A”，姓名查询请输入“B”）：");
			
			Scanner sc = new Scanner(System.in);
			String op = sc.nextLine();
			switch(op)
			{
			case "A":
			case "a":
				System.out.print("请输入待删除 uid：");
				String idsc = sc.nextLine();
				if (!checkValidLong(idsc, uid_length))
				{
					System.out.println("非法输入，程序已退出。");
					if (state != null)
						state.close();
					if (stmt != null)
						stmt.close();
					if (conn != null)
						conn.close();
					sc.close();
					return;
				}
				String sqlid = "select * from " + table_name + " where " + fields[0] + " like " + idsc;
				rs = stmt.executeQuery(sqlid);
				break;
			case "B":
			case "b":
				System.out.print("请输入待删除 uname：");
				String unamesc = sc.nextLine();
				if (!checkValidString(unamesc, char_length))//检查可能导致的注入
				{
					System.out.println("非法输入，程序已退出。");
					if (state != null)
						state.close();
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
				System.out.println("无效选择，程序已退出。");
				if (state != null)
					state.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
				sc.close();
				return;
			}
			
			int cnt = 0;
			while (rs.next())
			{
				++cnt;
				System.out.println("\n" + joinArray(",", fields));
				long uid = rs.getLong(fields[0]);
				String toDump = "" + uid;
				for (int i = 1; i < fields.length; ++i)
					toDump += "," + rs.getString(fields[i]);
				System.out.println(toDump);
				System.out.print("是否确认删除？彻底删除请再次输入 " + fields[0] + "，删除请输入“Y”，不删除请输入“N”：");
				op = sc.nextLine();
				if (op.equals("" + uid))//由于连接 MySQL 已经需要一次密码，此处进行删除不再次使用密码进行验证
				{
					String sqlDeepDelete = "DELETE FROM " + table_name + " where " + fields[0] + " = '" + uid + "'";
					state.execute(sqlDeepDelete);
					System.out.println("彻底删除记录成功！");
				}
				else if (op.toUpperCase().equals("Y"))
				{
					int attempt_time = 0;
					String ori_name = rs.getString(fields[1]);
					for (;;)
					{
						try
						{
							long timeStamp = System.currentTimeMillis();
							String sqldelete = "UPDATE " + table_name + " set " + fields[1] + " = '" + getNewName(ori_name, uid, char_length) + "' where " + fields[0] + " = '" + uid + "'";
							state.execute(sqldelete);
							sqldelete = "UPDATE " + table_name + " set " + fields[0] + " = '" + timeStamp + "' where " + fields[0] + " = '" + uid + "'";
							state.execute(sqldelete);
							System.out.println("删除记录成功，溯源码为：" + timeStamp + "。\n如需溯源，请前往 MySQL 控制台进行操作！");
							break;
						}
						catch (Throwable e)
						{
							if (++attempt_time >= 3)
							{
								System.out.println("删除失败，新 " + fields[0] + " 分配冲突三次或以上。");
								break;
							}
						}
					}
				}
			}
			sc.close();
			System.out.println("\n查询完毕，共查询到 " + cnt + " 条相关数据。");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (state != null)
				state.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
		return;
	}
}