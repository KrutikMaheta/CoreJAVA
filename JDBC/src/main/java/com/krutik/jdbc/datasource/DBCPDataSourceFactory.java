/**
 * Datasource:
 * 
 * Most of the times we are looking for loose coupling for connectivity so that we can switch databases easily, connection pooling 
 * for transaction management and distributed systems support. JDBC DataSource is the preferred approach if you are looking for any 
 * of these features in your application.
 * 
 * Apache commons DBCP provides java DataSource implementation that works as an abstraction layer between 
 * 
 * our program and different JDBC drivers.
 * 
 */

package com.krutik.jdbc.datasource;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class DBCPDataSourceFactory {

	public static DataSource getDataSource() {
		Properties props = new Properties();
		BasicDataSource ds = new BasicDataSource();

		try (FileInputStream fis = new FileInputStream("E:\\SouceTree\\CoreJAVA\\JDBC\\resources\\db.properties")) {
			props.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

		ds.setDriverClassName(props.getProperty("DB_DRIVER_CLASS"));
		ds.setUrl(props.getProperty("DB_URL"));
		ds.setUsername(props.getProperty("DB_USERNAME"));
		ds.setPassword(props.getProperty("DB_PASSWORD"));

		return ds;
	}
}