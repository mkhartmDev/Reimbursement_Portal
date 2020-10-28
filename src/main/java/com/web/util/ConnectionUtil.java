package com.web.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

public class ConnectionUtil {
	{
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private String url = System.getenv("url");
	private String password = System.getenv("password");
	private String username = System.getenv("username");
	private String url2 = "jdbc:postgresql://mattdata.czgiz6yidnij.us-east-2.rds.amazonaws.com:5432/postgres?currentSchema=carlot_schema";
	private String password2 = "password";
	private String username2 = "postgres";
	private static ConnectionUtil instance;

	private ConnectionUtil() {
	}

	public static ConnectionUtil getInstance() {
		if (instance == null) {
			instance = new ConnectionUtil();
		}
		return instance;
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url2, username2, password2);
	}

}