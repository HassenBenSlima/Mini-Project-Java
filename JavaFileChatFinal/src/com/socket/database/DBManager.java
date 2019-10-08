package com.socket.database;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {

	public DBManager() {
		System.out.println("Log: DBManager -- Connection to database established");
	}

	/**
	 * Authenticates the user with a given login and password If password and/or
	 * login is null then always returns false. If the user does not exist in the
	 * database returns false.
	 */
	public boolean checkLogin(String username, String password) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = SingletonConnection.getConnection();
		boolean userExist = true;
		try {

			// INPUT VALIDATION
			if (username == null || password == null) {

				userExist = false;
				username = "";
				password = "";
			}

			ps = conn.prepareStatement("SELECT USERNAME,PASSWORD FROM DATA WHERE USERNAME = ?");
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("Exist:true");
				// throw new SQLException("Database inconsistent two CREDENTIALS with the same
				// LOGIN");

			} else {

				System.out.println("Log: Attempted login -> Username (" + username);

				userExist = false;
			}

			return userExist;
		} catch (Exception ex) {
			// throw new SQLException("Database inconsistant Salt or Digested Password
			// altered");
		} finally {
			close(rs);
			close(ps);
		}
		return userExist;

	}

	/**
	 * Determines if a given username exists in the database
	 * 
	 * @param username
	 * @return boolean Returns true if the username exists in the database.
	 */
	public boolean userExists(String username) {
		boolean exists = false;

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = SingletonConnection.getConnection();

		try {
			ps = conn.prepareStatement("SELECT 1 FROM DATA WHERE USERNAME='" + username + "' LIMIT 1");
			rs = ps.executeQuery();
			if (rs.next())
				exists = true;
		} catch (SQLException e) {
			System.err.println(e);
			e.printStackTrace();
		}

		return exists;
	}

	/**
	 * Inserts a new user in the database
	 * 
	 * @param username
	 *            String The login of the user
	 * @param password
	 *            String The password of the user
	 * @return boolean Returns true if the login and password are ok (not null and
	 *         length(login)<=100
	 * @throws SQLException
	 *             If the database is unavailable
	 * @throws NoSuchAlgorithmException
	 *             If the algorithm SHA-1 or the SecureRandom is not supported by
	 *             the JVM
	 */
	public void addUser(String username, String password) {
		PreparedStatement ps = null;
		Connection conn = SingletonConnection.getConnection();

		try {
			if (username != null && password != null && username.length() <= 100) {

				ps = conn.prepareStatement("INSERT INTO DATA (USERNAME, PASSWORD) VALUES (?,?)");
				ps.setString(1, username);
				ps.setString(2, password);
				ps.executeUpdate();
			}
		} catch (Exception e) {
		} finally {
			close(ps);
		}
	}

	/**
	 * Closes the current statement
	 * 
	 * @param ps
	 *            Statement
	 */
	public void close(Statement ps) {
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException ignore) {
			}
		}
	}

	/**
	 * Closes the current result set
	 * 
	 * @param ps
	 *            Statement
	 */
	public void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException ignore) {
			}
		}
	}

}
