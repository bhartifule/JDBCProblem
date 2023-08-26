package com.jdbc.JDBCDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

public class PreparedStmtDemo {

	public static void main(String[] args) {

		try {
			
			ArrayList<Persons> personInfo = new ArrayList<>();
			personInfo.add(new Persons(1, "Raj", "Kumar", 20));
			personInfo.add(new Persons(2, "Ram", "Rai", 78));
			personInfo.add(new Persons(3, "Ravi", "Rao", 62));
			personInfo.add(new Persons(4, "Rohan", "Iyer", 60));
			personInfo.add(new Persons(5, "Roja", "Patil", 19));
			
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "root");

			PreparedStatement stmt = connection.prepareStatement("insert into persons values(?,?,?,?)");
			
			
			for (int i = 0; i < personInfo.size(); i++) 
			{
				
				stmt.setInt(1,personInfo.get(i).personID);
				stmt.setString(2,personInfo.get(i).firstName);
				stmt.setString(3,personInfo.get(i).lastName);
				stmt.setInt(4,personInfo.get(i).age);
				
				stmt.execute();
				
			}
			
			

		} catch (SQLException e) {

			System.out.println("Unable to connect to Database........");
			e.printStackTrace();
		}

	}

}