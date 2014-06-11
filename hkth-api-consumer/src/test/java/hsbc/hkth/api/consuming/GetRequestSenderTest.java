package hsbc.hkth.api.consuming;

import org.junit.Assert;
import org.junit.Test;

public class GetRequestSenderTest {

	@Test
	public void requestHasResponse() {

		// given
		GetRequestSender sender = new GetRequestSender();
		String url = "http://54.187.226.118:8281/CustomerSearch/1/GB";

		// when
		String output = null;
		try {
			output = sender.sendGet(url);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// then
		System.out.println(output);
		Assert.assertNotNull(output);
	}
}
