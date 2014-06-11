package hsbc.hkth.api.consuming;

import org.junit.Assert;
import org.junit.Test;

public class PostRequestSenderTest {

	@Test
	public void requestHasResponse() {

		// given
		PostRequestSender sender = new PostRequestSender();
		String url = "http://54.187.226.118:8281/CurrentHistory/1";

		// when
		String output = null;
		try {
			output = sender.sendPost(url);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// then
		System.out.println(output);
		Assert.assertNotNull(output);
	}
}
