package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import exception.RequestNotFoundException;
import exception.SystemException;

import pojo.RequestPojo;
import pojo.UserPojo;

public class RequestDaoImpl implements RequestDao{

	public List<RequestPojo> fetchAllRequests() throws SystemException, RequestNotFoundException {
		List<RequestPojo> allRequests = new ArrayList<RequestPojo>();
		Connection conn = DBUtil.obtainConnection();
		
		try {
			Statement stmt = conn.createStatement();
			String query = "select * from request_details";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				RequestPojo requestPojo = new RequestPojo(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getString(4), rs.getString(5));
				allRequests.add(requestPojo);
			}
			
		} catch (SQLException e) {
			
			throw new SystemException();
		}
		if(allRequests.isEmpty()) {
			throw new RequestNotFoundException();
		}
		
		return allRequests;
	}

	public RequestPojo fetchARequest(int requestId) throws RequestNotFoundException, SystemException {
		
		RequestPojo requestPojo = null;
		Connection conn = DBUtil.obtainConnection();
		
		try {
			Statement stmt = conn.createStatement();
			String query = "select * from request_details where request_id="+requestId;
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()) {
				requestPojo = new RequestPojo(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(5), rs.getString(6));
			}
			
		} catch (SQLException e) {
			
			throw new SystemException();
		}
		
		return requestPojo;
	}

	public RequestPojo updateRequest(RequestPojo requestPojo) throws SystemException {
		
		Connection conn = DBUtil.obtainConnection();
		
		try {
			Statement stmt = conn.createStatement();
			String query = "update request_details set request_status="+requestPojo.getRequestStatus()+" where request_id="+requestPojo.getRequestStatus();
			int rows = stmt.executeUpdate(query);
		} catch (SQLException e) {
			
			throw new SystemException();
		}
		
		
		return requestPojo;
	}

	public RequestPojo addRequest(RequestPojo requestPojo) throws SystemException {
		
		Connection conn = DBUtil.obtainConnection();
		try {
			Statement stmt = conn.createStatement();
			int lastRequestId = 0;
			String query1 = "SELECT MAX(request_id) FROM request_details";
			ResultSet rs = stmt.executeQuery(query1);
			if(rs.next()) {
				lastRequestId = rs.getInt(1);
			}
			int newRequestId = lastRequestId + 1;
			
			String query2 = "INSERT INTO request_details VALUES("+newRequestId+"','"+requestPojo.getUserId()+"','"+requestPojo.getRequestAmount()+"',"+requestPojo.getRequestDescription()+",'"+requestPojo.getRequestStatus()+"')";
			int rows = stmt.executeUpdate(query2);
			requestPojo.setRequestId(newRequestId);
		} catch (SQLException e) {
			throw new SystemException();
		}
		
		return requestPojo;
	}

	public RequestPojo deleteRequest(int requestId) throws SystemException {
		
		RequestPojo requestPojo = null;
		Connection conn = DBUtil.obtainConnection();
		
		try {
			try {
				requestPojo = fetchARequest(requestId);
				Statement stmt = conn.createStatement();
				String query = "delete from reqest_details where request_id="+requestId+";";
				int rows = stmt.executeUpdate(query);
			} catch (RequestNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} catch (SQLException e) {
			
			throw new SystemException();
			
			
		}
		
		return requestPojo;
	}

}
