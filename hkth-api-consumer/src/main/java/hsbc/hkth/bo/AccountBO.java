package hsbc.hkth.bo;

import hsbc.hkth.api.service.MobileAccountSummaryService;

import com.google.gson.JsonObject;

public class AccountBO {

	public JsonObject getAccounts() {
	
		MobileAccountSummaryService service = new MobileAccountSummaryService();
		JsonObject accounts = service.getAccountSummary();
		
		accounts.get("accounts");
		
		return accounts;
	}
	
}
