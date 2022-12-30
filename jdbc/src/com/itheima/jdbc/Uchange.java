package com.itheima.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import com.itheima.jdbc.InitialData.MD5Util;

public class Uchange
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
	
	public static void main(String[] args) throws SQLException
	{
		/* 参数 */
		String sql_name = "jdbc", table_name = "user";
		int uid_length = 15, char_length = 50, connection_port = 3306;
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
			System.out.print("请选择精准查询方式（序号查询请输入“A”，姓名查询请输入“B”）：");
			
			Scanner sc = new Scanner(System.in);
			String op = sc.nextLine();
			String idsc = "";
			String unamesc = "";
			switch(op)
			{
			case "A":
			case "a":
				System.out.print("请输入待查询的 " + fields[0] + "：");
				idsc = sc.nextLine();
				if (!checkValidLong(idsc, uid_length))
				{
					System.out.println("非法输入或过长，程序已退出。");
					if (stmt != null)
						stmt.close();
					if (conn != null)
						conn.close();
					sc.close();
					return;
				}
				String sqlid = "select * from " + table_name + " where " + fields[0] + " = '" + idsc + "'";
				rs = stmt.executeQuery(sqlid);
				break;
			case "B":
			case "b":
				System.out.print("请输入待查询的 " + fields[1] + "：");
				unamesc = sc.nextLine();
				if (!checkValidString(unamesc, char_length))//检查引号可能导致的注入
				{
					System.out.println("非法输入，程序已退出。");
					if (stmt != null)
						stmt.close();
					if (conn != null)
						conn.close();
					sc.close();
					return;
				}
				String sqlname = "select * from " + table_name + " where " + fields[1] + " = '" + unamesc + "'";
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
				
				String uname_updated = "", upwd_updated = "", umajor_updated = "", utype_updated = "内招生";
				for (;;)
				{
					System.out.print("请输入修改后的姓名（直接回车保持不变）：");
					uname_updated = sc.nextLine();
					if (uname_updated.length() <= 0)
						uname_updated = rs.getString(fields[1]);
					if (checkValidString(unamesc, char_length))//无论是否改变均检查合法性
						break;
					else
						System.out.println("姓名输入非法或过长，请重试。");
				}
				
				boolean security_flag = true;//密码强度指数
				while (security_flag)
				{
					System.out.print("请输入修改后的密码（直接回车保持不变）：");
					upwd_updated = sc.nextLine();
					if (upwd_updated.length() <= 0)
						break;
					short security_index = 0;//重置密码强度指数
					if (upwd_updated.length() < 6 || upwd_updated.length() >= char_length)//按位数判断密码强度
					{
						System.out.println("密码长度应当至少六个字符且少于  " + char_length + " 个字符！");
						continue;
					}
					for (int i = 0; i < upwd_updated.length(); ++i)
						if ('A' <= upwd_updated.charAt(i) && upwd_updated.charAt(i) <= 'Z')//大写
							security_index |= 0b0001;
						else if ('a' <= upwd_updated.charAt(i) && upwd_updated.charAt(i) <= 'z')//小写
							security_index |= 0b0010;
						else if ('0' <= upwd_updated.charAt(i) && upwd_updated.charAt(i) <= '9')//数字
							security_index |= 0b0100;
						else//特殊字符
							security_index |= 0b1000;
					switch(((security_index & 0b0001) != 0 ? 1 : 0) + ((security_index & 0b0010) != 0 ? 1 : 0) + ((security_index & 0b0100) != 0 ? 1 : 0) + ((security_index & 0b1000) != 0 ? 1 : 0))
					{
					case 0:
						System.out.println("密码强度极弱，请重新输入。");
						break;
					case 1:
						System.out.println("密码强度弱，请重新输入。");
						break;
					case 2:
						System.out.println("密码强度中。");
						security_flag = false;
						break;
					case 3:
						System.out.println("密码强度强。");
						security_flag = false;
						break;
					default:
						System.out.println("密码强度未知，请重新输入。");
						break;
					}
				}
				String md5pwd = upwd_updated.length() <= 0 ? rs.getString(fields[2]) : MD5Util.getMD5str(upwd_updated);
				
				for (;;)
				{
					System.out.print("请输入专业（直接回车保持不变）：");
					umajor_updated = sc.nextLine();
					if (umajor_updated.length() <= 0)
						umajor_updated = rs.getString(fields[3]);
					if (!checkValidString(umajor_updated, char_length))
						System.out.println("检测到非法字符或字符超过 " + char_length + " 个字节，请重新输入。");
					else
						break;
				}
				
				System.out.print("如果您是外招生，请输入“Y”并回车（直接回车保持不变）：");
				String ans = sc.nextLine();
				if (ans.length() <= 0)
					utype_updated = rs.getString(fields[4]);
				else if (ans.equals("Y") || ans.equals("y") || ans.equals("1"))
					utype_updated = "外招生";
				
				sc.close();
				
				System.out.println(joinArray(",", fields));
				System.out.println(uid + "," + uname_updated + "," + md5pwd + "," + umajor_updated + "," + utype_updated);
				String sqlud = "UPDATE " + table_name + " SET " + fields[1] + "='" + uname_updated + "', " + fields[2] + "='" + md5pwd + "', " + fields[3] + "='" + umajor_updated + "', " + fields[4] + "='" + utype_updated + "' WHERE " + fields[0] + "='" + idsc + "' or " + fields[1] + " = '" + uname_updated + "'";
				state.executeUpdate(sqlud);
				System.out.println("修改完成！");
			}
			
			System.out.println("\n共计查询到 " + cnt + " 条记录。");
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