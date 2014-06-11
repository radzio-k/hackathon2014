package hsbc.hkth.api.service;

import hsbc.hkth.api.consuming.PostRequestSender;

public class GspRtrvAcctSummService {

	private String url = "http://54.187.226.118:8281/RtrvAcctSumm/1";
	private String contentType = "application/json";
	private String payload = "{'accountSummaryFilter':{'EntityCdes':{'ctryCde':'GB','grpMmbr':'Y'}},'txnTypCdes':{'txnCde':'Inquire'}}";

	public String retrieveAccountSummary() {

		PostRequestSender requestSender = new PostRequestSender();
		String response = null;

		try {
			response = requestSender.sendPost(url, contentType, payload);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return response;
	}

}
