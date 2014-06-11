package hsbc.hkth.api.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.google.gson.JsonObject;

public class RtvPymntHistoryServiceTest {

	@Test
	public void readResponseFile() {

		// given
		RtvPymntHistoryService service = new RtvPymntHistoryService();

		// when
		JsonObject response = service.retrievePaymentHistory();

		// then
		System.out.println(response);
		assertNotNull(response);

	}

}
