package hsbc.hkth.api.service.internal;

import static org.junit.Assert.assertEquals;
import hsbc.hkth.api.service.RtvPymntHistoryService;

import java.math.BigDecimal;

import org.junit.Test;

import com.google.gson.JsonArray;

public class CalculateTxSumServiceTest {

	String expectedResponse = "{	'responseCode':'0',	'countriesAccountList':[{		'entityID':{			'ctryCde':'GB',			'grpMmbr':'Y'		},		'acctLiteWrapper':[{			'acctIndex':'~1098-001-123456-001',			'displyID':'001-123456-001',			'prodCatCde':'Checking',			'entProdTypCde':'Checking Account',			'entProdCatCde':'DDA',			'status':'Active',			'isMaster':'False',			'isAmanahProd':'False',			'acctNknmInd':'0',			'ldgrBal':{				'amt':'1000', 				'ccy':'GBP'			},			'txnTypCdes':[{'txnCde':'Inquire'},{'txnCde':'Bill Payment'},{'txnCde':'Domestic Payment'}]		},{			'acctIndex':'~1098-001-123456-833',			'displyID':'001-123456-833',			'prodCatCde':'Savings',			'entProdTypCde':'Savings Account',			'entProdCatCde':'DDA',			'status':'Active',			'isMaster':'False',			'isAmanahProd':'False',			'acctNknmInd':'0',			'ldgrBal':{				'amt':'100000',				'ccy':'GBP'			},			'txnTypCdes':[{'txnCde':'Inquire'},{'txnCde':'Bill Payment'},{'txnCde':'Domestic Payment'}]		}],			'ttlLcyAmt':{			'amt':'101000',			'ccy':'GBP'		}	}]}";

	@Test
	public void mockedCalculationIsCorrect() {

		// given
		BigDecimal expectedTxSum = new BigDecimal(3700000);
		BigDecimal expectedTxFeeSum = new BigDecimal(3710);
		int expectedCountTx = 15;
		BigDecimal expectedtxFeeOptim = new BigDecimal(3560);
		BigDecimal expectedtxSumFXOptim = new BigDecimal(3560);
		
		CalculateTxSumService serviceTxSum = new CalculateTxSumService();
		CalculateTxFeeSumService serviceTxFeeSum = new CalculateTxFeeSumService();
		RtvPymntHistoryService servicePymntHist = new RtvPymntHistoryService();
		CountTxService countTxService = new CountTxService();
		
		CalculateTxFeeOptimisationSumService txFeeOptimService = new CalculateTxFeeOptimisationSumService();
		CalculateTxFXOptimisationSumService txFXOptimService = new CalculateTxFXOptimisationSumService();
		

		// when
		JsonArray respPymntHist = servicePymntHist.retrievePaymentHistory();
		BigDecimal respTxSum = serviceTxSum.calculateGBPtoEURTxSumFromJSonArray(respPymntHist);
		BigDecimal respTxFeeSum = serviceTxFeeSum.calculateGBPtoEURTxFeeSumFromJSonArray(respPymntHist);
		int countTxGBPtoEUR = countTxService.countGBPtoEURTxFromJSonArray(respPymntHist);
		BigDecimal txFeeOptim = txFeeOptimService.calculateGBPtoEURTxFeeOptimSumFromJSonArray(respPymntHist);
		BigDecimal txSumFXOptim = txFXOptimService.calculateGBPtoEURTxFXOptimSumFromJSonArray(respPymntHist);
		
		// then
		assertEquals(expectedTxSum, respTxSum);
		assertEquals(expectedTxFeeSum, respTxFeeSum);
		assertEquals(expectedCountTx, countTxGBPtoEUR);
		assertEquals(expectedtxFeeOptim, txFeeOptim);
		assertEquals(expectedtxSumFXOptim, txSumFXOptim);
		
		System.out.println("HSBC can save this customer: " + txFeeOptim + " in tx fees with an orginal nb of tx of " + countTxGBPtoEUR + " for a original total of: " + respTxFeeSum);
		System.out.println("");
		System.out.println("HSBC can save this customer: " + txSumFXOptim + " with optimised fx rates with an orginal amount of " + respTxSum);
	}
}
