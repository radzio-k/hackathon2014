package hsbc.hkth.api.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class RtvPymntHistoryService {

	private static final String RTV_PYMNT_HISTORY_RESPONSE_JS_FILE = "RtvPymntHistoryResponse.js";

	public JsonObject retrievePaymentHistory() {

		String path = ClassLoader.getSystemResource(RTV_PYMNT_HISTORY_RESPONSE_JS_FILE).getPath();
		StringBuffer response = new StringBuffer();

		try (FileReader fr = new FileReader(path);
				BufferedReader br = new BufferedReader(fr)) {
			String inputLine;
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

		JsonObject jsonObject = new JsonParser().parse(response.toString()).getAsJsonObject();	
		
		return jsonObject;

	}

}
