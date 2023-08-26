package com.jdbc.JDBCDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {

	public static void main(String[] args) {

		try {
			
			Persons person1 = new Persons(7, "Roa","Ram",32);
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "1996");

			Statement statement = connection.createStatement();
			
			
			statement.execute("insert into persons values('"+person1.personID+"','"+person1.lastName+"','"+person1.firstName+"','"+person1.age+"');");
			
//			ResultSet result = statement.executeQuery("select * from persons;");
//			
//			
//			while(result.next())
//			{
//			System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getInt(4));
//			
//			}
			
			//Statement statement = connection.createStatement();

			// statement.execute("insert into person values(222,'Ram','ram@gmail.com');");

			// statement.execute("update person set name='Ravi' where id=222;");

			// statement.execute("delete from person where id=222;");

//			ResultSet result = statement.executeQuery("select * from person where id=222;");
//
//			while (result.next()) {
//				System.out.println("Id: " + result.getInt(1));
//				System.out.println("Name: " + result.getString(2));
//				System.out.println("Email: " + result.getString(3));
//			}

		} catch (SQLException e) {

			System.out.println("Unable to connect to Database........");
			e.printStackTrace();
		}

	}

}