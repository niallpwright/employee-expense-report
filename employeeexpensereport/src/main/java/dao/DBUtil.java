package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import exception.SystemException;

public class DBUtil {
	static Connection conn;
		//load driver
	static {
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Singleton design pattern
	 static Connection obtainConnection() {
		 
		String connectionUrl = "jdbc:postgresql://127.0.0.1:5432/employee_expense_report";
		String userName = "postgres";
		String password = "postgres";
		
		if(conn == null) {
		
		try {
			conn = DriverManager.getConnection(connectionUrl, userName, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		return conn;
	}
	 static void closeConnection()throws SystemException {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new SystemException();
			}
}	
}	
	

	


