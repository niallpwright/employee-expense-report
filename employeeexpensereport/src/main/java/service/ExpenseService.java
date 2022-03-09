package service;

import java.util.List;

import exception.NoEmployeeFoundException;
import exception.RequestNotFoundException;
import exception.SystemException;
import pojo.RequestPojo;
import pojo.UserPojo;

public interface ExpenseService {
	
List<RequestPojo> fetchAllRequests() throws SystemException, RequestNotFoundException;
	
	RequestPojo fetchARequest(int requestId) throws RequestNotFoundException, SystemException;
	
	RequestPojo updateRequest(RequestPojo requestPojo) throws SystemException;
	
	RequestPojo addRequest(RequestPojo requestPojo) throws SystemException;
	
	RequestPojo deleteRequest(int requestId) throws SystemException;
	
	List<UserPojo> listAllUser() throws SystemException, NoEmployeeFoundException;
	
	UserPojo fetchAUser(int userId) throws SystemException;
	
	UserPojo updateUser(UserPojo userPojo) throws SystemException;
	
	

}
