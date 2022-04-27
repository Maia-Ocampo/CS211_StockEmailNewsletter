/**
 *
 *@author Wasiq Muhammad Ali
 *
 *@version 1.17
 *
 *This class takes information from the database - login
 * 
 */

package com.project.FinalProject;

import java.sql.*;
import java.util.ArrayList;
import java.util.Hashtable;

public class Connection {
	
	protected static java.sql.Connection conn = null;
	
	/**
	 * This method basically connects to the server.
	 */
	
	public static void connect() {
		
		final String link = "jdbc:postgresql://localhost:5432/login";
		final String username = "wasiqali";
		final String password = "UB26259QPpnAlAmxIh8-2g";
		
		try {
			
			conn = DriverManager.getConnection(link,username,password);
			System.out.println("Connected");
			
		}
		
		catch(SQLException e) {
			
			e.printStackTrace();
			
		}
		
		
		
	}
	
	/**
	 * This method creates an ArrayList with all the emails.
	 * @return emails
	 * @throws SQLException
	 */
	
	public static ArrayList<String> getEmail() throws SQLException {
		
		
		ArrayList<String> emails = new ArrayList<String>();
		
		connect();
		
		String query = "SELECT * FROM Information";
		Statement statement = conn.createStatement();
		ResultSet rs = statement.executeQuery(query);
		
		while(rs.next()) {
			
			emails.add(rs.getString(1));
			
		}
		
		return emails;
		
	}
	
	/**
	 * This method creates a hashtable that contains all the emails with their respective passwords
	 * @return dict
	 * @throws SQLException
	 */
	
	public static Hashtable<String, String> getInfo() throws SQLException{
		
		Hashtable<String, String> dict = new Hashtable<String, String>();
		
		connect();
		
		String query = "SELECT * FROM Information";
		Statement statement = conn.createStatement();
		ResultSet rs = statement.executeQuery(query);
		
		while(rs.next()) {
			
			dict.put(rs.getString(1),rs.getString(2));
			
		}
		
		return dict;
		
	}

	/**
	 * This method creates an ArrayList for each user's email.
	 * @param email
	 * @return dict
	 * @throws SQLException
	 */
	
	public static ArrayList<String> getStockInfo(String email) throws SQLException{
		
		ArrayList<String> dict = new ArrayList<String>();
		
		connect();
		
		String query = String.format("SELECT * FROM Information \n WHERE email = '%s'", email);
		Statement statement = conn.createStatement();
		ResultSet rs = statement.executeQuery(query);
		
		while(rs.next()) {
			
			dict.add(rs.getString(3));
			
		}
		
		System.out.println(dict);
		return dict;
		
		
	}
	
	
}

