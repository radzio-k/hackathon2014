package hsbc.hkth.api.service.internal;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.JsonArray;

public class CalculateTxSumService {
	
	public BigDecimal calculateGBPtoEURTxSumFromJSonArray(JsonArray txPymntHist){
		BigDecimal txSum = new BigDecimal(00);

		Pattern pGlobal = Pattern.compile("(\"amt\":\"\\d+.*?\"ccy\":\"\\D{3}\")", Pattern.DOTALL);
	    Matcher mGlobal = pGlobal.matcher(txPymntHist.toString());
	    
		Pattern pDebitPymnt = Pattern.compile("(\"debitAcctCcy\":\"\\D{3}.*?\"paymentCcy\":\"\\D{3}\")", Pattern.DOTALL);
	    Matcher mDebitPymnt = pDebitPymnt.matcher(txPymntHist.toString());
	    
	    int count = 0;
	    while (mGlobal.find()){
	    	if ( (count % 2) == 0 && count > 0){
	    	    //this is a payment in EUR
	    		txSum = txSum.add(new BigDecimal(mGlobal.group().replaceAll("\\D+","")));
	    	}
	    	else {
	    	    //this is a payment fee for EUR transaction
	    		if(count>0){
	    			//System.out.println(mGlobal.group().replaceAll("\\D+",""));
	    		}
	    	}
	    	count++;
	    }

	    while (mDebitPymnt.find()){
	    	//System.out.println(mDebitPymnt.group());
	    	count ++;
	    }
	    
	    //System.out.println(txSum);
		return txSum;
	}
}
