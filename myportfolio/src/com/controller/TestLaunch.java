package com.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.util.Properties;

import com.mysql.cj.jdbc.MysqlDataSource;

public class TestLaunch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			String s="ancd";
			FileOutputStream fos = new FileOutputStream("mycon.txt");
			fos.write(s.getBytes());
			
//			FileInputStream fis = new FileInputStream("mycon");
//			Properties p = new Properties();
//			p.load(fis);
//			String url = (String) p.get("url");
//			String user = (String) p.get("username");
//			String pass= (String) p.get("password");
//			String driver = (String) p.get("driver");
//			
//			MysqlDataSource ds = new MysqlDataSource();
//			ds.setURL(url);
//			ds.setUser(user);
//			ds.setPassword(pass);
//			
//			Connection con = ds.getConnection();
//			System.out.println(con);
//			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}

}
