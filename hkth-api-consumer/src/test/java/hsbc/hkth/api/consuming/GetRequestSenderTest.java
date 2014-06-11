package hsbc.hkth.api.consuming;

import org.junit.Assert;
import org.junit.Test;

public class GetRequestSenderTest {

	@Test
	public void requestHasResponse() {

		// given
		GetRequestSender sender = new GetRequestSender();
		String url = "http://172.31.36.18:8281/CustomerSearch/1/GB";

		// when
		String output = null;
		try {
			output = sender.sendGet(url);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// then
		Assert.assertNotNull(output);
	}
}
