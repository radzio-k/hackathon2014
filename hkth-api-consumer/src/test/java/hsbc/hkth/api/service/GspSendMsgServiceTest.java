package hsbc.hkth.api.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.google.gson.JsonObject;

public class GspSendMsgServiceTest {

	@Test
	public void responseNotNUll() {
		// given
		GspSendMsgService service = new GspSendMsgService();

		// when
		JsonObject response = service.sendMsg();

		// then
		System.out.println(response);
		assertNotNull(response);
	}

}
