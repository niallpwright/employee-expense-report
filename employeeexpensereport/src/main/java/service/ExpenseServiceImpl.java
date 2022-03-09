package service;

import java.util.List;


import dao.RequestDao;
import dao.RequestDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;
import exception.NoEmployeeFoundException;
import exception.RequestNotFoundException;
import exception.SystemException;
import pojo.RequestPojo;
import pojo.UserPojo;

public class ExpenseServiceImpl implements ExpenseService{
	RequestDao requestDao;
	
	public ExpenseServiceImpl() {
		//bookDao = new BookDaoImpl();
		userDao = new UserDaoImpl();
		requestDao = new RequestDaoImpl();
	}
	public List<RequestPojo> fetchAllRequests() throws SystemException, RequestNotFoundException {
		// TODO Auto-generated method stub
		return requestDao.fetchAllRequests();
	}

	public RequestPojo fetchARequest(int requestId) throws RequestNotFoundException, SystemException {
		// TODO Auto-generated method stub
		return requestDao.fetchARequest(requestId);
	}

	public RequestPojo updateRequest(RequestPojo requestPojo) throws SystemException {
		// TODO Auto-generated method stub
		return requestDao.updateRequest(requestPojo);
	}

	public RequestPojo addRequest(RequestPojo requestPojo) throws SystemException {
		// TODO Auto-generated method stub
		return requestDao.addRequest(requestPojo);
	}

	public RequestPojo deleteRequest(int requestId) throws SystemException {
		// TODO Auto-generated method stub
		return requestDao.deleteRequest(requestId);
	}
	
	UserDaoImpl userDao; 
	public List<UserPojo> listAllUser() throws SystemException, NoEmployeeFoundException {
		// TODO Auto-generated method stub
		return userDao.listAllUser();
	}

	public UserPojo fetchAUser(int userId) throws SystemException {
		// TODO Auto-generated method stub
		return userDao.fetchAUser(userId);
	}

	public UserPojo updateUser(UserPojo userPojo) throws SystemException {
		// TODO Auto-generated method stub
		return userDao.updateUser(userPojo);
	}
		
	}


