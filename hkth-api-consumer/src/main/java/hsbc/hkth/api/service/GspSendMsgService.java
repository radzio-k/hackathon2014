package hsbc.hkth.api.service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import hsbc.hkth.api.consuming.PostRequestSender;

public class GspSendMsgService {

	private String url = "http://54.187.226.118:8281/SendMsg/1";
	private String contentType = "application/json";
	private String payload = "{'CustID':{'custID':'12345','EntityID':{'ctryCde':'GB','grpMmbr':'Y'}},'MsgCustCreat':{'creatMsgDt':'2014-06-11','subjMsgText':'Already paid Mastercard bill','bdyMsgText':'I have already paid the bill, please confirm.'}}";

	public JsonObject sendMsg() {

		PostRequestSender requestSender = new PostRequestSender();
		String response = null;

		try {
			response = requestSender.sendPost(url, contentType, payload);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		JsonObject jsonObject = new JsonParser().parse(response).getAsJsonObject();
		
		return jsonObject;
	}

}
