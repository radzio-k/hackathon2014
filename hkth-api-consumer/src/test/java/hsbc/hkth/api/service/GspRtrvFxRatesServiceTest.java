package hsbc.hkth.api.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class GspRtrvFxRatesServiceTest {

	String expectedResponse = "{'Rate':[{'primaryCcy':'HKD','counterCcy':'USD','askRate':'7.68890','bidRate':'7.81410','rateType':'1'},{'primaryCcy':'HKD','counterCcy':'AUD','askRate':'7.15590','bidRate':'7.34880','rateType':'1'},{'primaryCcy':'HKD','counterCcy':'CAD','askRate':'7.01180','bidRate':'7.20990','rateType':'1'},{'primaryCcy':'HKD','counterCcy':'EUR','askRate':'10.39100','bidRate':'10.67620','rateType':'1'},{'primaryCcy':'HKD','counterCcy':'JPY','askRate':'0.07460','bidRate':'0.07684','rateType':'1'},{'primaryCcy':'HKD','counterCcy':'MYR','askRate':'2.25000','bidRate':'2.55000','rateType':'1'},{'primaryCcy':'HKD','counterCcy':'GBP','askRate':'12.86800','bidRate':'13.19600','rateType':'1'},{'primaryCcy':'HKD','counterCcy':'RMB','askRate':'1.22820','bidRate':'1.25990','rateType':'1'}]}";

	@Test
	public void mockedResponseIsCorrect() {

		// given
		GspRtrvFxRatesService service = new GspRtrvFxRatesService();
		JsonObject expectedJson = new JsonParser().parse(expectedResponse).getAsJsonObject();

		// when
		JsonObject response = service.retrieveFXRates();
		System.out.println(response);

		// then
		assertEquals(expectedJson, response);
	}
}
