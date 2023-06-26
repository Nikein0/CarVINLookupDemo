package lt.eif.viko.neinoris.carsite.rest.config;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HTMLRequest {
    RequestLoad requestLoad = new RequestLoad();
    public JSONObject ReceiveFromVIN(String VIN) throws IOException, JSONException {

        URL localhost = new URL("http://localhost:8383/carinfo/getinfo");
        URLConnection yc = localhost.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        yc.getInputStream()));
        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
            requestLoad.setRequest(inputLine);
        }
        in.close();
        return new JSONObject(requestLoad.getRequest());
        //System.out.println("Year:" + jsonObject.getString("year"));
        //JSONObject jsonObject1 = new JSONObject(jsonObject.getString("specs"));
        //System.out.println("Vehicle type:" + jsonObject1.getString("vehicle_type"));
    }
    public JSONObject ReceiveFromSimpleSearch(String make, String model, String year) throws IOException, JSONException {
        URL localhost = new URL("http://localhost:8383/carinfo/getinfosimple");
        URLConnection yc = localhost.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        yc.getInputStream()));
        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
            requestLoad.setRequest(inputLine);
        }
        in.close();
        return new JSONObject(requestLoad.getRequest());
    }

}
