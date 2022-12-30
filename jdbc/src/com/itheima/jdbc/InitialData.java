package com.itheima.jdbc;

import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InitialData
{
	public static class MD5Util
	{
		public static String getMD5str(String str)
		{
			byte[] digest = null;
			try
			{
				MessageDigest md5 = MessageDigest.getInstance("md5");
				digest = md5.digest(str.getBytes("utf-8"));
			}
			catch(NoSuchAlgorithmException e)
			{
				e.printStackTrace();
			}
			catch(UnsupportedEncodingException e)
			{
				e.printStackTrace();
			}
			String md5str = new BigInteger(1, digest).toString(16);
			return md5str;
		}
	}
	
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
		int uid_length = 15, char_length = 48, connection_port = 3306;
		String username = "root", password = "123456";
		String inFilepath = "user.txt", outFilepath = "writer.txt";
		String[] fields = { "uid", "uname", "upwd", "umajor", "utype" };
		
		/* 初始化连接变量 */
		Connection conn = null;
		Statement state = null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:" + connection_port + "/" + sql_name + "?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
			conn = DriverManager.getConnection(url, username, password);
			state = conn.createStatement();
			BufferedReader br = new BufferedReader(new FileReader(inFilepath));//输入流
			BufferedWriter bw = new BufferedWriter(new FileWriter(outFilepath));//输出流
			String str = br.readLine();
			
			/* 逐行读取 */
			int cnt = 0;
			while ((str = br.readLine()) != null)
			{
				String[] split = str.split(",");
				bw.write(str);//通过缓冲流对象写入文件
				bw.newLine();
				split[2] = MD5Util.getMD5str(split[2]);
				if (!checkValidLong(split[0], uid_length))
				{
					System.out.println("文件第  " + cnt + " 行的 " + fields[0] + " 字段非法或太长，已跳过该行。");
					continue;
				}
				boolean invalid_flag = false;
				for (int i = 1; i < split.length; ++i)
					if (!checkValidString(split[i], char_length))
					{
						invalid_flag = true;
						System.out.println("文件第  " + cnt + " 行的 "  + fields[i] + " 字段检测到非法字符或太长，已跳过该行。");
						break;
					}
				if (invalid_flag)
					continue;
				String sql = "REPLACE INTO " + table_name + "(" + joinArray(", ", fields) + ") values('" + joinArray("', '", split) + "')";//无则插入有则更新
				state.execute(sql);
				++cnt;
				System.out.println(joinArray(",", split));
			}
			
			br.close();
			bw.close();
			System.out.println("\n添加或更新记录成功，共计 " + cnt + " 条！");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			/* 关闭连接释放资源 */
			if (state != null)
				state.close();
			if (conn != null)
				conn.close();
		}
		return;
	}
}
