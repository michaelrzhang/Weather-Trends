import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

// http://juliusdavies.ca/json-simple-1.1.1-javadocs/org/json/simple/JSONObject.html JSON simple documentation

// things to add:
// Global warming detector
// ideal place to live
// 
// should grab new data on demand, then cache
// stores only parser
// one weather data should be reusable
// make a version of all the methods that takes only ID
public class CurrentWeatherData{
    private int cityID;
    private static JSONParser parser = new JSONParser();
    private JSONObject city_data;
    public CurrentWeatherData(int cityID) throws Exception{
        URL weather_data = new URL("http://api.openweathermap.org/data/2.5/weather?id=" + String.valueOf(cityID));
        URLConnection yc = weather_data.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                                    yc.getInputStream()));  // Grabs info from site
        String temp = "";
        String inputLine;
        while ((inputLine = in.readLine()) != null) 
            temp += inputLine;
        this.city_data = (JSONObject)parser.parse(temp);
        in.close();
        this.cityID = cityID;
    }

    public int getCityID(){
        return cityID;
    }

    public double getLat(){
        return (double)((JSONObject)city_data.get("coord")).get("lat");
    }

    public double getLon(){
        return (double)((JSONObject)city_data.get("coord")).get("lon");
    }

    public double getTemp(){
    //implement celsius and fahrehenit ways
        return (double)((JSONObject)city_data.get("main")).get("temp");
    }

    public static double getTemp(JSONObject data){
        return (double)((JSONObject)data.get("main")).get("temp");
    }

    public String getName(){
        return (String)city_data.get("name");
    }

    public static String getName(JSONObject data){
        return (String)data.get("name");
    }

}




