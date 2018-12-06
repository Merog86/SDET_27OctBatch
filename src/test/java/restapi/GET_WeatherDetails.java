package restapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;

public class GET_WeatherDetails {
	HttpURLConnection con;
	BufferedReader br;
	int responseCode;
	JSONObject json;
	StringBuffer response = null;
	String stringResponse = null;
	public void createConnection() throws IOException
	{
		String link="http://restapi.demoqa.com/utilities/weather/city/Hyderabad";
		URL url = new URL(link);
		con=(HttpURLConnection)url.openConnection() ;
		con.setRequestMethod("GET");
		con.setRequestProperty("Accept", "application/json");
	}
	
	public BufferedReader getHeaders() throws IOException
	{
		 br = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
		System.out.println(con.getHeaderField("Content-Type"));
		System.out.println(con.getHeaderField("Server"));
		return br;
	}
	
	public int getResponseCode() throws IOException
	{
		
		responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
		
		return responseCode;
		
	}
	
	public String getTheResponse() throws IOException {
		
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			
			System.out.println(response.toString());
			stringResponse=response.toString();
		} else {
			System.out.println("GET request not worked");
		}
		return stringResponse;
	}
	
	public String getResponseNodeValue(String nodeName) throws JSONException
	{
		json=new JSONObject(stringResponse);
		Iterator<?> keys=json.keys();
		HashMap<String, String> map=new HashMap<String, String>();
		
		while(keys.hasNext())
		{
			String key=(String)keys.next();
			String value=(String)json.get(key);
			map.put(key, value);
		}
		System.out.println((String) map.get(nodeName));
		return (String) map.get(nodeName);
	
	}
	
	public void closeConnection()
	{
		con.disconnect();
	}
	
}
