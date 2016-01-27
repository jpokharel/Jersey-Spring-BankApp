package org.jiwan.bankingapp.restws.resource;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Response;

public class AccountBalanceResource {

	@GET
	public Balance getAccountBalance(accountId){
		
	}
	
	@POST
	public Response addAccountBalance(accountId,balance){
		
	}
	
	@PUT
	public Response updateAccountBalance(accountId,changeBalance){
		
	}
	
	@DELETE
	public Response withdrawBalance(accountId,withdrawBalance){
		
	}
}
