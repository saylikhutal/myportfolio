package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.model.MessagePojo;

public class ReadDaoImp implements ReadDao {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;

	@SuppressWarnings("finally")
	@Override
	public ArrayList<MessagePojo> readMessage() {
		ArrayList<MessagePojo> arrayList = new ArrayList<>();
		try {
			sql = "select * from message";
			con = ConnectionFactory.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				int sn = rs.getInt("sn");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String message = rs.getString("message");
				String date = rs.getString("date");

				MessagePojo m = new MessagePojo(sn, name, email, message, date);
				arrayList.add(m);

			}
		} catch (Exception e) {
			System.out.println("ReadDaoImp->readMessage: " + e);
		} finally {
			return arrayList;
		}

	}

}
