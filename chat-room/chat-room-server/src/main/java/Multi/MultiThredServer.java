package Multi;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author:lidan
 * Created:2019/2/24
 */
public class MultiThredServer {
    public static void main(String[] args) {
        final ExecutorService ONLINE_USER = Executors.newFixedThreadPool(10);
        try {
            ServerSocket client = new ServerSocket(6666);
            System.out.println("等待客户端的连接。。。");

            while (true) {
                Socket socket=client.accept();
                ONLINE_USER.submit(new ExecuteClient(socket));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
