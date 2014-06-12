package hsbc.hkth.api.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.google.gson.JsonArray;

public class RtvPymntHistoryServiceTest {

	@Test
	public void responseNotNUll() {
		// given
		RtvPymntHistoryService service = new RtvPymntHistoryService();

		// when
		JsonArray response = service.retrievePaymentHistory();

		// then
		System.out.println(response);
		assertNotNull(response);
	}

}
