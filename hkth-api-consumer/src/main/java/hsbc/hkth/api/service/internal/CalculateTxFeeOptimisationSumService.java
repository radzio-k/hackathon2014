package hsbc.hkth.api.service.internal;

import hsbc.hkth.api.service.GspSendMsgService;

import java.math.BigDecimal;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class CalculateTxFeeOptimisationSumService {
	
	public BigDecimal calculateGBPtoEURTxFeeOptimSumFromJSonArray(JsonArray txPymntHist){
		BigDecimal txFeeOptimSum = new BigDecimal(10);
		CountTxService countTxService = new CountTxService();

		txFeeOptimSum = txFeeOptimSum.multiply(new BigDecimal(countTxService.countGBPtoEURTxFromJSonArray(txPymntHist)));
		
		CalculateTxFeeSumService serviceTxFeeSum = new CalculateTxFeeSumService();
		
		//Fake call to msg service to notify the customer that we have some savings available
		GspSendMsgService serviceMsg = new GspSendMsgService();
		// when
		JsonObject responseMsg = serviceMsg.sendMsg();
		
		return serviceTxFeeSum.calculateGBPtoEURTxFeeSumFromJSonArray(txPymntHist).subtract(txFeeOptimSum);
	}
}
