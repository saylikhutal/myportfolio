package com.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

import com.mysql.cj.jdbc.MysqlDataSource;
public class ConnectionFactory {

	private static Connection con;
	public static Connection getConnection() {
		
		try {
			FileInputStream fis = new FileInputStream("/home/codehunt/Desktop/mydata/seed/mycon");
			Properties p = new Properties();
			p.load(fis);
			String url = (String) p.get("url");
			String user = (String) p.get("username");
			String pass= (String) p.get("password");
			String driver = (String) p.get("driver");
			
			MysqlDataSource ds = new MysqlDataSource();
			ds.setURL(url);
			ds.setUser(user);
			ds.setPassword(pass);
			
			con = ds.getConnection();
			System.out.println(con);
			
		} catch (Exception e) {
			System.out.println("ConnectionFactory->"+e);
		}
		finally {
			return con;
		}
	}
}
