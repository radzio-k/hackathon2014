package hsbc.hkth.rest.api;

import hsbc.hkth.bo.PaymentsBO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.JsonObject;

@Path("/p")
public class PaymentsREST {

	@GET
	@Path("/payments")
	@Produces(MediaType.APPLICATION_JSON)
	public Response responseMsg() {
		PaymentsBO paymentsBO = new PaymentsBO();
		JsonObject payments = paymentsBO.getPaymentsForAccount();
		
		return Response.status(200).entity(payments.toString()).build();
	}
}