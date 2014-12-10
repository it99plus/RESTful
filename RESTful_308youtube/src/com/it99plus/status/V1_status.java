package com.it99plus.status;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/v1/status")
public class V1_status {

	private static final String api_version = "00.02.00";

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnTitle() {
		return "<p>Java Web Service</p>";
	}

	@Path("/version")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnVersion() {
		return "<p>Version:</p>" + api_version;
	}

	
	
	@Path("/database")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnDatabaseStatus() throws Exception {

		PreparedStatement query = null;
		String myString = null;
		String returnString = null;
		Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/308tube", "root", "4321"); // MySQL
			query = conn.prepareStatement("SELECT DATE_FORMAT(SYSDATE(), '%Y-%m-%d') DATETIME");
			ResultSet rs = query.executeQuery();

			while (rs.next()) {
				myString = rs.getString("DATETIME");
			}

			returnString = "<p>Database Status</p> "
					+ "<p>Database Date/Time return: " + myString + "</p>";
			
			query.close(); // close connection
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			query.close(); // close connection
			conn.close();
		}


		return returnString;
	}

}
