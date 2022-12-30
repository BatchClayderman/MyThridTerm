package com.itheima.jdbc;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OutputData
{
	public static void main(String[] args) throws SQLException
	{
		/* 参数 */
		String sql_name = "jdbc", table_name = "user";
		int connection_port = 3306;
		String username = "root", password = "123456";
		String targetFile = "writer.txt";
		String[] fields = { "uid", "uname", "upwd", "umajor", "utype" };
		
		/* 初始化连接变量 */
		Connection conn = null;
		Statement state = null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = sql_name + ":mysql://localhost:" + connection_port + "/" + sql_name + "?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
			conn = DriverManager.getConnection(url,username, password);
			state = conn.createStatement();
			BufferedWriter bw = new BufferedWriter(new FileWriter(targetFile));
			
			ResultSet rs = state.executeQuery("select * from " + table_name);
			int cnt = 0;
			while (rs.next())
			{
				String toDump = "" + rs.getLong(fields[0]);
				for (int i = 1; i < fields.length; ++i)
					toDump += "," + rs.getString(fields[i]);
				if (!toDump.contains("~"))//不导出已删除的记录
				{
					++cnt;
					bw.write(toDump);
					bw.newLine();
				}
			}
			if (rs != null)
				rs.close();
			bw.close();
			System.out.println("导出记录成功，共计 " + cnt + " 条！");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (state != null)
				state.close();
			if (conn != null)
				conn.close();
		}
		return;
	}
}