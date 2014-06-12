package hsbc.hkth.api.service;

import hsbc.hkth.api.consuming.PostRequestSender;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class RtvPymntHistoryService {

	private String url = "http://54.187.226.118:8281/RtrvPymntHistory/1";
	private String contentType = "application/json";

	public JsonArray retrievePaymentHistory() {

		String payload = "{'AcctInfo':{'acctIndex':'~1098-001-123456-001','entProdTypCde':'Checking Account','entProdCatCde':'DDA'},'Filter':{'startDate':'19000101','endDate':''}}";
		PostRequestSender requestSender = new PostRequestSender();
		String response = null;

		try {
			response = requestSender.sendPost(url, contentType, payload);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		JsonArray responseArray = new JsonParser().parse(response)
				.getAsJsonArray();
		return responseArray;
	}

}
