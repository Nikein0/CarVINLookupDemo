package lt.eif.viko.neinoris.carsite.rest.jetty;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lt.eif.viko.neinoris.carsite.rest.config.HTMLRequest;
import lt.eif.viko.neinoris.carsite.rest.models.Car;
import lt.eif.viko.neinoris.carsite.rest.service.Carservice;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;

public class JettyVINServlet extends HttpServlet {
    public JettyVINServlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HTMLRequest htmlRequest = new HTMLRequest();
        JSONObject jsonObject1 = new JSONObject();
        JSONObject jsonObject2 = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        Carservice carservice = new Carservice();
        try {
            carservice.setVIN(request.getParameter("VIN"));
            try (PrintWriter saveinput = new PrintWriter("VINinput.txt")) {
                saveinput.println(request.getParameter("VIN"));
            }
            jsonObject1 = htmlRequest.ReceiveFromVIN(request.getParameter("VIN"));
            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<body>");
            out.println("<h1>Vehicle Information</h1>");
            out.println("<p>Make: " + jsonObject1.getString("make") +"</p>");
            out.println("<p>Model: " + jsonObject1.getString("model") +"</p>");
            out.println("<p>Trim: " + jsonObject1.getString("trim") +"</p>");
            out.println("<p>Year: " + jsonObject1.getString("year") + "</p>");
            jsonObject2 = jsonObject1.getJSONObject("specs");
            out.println("<p>Body class: " + jsonObject2.getString("body_class") + "</p>");
            out.println("<p>Horsepower: " + jsonObject2.getString("engine_brake_hp_from") + "</p>");
            out.println("<p>Fuel type: " + jsonObject2.getString("fuel_type_primary") + "</p>");
            out.println("<p>Displacement: " + jsonObject2.getString("displacement_l") + "</p>");
            out.println("<p>Number of cylinders: " + jsonObject2.getString("engine_number_of_cylinders") + "</p>");
            jsonArray = jsonObject1.getJSONArray("trims");
            jsonObject1 = jsonArray.getJSONObject(1);
            out.println("<p>Description: " + jsonObject1.getString("description") + "</p>");
            //out.println("<form action=\"pdf\" method=\"POST\">");
            //out.println("<button type=\"submit\" name=\"button1\">Test</button>");
            //out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
        catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}