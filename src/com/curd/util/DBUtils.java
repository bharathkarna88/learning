package com.curd.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {

	/**
	 * db Connection
	 */
	private static Connection con;

	/**
	 * This method will return connection
	 */
	public static Connection getCinnection() 
	{
		if (con != null) {
			return con;
		}

		InputStream inputStream = DBUtils.class.getClassLoader()
				.getResourceAsStream("db.properties");
		Properties properties = new Properties();
		try {
			properties.load(inputStream);
			String driver = properties.getProperty("driver");
			String url = properties.getProperty("url");
			String user = properties.getProperty("user");
			String pass = properties.getProperty("pass");
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pass);
			System.out.println("Connected......");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return con;
	}
	
	/**
	 * This Method will close the db connection
	 */
	public static void closeConnection(final Connection toBeClosed)
	{
		if(toBeClosed == null)
			return;
		try{
			toBeClosed.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
}
