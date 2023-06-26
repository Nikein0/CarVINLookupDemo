package lt.eif.viko.neinoris.carsite.rest.jetty;


import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;

public class JettyServer {
    private Server server;

    public JettyServer() {
    }

    public void start() throws Exception {
        this.server = new Server();
        ServerConnector connector = new ServerConnector(this.server);
        connector.setPort(8090);
        this.server.setConnectors(new Connector[]{connector});
        ServletHandler servletHandler = new ServletHandler();
        this.server.setHandler(servletHandler);
        servletHandler.addServletWithMapping(JettyMainServlet.class, "/vinlookup");
        servletHandler.addServletWithMapping(JettyVINServlet.class, "/vinanswer");
        servletHandler.addServletWithMapping(JettyCarServlet.class, "/carinfo");
        this.server.start();
    }

    void stop() throws Exception {
        this.server.stop();
    }
}
