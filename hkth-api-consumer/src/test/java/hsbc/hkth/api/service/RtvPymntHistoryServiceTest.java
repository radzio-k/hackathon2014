package hsbc.hkth.api.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import com.google.gson.JsonObject;

public class RtvPymntHistoryServiceTest {

	@Test
	public void readResponseFile() {
		
		String RTV_PYMNT_HISTORY_REQUEST_JS_FILE = "RtvPymntHistoryResponse.js";
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
		}

		// given
		RtvPymntHistoryService service = new RtvPymntHistoryService();
		//JsonObject expectedJson = new JsonParser().parse(requestPayload.toString()).getAsJsonObject();
		
		// when
		JsonObject response = service.retrievePaymentHistory();

		// then
		//assertEquals(expectedJson, response);
	}

}
