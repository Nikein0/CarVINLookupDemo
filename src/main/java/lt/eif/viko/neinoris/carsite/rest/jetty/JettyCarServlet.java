package lt.eif.viko.neinoris.carsite.rest.jetty;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lt.eif.viko.neinoris.carsite.rest.config.HTMLRequest;
import lt.eif.viko.neinoris.carsite.rest.config.JSONsorting;
import lt.eif.viko.neinoris.carsite.rest.config.ReturnDetails;
import lt.eif.viko.neinoris.carsite.rest.service.Carservice;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;

public class JettyCarServlet extends HttpServlet {
    public JettyCarServlet() {
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
            HTMLRequest htmlRequest = new HTMLRequest();
            ReturnDetails returnDetails = new ReturnDetails();
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject = htmlRequest.ReceiveFromSimpleSearch(request.getParameter("make"), request.getParameter("model"), request.getParameter("year"));
                returnDetails.sortJSON(jsonObject);
                PrintWriter out = response.getWriter();
                jsonObject =  returnDetails.sortJSON(jsonObject).getJSONObject(1);
                out.println("<html>");
                out.println("<body>");
                out.println("<h1>Vehicle Information</h1>");
                out.println("<p>Make: " + request.getParameter("manuf") + "</p>");
                out.println("<p>Model: " + request.getParameter("model") + "</p>");
                out.println("<p>Year: " + request.getParameter("year") + "</p>");
                out.println("<p>Drive type: " + jsonObject.getString("drive_type") + "</p>");
                out.println("<p>Cylinders: " + jsonObject.getString("cylinders") + "</p>");
                out.println("<p>Horsepower: " + jsonObject.getString("horsepower_hp") + " HP</p>");
                out.println("<p>Cylinders: " + jsonObject.getString("cylinders") + "</p>");
                out.println("<p>Cam type: " + jsonObject.getString("cam_type") + "</p>");
                out.println("<p>Transmission: " + jsonObject.getString("transmission") + "</p>");

                //out.println("<form action=\"pdf\" method=\"POST\">");
                //out.println("<button type=\"submit\" name=\"button1\">Test</button>");
                //out.println("</form>");
                out.println("</body>");
                out.println("</html>");
            }catch (JSONException e) {
                throw new RuntimeException(e);
            }
    }
}
