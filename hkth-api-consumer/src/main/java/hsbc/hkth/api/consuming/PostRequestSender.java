package hsbc.hkth.api.consuming;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PostRequestSender {

	private final String USER_AGENT = "Mozilla/5.0";
	
	public String sendPost(String url) throws Exception {
		 
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		
		con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		
//		con.setRequestProperty("locale", "en");
//		con.setRequestProperty("devtype", "M");
//		con.setRequestProperty("platform", "A");
//		con.setRequestProperty("ver", "1.1");
//		con.setRequestProperty("cmd-All_in", "cmd-All_in");
//		con.setRequestProperty("statement", "0");
//		con.setRequestProperty("account_type", "CUA");
//		con.setRequestProperty("account_index", "004291209888~~AV~~CUA~~HKD~~HSBC Premier HKD Current~~DDA~~2C888HKD  ");
		
		String urlParameters = "locale=en&devtype=M&platform=A&ver=1.1&cmd-All_in=cmd-All_in&statement=0&account_type=CUA&account_index=004291209888~~AV~~CUA~~HKD~~HSBC Premier HKD Current~~DDA~~2C888HKD       HKDAVCUA&requestName=ac_current_history";
		 
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();
 
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);
 
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		//print result
		System.out.println(response.toString());
		return response.toString();
 
	}

}
