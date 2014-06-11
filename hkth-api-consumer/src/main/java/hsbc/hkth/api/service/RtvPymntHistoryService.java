package hsbc.hkth.api.service;

import hsbc.hkth.api.consuming.PostRequestSender;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class RtvPymntHistoryService {

	private static final String RTV_PYMNT_HISTORY_REQUEST_JS_FILE = "RtvPymntHistoryRequest.js";

	private String url = "http://54.187.226.118:8281/RtrvPymntHistory/1";
	private String contentType = "application/x-www-form-urlencoded";

	
	public JsonObject retrievePaymentHistory() {

		String path = ClassLoader.getSystemResource(RTV_PYMNT_HISTORY_REQUEST_JS_FILE).getPath();
		StringBuffer requestPayload = new StringBuffer();

		try (FileReader fr = new FileReader(path);
				BufferedReader br = new BufferedReader(fr)) {
			String inputLine;
			while ((inputLine = br.readLine()) != null) {
				requestPayload.append(inputLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		PostRequestSender requestSender = new PostRequestSender();
		String response = null;

		try {
			response = requestSender.sendPost(url, contentType, requestPayload.toString());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		JsonObject jsonObject = new JsonParser().parse(response).getAsJsonObject();
		
		return jsonObject;
	}

}
