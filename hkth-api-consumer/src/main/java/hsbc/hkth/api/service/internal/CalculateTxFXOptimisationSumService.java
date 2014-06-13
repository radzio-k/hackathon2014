package hsbc.hkth.api.service.internal;

import hsbc.hkth.api.service.GspRtrvFxRatesService;
import hsbc.hkth.api.service.GspSendMsgService;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class CalculateTxFXOptimisationSumService {
	
	public BigDecimal calculateGBPtoEURTxFXOptimSumFromJSonArray(JsonArray txPymntHist){
		//fake call to simulate API call
		GspRtrvFxRatesService service = new GspRtrvFxRatesService();
		JsonObject response = service.retrieveFXRates();
		
		CalculateTxSumService serviceTxSum = new CalculateTxSumService();
		BigDecimal respTxSum = serviceTxSum.calculateGBPtoEURTxSumFromJSonArray(txPymntHist);
		
		//Fake call to msg service to notify the customer that we have some savings available
		GspSendMsgService serviceMsg = new GspSendMsgService();
		JsonObject responseMsg = serviceMsg.sendMsg();
		
		return respTxSum.multiply(new BigDecimal(0.963)).setScale(2, RoundingMode.HALF_UP);
	}
}
