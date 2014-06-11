package hsbc.hkth.api.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class GspRtrvAcctSummServiceTest {

	String expectedResponse = "{	'responseCode':'0',	'countriesAccountList':[{		'entityID':{			'ctryCde':'GB',			'grpMmbr':'Y'		},		'acctLiteWrapper':[{			'acctIndex':'~1098-001-123456-001',			'displyID':'001-123456-001',			'prodCatCde':'Checking',			'entProdTypCde':'Checking Account',			'entProdCatCde':'DDA',			'status':'Active',			'isMaster':'False',			'isAmanahProd':'False',			'acctNknmInd':'0',			'ldgrBal':{				'amt':'1000', 				'ccy':'GBP'			},			'txnTypCdes':[{'txnCde':'Inquire'},{'txnCde':'Bill Payment'},{'txnCde':'Domestic Payment'}]		},{			'acctIndex':'~1098-001-123456-833',			'displyID':'001-123456-833',			'prodCatCde':'Savings',			'entProdTypCde':'Savings Account',			'entProdCatCde':'DDA',			'status':'Active',			'isMaster':'False',			'isAmanahProd':'False',			'acctNknmInd':'0',			'ldgrBal':{				'amt':'100000',				'ccy':'GBP'			},			'txnTypCdes':[{'txnCde':'Inquire'},{'txnCde':'Bill Payment'},{'txnCde':'Domestic Payment'}]		}],			'ttlLcyAmt':{			'amt':'101000',			'ccy':'GBP'		}	}]}";

	@Test
	public void mockedResponseIsCorrect() {

		// given
		GspRtrvAcctSummService service = new GspRtrvAcctSummService();

		// when
		String response = service.retrieveAccountSummary();
		System.out.println(response);
		response = response.trim();
		response = response.replace("\"", "'");

		// then
		assertEquals(expectedResponse, response);
	}
}
