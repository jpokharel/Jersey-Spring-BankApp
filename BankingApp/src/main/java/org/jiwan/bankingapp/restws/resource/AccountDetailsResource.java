package org.jiwan.bankingapp.restws.resource;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.xml.bind.annotation.XmlRootElement;

@Path("/accountdetails")
@XmlRootElement
public class AccountDetailsResource {

	@SuppressWarnings("static-access")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response getAccountDetails(@QueryParam("accountNum") long accountNum) {
		Response response=null;
		if (accountNum < 1L) {
			return response.status(Status.NO_CONTENT).entity("No Query Param Provided").build();
			 
		}
		return response.status(Status.OK).entity("Account Accessed for: "+accountNum).build();
	}

	@POST
	public Response createAccount(AccountDTO){
		
	}

	@PUT
	public Response updateAccountDetails(AccountDTO){
		
	}

	@DELETE
	public Response deleteAccount(AccountId){
		
	}

}
