package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertDaoImp implements InsertDao {

	private Connection con;
	private PreparedStatement ps;
	private String sql;
	private String result;
	private int row;

	@SuppressWarnings("finally")
	@Override
	public String saveMessage(String name, String email, String message) {

		try {
			con = ConnectionFactory.getConnection();
			sql = "insert into message(name,email,message) values(?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, message);
			row = ps.executeUpdate();
			if (row == 1)
				result = "saved";
		} catch (Exception e) {
			System.out.println("InsertDaoImp:saveMessage->" + e);
			result = "exp";
		} finally {
			return result;
		}
	}
}
