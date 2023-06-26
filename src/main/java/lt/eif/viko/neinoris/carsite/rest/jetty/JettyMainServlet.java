package lt.eif.viko.neinoris.carsite.rest.jetty;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class JettyMainServlet extends HttpServlet {
    public JettyMainServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();


        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.println("<center>");
        out.println("<h1>Vehicle Information</h1>");
        out.println("<form action=\"vinanswer\" method=\"POST\">");
        out.println("<p>Enter your VIN code:</p>");
        out.println("<input type=\"text\" id=\"VIN\" name=\"VIN\">");
        out.println("<button type=\"submit\" name=\"button1\">Search</button>");
        out.println("</form>");
        out.println("</br>");
        out.println("</br>");
        out.println("</br>");
        out.println("<p>Basic information lookup:</p>");
        out.println("<p>Manufacturer</p>");
        out.println("<form action=\"carinfo\" method=\"POST\">");
        out.println("<input type=\"text\" id=\"manuf\" name=\"manuf\">");
        out.println("</br>");
        out.println("<p>Model</p>");
        out.println("<input type=\"text\" id=\"model\" name=\"model\">");
        out.println("</br>");
        out.println("<p>Year</p>");
        out.println("<input type=\"text\" id=\"year\" name=\"year\">");
        out.println("</br>");
        out.println("</br>");
        out.println("<button type=\"submit\" name=\"button2\">Search</button>");
        out.println("</form>");
        out.println("</center>");
        out.println("</body>");
        out.println("</html>");
    }
}