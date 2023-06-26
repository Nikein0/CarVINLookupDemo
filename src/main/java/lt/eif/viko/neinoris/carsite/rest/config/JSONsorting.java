package lt.eif.viko.neinoris.carsite.rest.config;

import jakarta.servlet.http.HttpServletRequest;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class JSONsorting {
    public JSONsorting(String data) {
        this.data = data;
    }
    public JSONsorting() {

    }

    private String data;



    public void returnDetails(HttpServletRequest request) throws JSONException, IOException {
        HTMLRequest htmlRequest = new HTMLRequest();
        ReturnDetails returnDetails = new ReturnDetails();
        JSONObject jsonObject = new JSONObject();
        jsonObject = htmlRequest.ReceiveFromSimpleSearch(request.getParameter("make"), request.getParameter("model"), request.getParameter("year"));
        JSONArray jsonarray = new JSONArray();
        jsonarray = returnDetails.sortJSON(jsonObject);
        setDrive_type(jsonObject.getString("drive_type"));
    }

    public String getDrive_type() {
        return data;
    }

    public void setDrive_type(String data) {
        this.data = data;
    }
}
