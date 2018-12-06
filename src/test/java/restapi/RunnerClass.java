package restapi;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

public class RunnerClass {
	@Test
	public void testGETResponse() throws IOException, JSONException
	{
		GET_WeatherDetails rest_get=new GET_WeatherDetails();
		rest_get.createConnection();
		rest_get.getHeaders();
		rest_get.getResponseCode();
		rest_get.getTheResponse();
		rest_get.getResponseNodeValue("City");
		rest_get.closeConnection();
	}

}
