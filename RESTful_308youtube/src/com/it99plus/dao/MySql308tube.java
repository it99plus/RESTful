package com.it99plus.dao;

import javax.naming.*;
import javax.sql.*;

public class MySql308tube {

	private static DataSource MySql308tube = null;
	private static Context context = null;

	public static DataSource MySql308tubeConn() throws Exception {

		if (MySql308tube != null) {
			return MySql308tube;
		}
		try {

			if (context == null) {
				context = new InitialContext();
			}

			MySql308tube = (DataSource) context.lookup("	jdbc/308tube");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return MySql308tube;
	}
}

/*
 * Context initContext = new InitialContext(); 
 * Context envContext = (Context) initContext.lookup("java:comp/env"); 
 * DataSource ds = (DataSource)
 * envContext.lookup("jdbc/UsersDB"); Connection conn = ds.getConnection();
 * 
 * Statement statement = conn.createStatement(); String sql =
 * "select username, email from users"; ResultSet rs =
 * statement.executeQuery(sql); // iterates over the result set...
 */