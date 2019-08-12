import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Author:lidan
 * Created:2019/8/11
 */
public class Main {
    public static void main(String[] args) throws IOException {
        String requestMessage = "GET /thread.html?id=18&page=9 HTTP/1.1"
                + "Host: www.bitvip.com\r\n"
                + "Accept: text/html\r\n"
                + "\r\n";
        InputStream is = new ByteArrayInputStream(requestMessage.getBytes());
        Request request = Request.parse(is);


    }
}
