package presentation;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import exception.NoEmployeeFoundException;
import exception.RequestNotFoundException;
import exception.SystemException;
import io.javalin.Javalin;

import pojo.RequestPojo;
import pojo.UserPojo;
import service.ExpenseService;
import service.ExpenseServiceImpl;

public class ExpenseMain {

	public static void main(String[] args) {
		ExpenseService expenseService =new ExpenseServiceImpl();
		Javalin myServer = Javalin.create((config) -> config.enableCorsForAllOrigins()).start(4040);
		System.out.println("server listening at port 4040...");
//list all users
		myServer.get("api/users", (ctx)-> {
			List<UserPojo> allUsers = expenseService.listAllUser();
			ctx.json(allUsers);
			
		});
		//list all requests
		myServer.get("api/requests", (ctx)-> {
			List<RequestPojo> allRequests = expenseService.fetchAllRequests();
			ctx.json(allRequests);
			
		});
		//add a request
		myServer.post("api/requests", (ctx)-> {
			
			RequestPojo newRequest = ctx.bodyAsClass(RequestPojo.class);
			RequestPojo returnedRequest = expenseService.addRequest(newRequest);
			ctx.json(returnedRequest);
		
		});
		
		//update request
		myServer.put("api/requests", (ctx)-> {
		RequestPojo updateRequest = ctx.bodyAsClass(RequestPojo.class);
		RequestPojo returnUpdatedRequest = expenseService.updateRequest(updateRequest);
		ctx.json(returnUpdatedRequest);
	
		});
		//fetch A user
		myServer.get("api/users/{bid}", (ctx)-> {
			
			String userId = ctx.pathParam("bid");
			UserPojo fetchedUser = expenseService.fetchAUser(Integer.parseInt(userId));
			ctx.json(fetchedUser);
			
		
		});
		//fetch A request
		myServer.get("api/requests/{bid}", (ctx)-> {
			
			String requestId = ctx.pathParam("bid");
			RequestPojo fetchedRequest = expenseService.fetchARequest(Integer.parseInt(requestId));
			ctx.json(fetchedRequest);
			
		});
		//update a user
		myServer.put("api/users", (ctx)-> {
			UserPojo updateUser = ctx.bodyAsClass(UserPojo.class);
			UserPojo returnUpdatedUser = expenseService.updateUser(updateUser);
			ctx.json(returnUpdatedUser);
	});
		
		myServer.exception(SystemException.class, (se, ctx)-> {
			Map<String, String> error = new HashMap<String, String>();
			error.put("message", se.getMessage());
			error.put("datetime", LocalDateTime.now()+"");
			ctx.json(error);
		});
		
		myServer.exception(RequestNotFoundException.class, (be, ctx)-> {
			Map<String, String> error = new HashMap<String, String>();
			error.put("message", be.getMessage());
			error.put("datetime", LocalDateTime.now()+"");
			ctx.json(error);
		});
		
		myServer.exception(NoEmployeeFoundException.class, (be, ctx)-> {
			Map<String, String> error = new HashMap<String, String>();
			error.put("message", be.getMessage());
			error.put("datetime", LocalDateTime.now()+"");
			ctx.json(error);
		});
		
	}
}
