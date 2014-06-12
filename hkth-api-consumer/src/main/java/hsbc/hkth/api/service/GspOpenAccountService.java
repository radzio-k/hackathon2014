package hsbc.hkth.api.service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import hsbc.hkth.api.consuming.PostRequestSender;

public class GspOpenAccountService {

	private String url = "http://54.187.226.118:8281/OpenAct/1";
	private String contentType = "application/json";
	private String payload = "{'CustDetl':{'CustIdr':{'custID':'12345','EntityID':{'ctryCde':'GB','grpMmbr':'Y'}},'CustPrsnDetl':{'dateOfBirth':'1974/01/01','gender':'M','CustNames':{'titl':'MR','firstName':'JOHN','lastName':'SMITH','init':'P','fullName':'JOHN P SMITH','Locale':{'ctryCde':'GB','langCde':'EN'}}},'CustTel':{'phoneId':'work','areaCde':'408','CtryCde':'1','telFullNum':'+1-408-1234567','telNum':'1234567'},'CustEmailAddr':{'emailAddr':'john.smith@xxx.com','emailId':'primary'},'CustPermAddr':{'addrFrmtTyp':'Format A \\u2022   Address line 1 (Mandatory) \\u2022   Address line 2 (Optional) \\u2022   Address line 3 (Optional) \\u2022   Country (Mandatory)  Format B \\u2022  Address line 1 (Mandatory) \\u2022   Address line 2 (Optional) \\u2022   City (Mandatory) \\u2022   Province\\/State (Optional) \\u2022   Postal Code\\/Zip Code (Optional) \u2022   Country (Mandatory);','line1':'Unit 123','line2':'HSBC Center','line3':'1 HSBC Street','city':'London','prov':'England','postalCde':'E14 7N7','ctryCde':'UK'}},'NewActDetl':{'NewProdDetl':{'entProdTypCde':'Savings Account','entProdCatCde':'DDA'},'NewAcctCcy':{'ccy':'GBP'}}}";

	public JsonObject openAccount() {

		PostRequestSender requestSender = new PostRequestSender();
		String response = null;

		try {
			response = requestSender.sendPost(url, contentType, payload);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		JsonObject jsonObject = new JsonParser().parse(response).getAsJsonObject();
		
		return jsonObject;
	}

}
