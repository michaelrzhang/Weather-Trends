import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.simple.JSONObject;

// things to add:
// Global warming detector
// ideal place to live
public class UrlContent{
    public static void main(String[] args) throws Exception{

        JSONObject obj=new JSONObject();
        obj.put("num",new Integer(100));
        System.out.print(obj);

       
        URL weather_data = new URL("http://api.openweathermap.org/data/2.5/weather?id=5350734");
        URLConnection yc = weather_data.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                                    yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) 
            System.out.println(inputLine);
        in.close();

    }

}




