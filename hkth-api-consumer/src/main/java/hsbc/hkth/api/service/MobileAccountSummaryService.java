package hsbc.hkth.api.service;

import hsbc.hkth.api.consuming.PostRequestSender;

public class MobileAccountSummaryService {

	private String url = "http://54.187.226.118:8281/AccountSummary/1";
	private String contentType = "application/x-www-form-urlencoded";
	private String payload = "devtype=M&locale=en&platform=A&requestName=ac_summary&ver=1.1&json=&__cmd-All_MenuRefresh=__cmd-All_MenuRefresh&refresh=Y";

	public String getAccountSummary() {

		PostRequestSender requestSender = new PostRequestSender();
		String response = null;

		try {
			response = requestSender.sendPost(url, contentType, payload);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return response;
	}

}
