package hsbc.hkth.api.consuming;

import org.junit.Assert;
import org.junit.Test;

public class PostRequestSenderTest {

	@Test
	public void mobileCurrentHistoryResponds() {

		// given
		PostRequestSender sender = new PostRequestSender();
		String url = "http://54.187.226.118:8281/CurrentHistory/1";
		String contentType = "application/x-www-form-urlencoded";
		String payload = "locale%3Den%26devtype%3DM%26platform%3DA%26ver%3D1.1%26json%3D%26cmd-All_in%3Dcmd-All_in%26statement%3D0%26account_type%3DCUA%26account_index%3D004291209888~~AV~~CUA~~HKD~~HSBC+Premier+HKD+Current~~DDA~~2C888HKD+++++++HKDAVCUA%26requestName%3Dac_current_history";

		// when
		String output = null;
		try {
			output = sender.sendPost(url, contentType, payload);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// then
		Assert.assertNotNull(output);
	}
	
	@Test
	public void gspRtrvAcctSumm() {

		// given
		PostRequestSender sender = new PostRequestSender();
		String url = "http://54.187.226.118:8281/RtrvAcctSumm/1";
		String contentType = "application/json";
		String payload = "{'accountSummaryFilter':{'EntityCdes':{'ctryCde':'GB','grpMmbr':'Y'}},'txnTypCdes':{'txnCde':'Inquire'}}";

		// when
		String output = null;
		try {
			output = sender.sendPost(url, contentType, payload);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// then
		Assert.assertNotNull(output);
	}
	
}
