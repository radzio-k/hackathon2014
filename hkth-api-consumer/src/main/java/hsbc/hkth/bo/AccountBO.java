package hsbc.hkth.bo;

import hsbc.hkth.api.service.GspRtrvAcctSummService;
import hsbc.hkth.api.service.MobileAccountSummaryService;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class AccountBO {

	public JsonArray getAccounts() {

		GspRtrvAcctSummService gspService = new GspRtrvAcctSummService();
		gspService.retrieveAccountSummary();
		
		MobileAccountSummaryService service = new MobileAccountSummaryService();
		JsonObject accountsSummary = service.getAccountSummary();

		JsonArray accounts = accountsSummary.get("body").getAsJsonObject()
				.get("entities").getAsJsonArray().get(0).getAsJsonObject()
				.get("accountGroups").getAsJsonArray().get(0).getAsJsonObject()
				.get("accounts").getAsJsonArray();

		return accounts;
	}
}
