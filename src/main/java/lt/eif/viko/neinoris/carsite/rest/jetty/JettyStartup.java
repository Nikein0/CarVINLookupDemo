package lt.eif.viko.neinoris.carsite.rest.jetty;

public class JettyStartup {
    public JettyStartup() {
    }

    public static void main(String... args) {
        JettyServer jettyServer = new JettyServer();

        try {
            jettyServer.start();
        } catch (Exception var3) {
            throw new RuntimeException(var3);
        }
    }
}
