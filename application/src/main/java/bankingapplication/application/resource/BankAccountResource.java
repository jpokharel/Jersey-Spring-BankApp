package bankingapplication.application.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bankingapplication.application.model.Account;
import bankingapplication.application.service.AccountDetailsService;

@Component
@Path("/accounts")
@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })

// Autowired AccountDetailsService and check if that works to eliminate the new
// NULL Pointer Exception
public class BankAccountResource {

	//@Autowired
	private AccountDetailsService accountDetailsService=new AccountDetailsService();

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response getAccountDetails(@QueryParam("accountId") int accountId) {
		if (accountId <= 0) {
			return Response.status(Status.BAD_REQUEST).entity("No accountID").build();
		}

		/**
		 * The below code is problematic
		 */
		Account account = accountDetailsService.getAccountDetails(accountId);
		Response response = Response.status(Status.OK).entity(account).build();
		return response;

	}

	@GET
	@Path("/{accountId}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getAccountName(@PathParam("accountId") int accountId) {
		if (accountId < 1)
			return "Account ID is invalid";
		else {
			String val = accountDetailsService.getAccountName(accountId);
			return val;
		}
		// return "Value Account is
		// "+PlainJdbcConnection.returnNameOfAccount(123);

	}

	@POST
	@Path("/{accountId}")
	@Consumes(MediaType.APPLICATION_XML)
	public String createAccount(
			@PathParam("accountId") String accountId /*
														 * Use DTO for the input
														 * params in XML Space
														 * Here
														 */) {
		return "Account Created for you input ID: " + accountId;
	}

	@PUT
	@Path("/{accountId}")
	@Consumes(MediaType.APPLICATION_XML)
	public Response changeAccountDetails(
			@PathParam("accountId") String accountId /*
														 * Use DTO for the input
														 * params in XML Space
														 * Here
														 */) {
		return Response.status(Status.OK).entity("Altered the Account Details for your ID: " + accountId).build();
	}

	@DELETE
	@Path("/{accountId}")
	public Response deleteAccountDetails(
			@PathParam("accountId") String accountId /*
														 * Use DTO for the input
														 * params in XML Space
														 * Here
														 */) {
		return Response.status(Status.OK).entity("Deleted the account: " + accountId).build();
	}

}
