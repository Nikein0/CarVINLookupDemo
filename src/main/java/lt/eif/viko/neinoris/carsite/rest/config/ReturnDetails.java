package lt.eif.viko.neinoris.carsite.rest.config;

import jakarta.servlet.http.HttpServletRequest;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class ReturnDetails {
    public void returnDetails(HttpServletRequest request) throws JSONException, IOException {
        HTMLRequest htmlRequest = new HTMLRequest();
        JSONObject jsonObject = new JSONObject();
        jsonObject = htmlRequest.ReceiveFromSimpleSearch(request.getParameter("make"), request.getParameter("model"), request.getParameter("year"));
        JSONArray jsonArray = new JSONArray();
        jsonArray = sortJSON(jsonObject);
        JSONsorting jsoNsorting = new JSONsorting(jsonObject.getString("drive_type"));
        jsoNsorting.setDrive_type(jsonObject.getString("drive_type"));
    }
    public JSONArray sortJSON(JSONObject jsonObject) throws JSONException {
        return jsonObject.getJSONArray("data");
    }
}
