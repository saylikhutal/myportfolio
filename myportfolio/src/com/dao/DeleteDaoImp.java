package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteDaoImp implements DeleteDao {

	private Connection con;
	private PreparedStatement ps;
	private String sql;
	private String result;
	private int row;

	@SuppressWarnings("finally")
	@Override
	public String deleteMessage(int sn) {
		try {
			con = ConnectionFactory.getConnection();
			sql = "delete from message where sn=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, sn);
			row = ps.executeUpdate();
			if (row == 1)
				result = "deleted";
		} catch (Exception e) {
			System.out.println("DeleteDaoImp->deleteMessage: " + e);
			result = "exp";
		} finally {
			return result;
		}
	}

}
