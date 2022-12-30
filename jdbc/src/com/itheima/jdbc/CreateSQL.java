package com.itheima.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateSQL
{
	public static void main(String[] args) throws SQLException
	{
		/* 参数 */
		String sql_name = "jdbc", table_name = "user";
		int uid_length = 15, uid_offset = uid_length + 5, char_length = 48, char_offset = char_length + uid_length + 1, connection_port = 3306;
		String username = "root", password = "123456";
		String[] fields = { "uid", "uname", "upwd", "umajor", "utype" };
		
		/* 初始化连接变量 */
		Connection conn = null;
		Statement state = null;
		String toExec = "CREATE TABLE IF NOT EXISTS " + table_name + " (" + fields[0] + " bigint(" + uid_offset + ") NOT NULL AUTO_INCREMENT, ";
		for (int i = 1; i < fields.length; ++i)
			toExec += fields[i] + " varchar(" + char_offset + ") COLLATE utf8_bin NOT NULL, ";
		toExec += "PRIMARY KEY (" + fields[0]+ ")) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1";
		
		try
		{
			/* 建立连接 */
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:" + connection_port + "/mysql" + "?useUnicode=true&characterEncoding=UTF-8&useSSL=false";//尽可能消除警告和乱码
			conn = DriverManager.getConnection(url, username, password);
			state = conn.createStatement();
			
			/* 判断数据库是否存在 */
			ResultSet rs = conn.getMetaData().getCatalogs();
			while (rs.next())
			{
				String databaseName = rs.getString(1);
				if (databaseName.equals(sql_name))
				{
					System.out.println("数据库已存在，无需重复创建。");
					return;
				}
			}
			if (rs != null)//关闭
				rs.close();
			
            /* 进入数据库 */
			state.executeUpdate("CREATE DATABASE " + sql_name);
			state.close();
			conn.close();
			url = sql_name + ":mysql://localhost:3306/" + sql_name + "?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
			conn = DriverManager.getConnection(url, username, password);
			state = conn.createStatement();
			state.executeUpdate(toExec);
			System.out.println("创建数据库成功！");
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
