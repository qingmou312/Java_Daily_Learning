import java.io.OutputStream;

/**
 * Author:lidan
 * Created:2019/8/11
 */
public class Response {
    private OutputStream os;

    public static Response build(OutputStream os) {
        Response response = new Response();
        response.setOutputStream(os);
        response.setContentType("text/html");
        response.setDate();
        response.setHeader("Server", "HTTP/1.0.0");

        return response;
    }

    private void setHeader(String server, String s) {
    }

    private void setDate() {
    }

    private void setContentType(String s) {
    }

    private void setOutputStream(OutputStream os) {
        this.os = os;
    }
}
