package restapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class GET_AllCountries {
	HttpURLConnection con;
	BufferedReader br;
	int responseCode;
	JSONObject json;
	StringBuffer response = null;
	String stringResponse = null;
	static Set<String> finalListOfKeys = new LinkedHashSet<String>();
	static List<String> list=new ArrayList<String>();
	@Test
	public void test() throws IOException, JSONException
	{
		
		String link="http://services.groupkt.com/country/get/all";
		URL url = new URL(link);
		con=(HttpURLConnection)url.openConnection() ;
		con.setRequestMethod("GET");
		con.setRequestProperty("Accept", "application/json");
		responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
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
		json=new JSONObject(stringResponse);
		Iterator<?> jsonKeys = json.keys();
	        if (jsonKeys.hasNext()) {
	        	String key=(String) jsonKeys.next();
	            Object val = json.get(key);
	            if (val instanceof JSONArray) {
	                JSONArray array = (JSONArray) val;
	                jsonArray(array, key);

	            } else if (val instanceof JSONObject) {
	                JSONObject jsonOb = (JSONObject) val;
	                jsonObj(jsonOb, key);
	            } else {
	                finalListOfKeys.add(key);
	             //   System.out.println("Key is : " + key);
	            }
	        }
	        System.out.println(list.get(0));
	}
	public static void jsonObj(JSONObject object, String key2) throws JSONException {
	    Iterator<?> innerKeys =  object.keys();
	    if (innerKeys.hasNext()) {
	    	String key=(String) innerKeys.next();
	     //   System.out.println("Key : " + key);
	        Object val = object.get(key);
	        if (val instanceof JSONArray) {
	            JSONArray array = (JSONArray) val;
	            jsonArray(array, key2 + "->" + key);

	        } else if (val instanceof JSONObject) {
	            JSONObject jsonOb = (JSONObject) val;
	            jsonObj(jsonOb, key2 + "->" + key);
	        } else {
	            finalListOfKeys.add(key2 + "->" + key);
	          //  System.out.println("Key is : " + key2 + "->" + key);
	        }
	    }
	}

	public static void jsonArray(JSONArray array, String key) throws JSONException {
	    if (array.length() == 0) {
	        finalListOfKeys.add(key);
	    } else {

	        for (int i = 0; i < array.length(); i++) {
	            Object jObject = array.get(i);
	            if (jObject instanceof JSONObject) {
	                JSONObject job = (JSONObject) jObject;
	             //   System.out.println(job);
	                jsonObj(job, key);
	                list.add(job.toString());
	            }
	        }
	    }
	}
}
