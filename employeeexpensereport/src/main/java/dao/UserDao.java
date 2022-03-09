package dao;

import java.util.List;

import exception.NoEmployeeFoundException;
import exception.SystemException;
import pojo.UserPojo;

public interface UserDao {
	
	List<UserPojo> listAllUser() throws SystemException, NoEmployeeFoundException;
	
	UserPojo fetchAUser(int userId) throws SystemException;
	
	UserPojo updateUser(UserPojo userPojo) throws SystemException;
	
	//default void exitApplication();
		
}
