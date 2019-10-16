/**
 * Transaction Management:
 * 
 * JDBC API provide method setAutoCommit() through which we can disable the auto commit feature of the 
 * connection. We should disable auto commit only when it’s required because the transaction will not 
 * be committed unless we call the commit() method on connection. 
 * 
 *  So we should commit the transaction as soon as we are done with it. 
 */

package com.krutik.jdbc.transaction;

import java.sql.Connection;
import java.sql.SQLException;

import com.krutik.jdbc.DBConnection;

public class EmployeeJDBCTransactionExample {

	public static void main(String[] args) {
		Connection con = null;
		try {
			con = DBConnection.getConnection();

			// set auto commit to false
			con.setAutoCommit(false);

			EmployeeJDBCInsertExample.insertEmployeeData(con, 1, "krutik");

			EmployeeJDBCInsertExample.insertAddressData(con, 1, "Harni road", "BRC", "INDIA");

			// now commit transaction
			con.commit();

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
				System.out.println("JDBC Transaction rolled back successfully");
			} catch (SQLException e1) {
				System.out.println("SQLException in rollback" + e.getMessage());
			}
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
