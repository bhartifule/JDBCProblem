package com.jdbc.JDBCDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class TransactionDemo {

	public static void main(String[] args) throws SQLException {
		
		Connection connection = null;
		Savepoint savePoint1 = null;
		Savepoint savePoint2 = null;
		Savepoint savePoint3 = null;
		try
		{
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "root");
		     
			 connection.setAutoCommit(false);
			 
			 Statement stmt = connection.createStatement();
			 
			 savePoint1 = connection.setSavepoint();
			 
			 stmt.execute("update persons set age=50 where personId=1;");

			 
	            // Syntax error
			 stmt.execute("update persons set age=50 where personId=2;");
			 savePoint2 = connection.setSavepoint();

			 savePoint3 = connection.setSavepoint();
			 stmt.execute("updated persons set age=50 where personId=3;");
		     
			 
			 
		}catch (Exception e) {
			System.out.println(e.getMessage());
			connection.rollback(savePoint1);
		}
		finally {
			connection.commit();
		}

	}

}
