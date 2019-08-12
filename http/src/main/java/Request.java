import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Author:lidan
 * Created:2019/8/11
 */
public class Request {
    private InputStream is;
    private String method;
    private String url;
    private String protocol;
    private Map<String, String> requestParams = new HashMap<>();
    private Map<String, String> headers = new HashMap<>();

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public String getProtocol() {
        return protocol;
    }

    public String getRequestParams(String name) {
        return requestParams.get(name);
    }

    public String getHeader(String header) {
        return headers.get(header);
    }

    /**
     * 请求解析
     *
     * @param is：请求
     * @return
     * @throws IOException
     */
    public static Request parse(InputStream is) throws IOException {
        Request request = new Request();
        request.is = is;
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        parseRequestLine(reader, request);
        parseRequestHeaders(reader, request);

        if (request.method.equals("POST")) {
            parseRequestBody(reader, request);
        }
        return request;
    }

    private static void parseRequestBody(BufferedReader reader, Request request) {
    }

    private static void parseRequestHeaders(BufferedReader reader, Request request) throws IOException {
        String line;
        while ((line = reader.readLine()) != null && line.trim().length() != 0) {
            String[] fragments = line.split(":");
            String key = fragments[0].trim();
            String value = fragments[1].trim();

            request.setHeader(key, value);
        }
    }

    private void setHeader(String key, String value) {
        headers.put(key, value);
    }

    private static void parseRequestLine(BufferedReader reader, Request request) {

    }

}
