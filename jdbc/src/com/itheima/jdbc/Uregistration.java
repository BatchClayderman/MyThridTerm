package com.itheima.jdbc;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.itheima.jdbc.InitialData.MD5Util;// MD5

public class Uregistration
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
		int uid_length = 15, char_length = 48, connection_port = 3306;
		String username = "root", password = "123456";
		String[] fields = { "uid", "uname", "upwd", "umajor", "utype" };
		
		/* 初始化连接变量 */
		Connection conn = null;
		Statement state = null;
		Statement state1 = null;
		Statement statequery = null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:" + connection_port + "/" + sql_name + "?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
			conn = DriverManager.getConnection(url, username, password);
			state = conn.createStatement();
			state1 = conn.createStatement();
			statequery = conn.createStatement();
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			String unamesc = "", upwdsc = "", umajorsc = "", utype = "内招生";
			System.out.println("/********** 用户注册 **********/");
			
			for (;;)
			{
				System.out.print("请输入姓名：");
				unamesc = sc.nextLine();
				if (unamesc.length() <= 0 || !checkValidString(unamesc, char_length))
					System.out.println("发现非法字符、空字符或字符超过 " + char_length + " 个字节。");
				else
					break;
			}
			
			boolean security_flag = true;//密码强度指数
			while (security_flag)
			{
				System.out.print("请输入密码：");
				short security_index = 0;//重置密码强度指数
				upwdsc = sc.nextLine();
				if (upwdsc.length() < 6 || upwdsc.length() >= char_length)//按位数判断密码强度
				{
					System.out.println("密码长度应当至少六个字符且少于  " + char_length + " 个字符！");
					continue;
				}
				for (int i = 0; i < upwdsc.length(); ++i)
					if ('A' <= upwdsc.charAt(i) && upwdsc.charAt(i) <= 'Z')//大写
						security_index |= 0b0001;
					else if ('a' <= upwdsc.charAt(i) && upwdsc.charAt(i) <= 'z')//小写
						security_index |= 0b0010;
					else if ('0' <= upwdsc.charAt(i) && upwdsc.charAt(i) <= '9')//数字
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
			
			for (;;)
			{
				System.out.print("请输入专业：");
				umajorsc = sc.nextLine();
				if (umajorsc.length() <= 0 || !checkValidString(umajorsc, char_length))
					System.out.println("发现非法字符、空字符或字符超过 " + char_length + " 个字节。");
				else
					break;
			}
			
			System.out.print("如果您是外招生，请输入“Y”并回车：");
			String ans = sc.nextLine();
			if (ans.equals("Y") || ans.equals("y") || ans.equals("1"))
				utype = "外招生";
			
			String sqlquery = "select * from " + table_name + " where " + fields[1] + " = '" + unamesc + "'" ;//搜索是否有重复用户
			ResultSet rsquery = statequery.executeQuery(sqlquery);
			if (rsquery.next())
				System.out.println("警告：姓名重复。");//仅作警告处理
			
			String sqlidmax = "SELECT " + fields[0] + " FROM " + table_name + " order by " + fields[0] + " desc limit 1";//序号自动加1
			ResultSet rs = state.executeQuery(sqlidmax);
			long idsc = 0;
			while (rs.next())
			{
				idsc = rs.getLong(fields[0]) + 1; // 通过列名获取指定字段的值
				if (("" + idsc).length() >= uid_length)
				{
					System.out.println("很抱歉，系统标识 " + fields[0] + " 已分配完毕。");
					if (state != null)
						state.close();
					if (state1 != null)
						state1.close();
					if (statequery != null)
						state1.close();
					if(conn != null)
						conn.close();
					return;
				}
				System.out.println(fields[0] + "：" + idsc);
			}
			String md5pwd = MD5Util.getMD5str(upwdsc);
			String sqlin = "INSERT INTO " + table_name + "(" + joinArray(", ", fields) + ") values('" + idsc + "', '" + unamesc + "', '" + md5pwd + "', '" + umajorsc + "', '" + utype + "')";//新建用户
			state1.executeUpdate(sqlin);
			System.out.println("注册成功！");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (state != null)
				state.close();
			if (state1 != null)
				state1.close();
			if (statequery != null)
				state1.close();
			if(conn != null)
				conn.close();
		}
		return;
	}
}