package lt.eif.viko.neinoris.carsite.rest.config;

public class RequestLoad {
    private String request;
    public RequestLoad() {

    }

    public RequestLoad(String request) {
        this.request = request;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }
}
