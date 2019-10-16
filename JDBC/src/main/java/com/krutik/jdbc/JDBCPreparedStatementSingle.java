package com.krutik.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCPreparedStatementSingle {

	private static final String QUERY = "select name,email,country from users where id = ?";

	public static void printData(int[] ids) {
		Connection con = DBConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(QUERY);

			for (int id : ids) {
				ps.setInt(1, id);
				rs = ps.executeQuery();

				while (rs.next()) {
					System.out.println("User EMAIL:ID=" + rs.getString("email") + ", Name=" + rs.getString("name")
							+ ", Country :  " + rs.getString("country"));
				}

				// close the resultset here
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		printData(new int[] { 1, 4 });
	}
}
