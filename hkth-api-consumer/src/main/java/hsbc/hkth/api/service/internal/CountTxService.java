package hsbc.hkth.api.service.internal;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.JsonArray;

public class CountTxService {
	
	public int countGBPtoEURTxFromJSonArray(JsonArray txPymntHist){
		BigDecimal txFeeSum = new BigDecimal(00);

		Pattern pGlobal = Pattern.compile("(\"amt\":\"\\d+.*?\"ccy\":\"\\D{3}\")", Pattern.DOTALL);
	    Matcher mGlobal = pGlobal.matcher(txPymntHist.toString());
	    
	    int count = 0;
	    while (mGlobal.find()){
	    	if ( (count % 2) == 0 && count > 0){
	    	    //this is a payment in EUR
	    		//txFeeSum = txFeeSum.add(new BigDecimal(mGlobal.group().replaceAll("\\D+","")));
	    	}
	    	else {
	    	    //this is a payment fee for EUR transaction
	    		if(count>0){
	    			txFeeSum = txFeeSum.add(new BigDecimal(mGlobal.group().replaceAll("\\D+","")));
	    		}
	    	}
	    	count++;
	    }
	    count = count / 2;
	    //System.out.println(count);
		return count;
	}
}
