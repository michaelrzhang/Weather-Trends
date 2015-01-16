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
public class UrlContent{
    public static void main(String[] args) throws Exception{

       
        URL weather_data = new URL("http://api.openweathermap.org/data/2.5/weather?id=5350734");
        URLConnection yc = weather_data.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                                    yc.getInputStream()));  // Grabs info from site
        String total_info = "";
        String inputLine;
        while ((inputLine = in.readLine()) != null) 
            total_info += inputLine;
        System.out.println(total_info);
        JSONParser parser=new JSONParser();
        JSONObject obj= (JSONObject)parser.parse(total_info);
        System.out.println("debug");
        System.out.println("getting name");

        System.out.println(getName(obj));
        System.out.println(getTemp(obj));

        in.close();

    }

    public static double getTemp(JSONObject data){
        return (double)((JSONObject)data.get("main")).get("temp");
    }

    public static String getName(JSONObject data){
        return (String)data.get("name");
    }

}




