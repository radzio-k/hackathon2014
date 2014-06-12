package hsbc.hkth.api.service.internal;

import java.math.BigDecimal;

import com.google.gson.JsonArray;

public class CalculateTxFXOptimisationSumService {
	
	public BigDecimal calculateGBPtoEURTxFXOptimSumFromJSonArray(JsonArray txPymntHist){
		BigDecimal txFeeOptimSum = new BigDecimal(10);
		CountTxService countTxService = new CountTxService();

		txFeeOptimSum = txFeeOptimSum.multiply(new BigDecimal(countTxService.countGBPtoEURTxFromJSonArray(txPymntHist)));
		
		CalculateTxFeeSumService serviceTxFeeSum = new CalculateTxFeeSumService();
		
		return serviceTxFeeSum.calculateGBPtoEURTxFeeSumFromJSonArray(txPymntHist).subtract(txFeeOptimSum);
	}
}
