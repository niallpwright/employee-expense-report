package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import exception.NoEmployeeFoundException;
import exception.SystemException;

import pojo.UserPojo;

public class UserDaoImpl implements UserDao{

	public List<UserPojo> listAllUser() throws SystemException, NoEmployeeFoundException {
		List<UserPojo> allUsers = new ArrayList<UserPojo>();
		Connection conn = DBUtil.obtainConnection();
		
		Statement stmt;
		try {
			stmt = conn.createStatement();
			String query = "SELECT * FROM user_details;";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				UserPojo userPojo = new UserPojo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
				allUsers.add(userPojo);
			}
		} catch (SQLException e) {
			
			throw new SystemException();
		}
		if(allUsers.isEmpty()) {
			throw new NoEmployeeFoundException();
		}
		return allUsers;
		}
		
	

	public UserPojo fetchAUser(int userId) throws SystemException {
		UserPojo userPojo = null;
		Connection conn = DBUtil.obtainConnection();
		
		try {
			Statement stmt = conn.createStatement();
			String query = "select * from user_details where user_id="+userId;
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()) {
				userPojo = new UserPojo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
			}
			
		} catch (SQLException e) {
			
			throw new SystemException();
		}
		
		return userPojo;
	}

	public UserPojo updateUser(UserPojo userPojo) throws SystemException {
		
		Connection conn = DBUtil.obtainConnection();
		
		try {
			Statement stmt = conn.createStatement();
			String query = "update user_details set first_name="+userPojo.getFirstName()+", last_name="+userPojo.getLastName()+", user_name="+userPojo.getUserName()+", password="+userPojo.getPassword()+", contact_number="+userPojo.getContactInfo()+", role="+userPojo.getRole()+" where user_id="+userPojo.getUserId();
			int rows = stmt.executeUpdate(query);
		} catch (SQLException e) {
			
			throw new SystemException();
		}
		
		
		return userPojo;
	}
}
