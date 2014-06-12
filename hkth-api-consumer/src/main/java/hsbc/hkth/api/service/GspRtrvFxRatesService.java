package hsbc.hkth.api.service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import hsbc.hkth.api.consuming.PostRequestSender;

public class GspRtrvFxRatesService {

	private String url = "http://54.187.226.118:8281/RtrvFxRates/1";
	private String contentType = "application/json";
	private String payload = "{'CustomerIdentifier':{'custID':'12345','EntityID':{'ctryCde':'GB','groupMbr':'Y'}},'LocalCurrency':{'ccyCde':'HKD'},'RequestedType':{'requestedType':'1'},'RequestedOperation':{'requestedOperation':'1'},'MapAttrib':{'chnlId':'M','lineOfBus':'PFS'}}";

	public JsonObject retrieveFXRates() {

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
