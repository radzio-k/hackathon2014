package hsbc.hkth.api.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.google.gson.JsonObject;

public class GspOpenAccountServiceTest {

	@Test
	public void responseNotNUll() {
		// given
		GspOpenAccountService service = new GspOpenAccountService();

		// when
		JsonObject response = service.openAccount();

		// then
		System.out.println(response);
		assertNotNull(response);
	}

}
