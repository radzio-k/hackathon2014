package hsbc.hkth.api.consuming;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PostRequestSender {

	public String sendPost(String url) throws Exception {

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// add reuqest header
		con.setRequestMethod("POST");

		con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

		String payload = "locale%3Den%26devtype%3DM%26platform%3DA%26ver%3D1.1%26json%3D%26cmd-All_in%3Dcmd-All_in%26statement%3D0%26account_type%3DCUA%26account_index%3D004291209888~~AV~~CUA~~HKD~~HSBC+Premier+HKD+Current~~DDA~~2C888HKD+++++++HKDAVCUA%26requestName%3Dac_current_history";
		
		// Send post request
		con.setDoOutput(true);

		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(payload);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + payload);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		return response.toString();
	}

}
