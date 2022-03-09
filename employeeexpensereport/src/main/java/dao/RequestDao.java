package dao;

import java.util.List;

import exception.RequestNotFoundException;
import exception.SystemException;
import pojo.RequestPojo;

public interface RequestDao {
	
	List<RequestPojo> fetchAllRequests() throws SystemException, RequestNotFoundException;
	
	RequestPojo fetchARequest(int requestId) throws RequestNotFoundException, SystemException;
	
	RequestPojo updateRequest(RequestPojo requestPojo) throws SystemException;
	
	RequestPojo addRequest(RequestPojo requestPojo) throws SystemException;
	
	RequestPojo deleteRequest(int requestId) throws SystemException;
	
	

}
