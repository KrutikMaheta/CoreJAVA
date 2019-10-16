package com.krutik.jdbc.datasource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class ApacheCommonsDBCPTest {

	public static void main(String[] args) {
		testDBCPDataSource();
		System.out.println("**********");
	}

	private static void testDBCPDataSource() {
		DataSource ds = DBCPDataSourceFactory.getDataSource();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select name, email from Users");
			while (rs.next()) {
				System.out.println("Employee ID=" + rs.getString("name") + ", Name=" + rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
