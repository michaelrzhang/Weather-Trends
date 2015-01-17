import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class Test{
	public static void main(String[] args) throws Exception{
		CurrentWeatherData test = new CurrentWeatherData(5350734);
		System.out.println(test.getCityID());
		System.out.println(test.getLat());
		System.out.println(test.getName());
		System.out.println(test.getTemp());
	}
}