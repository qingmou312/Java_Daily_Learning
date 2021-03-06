package Multi;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author:lidan
 * Created:2019/2/24
 */
public class MultiThredServer {
    public static void main(String[] args) {
        final ExecutorService ONLINE_USER = Executors.newFixedThreadPool(10);
        int port = 6666;
        try {
            if (args.length > 0) {
                port = Integer.parseInt(args[0]);
            }
            ServerSocket client = new ServerSocket(port);
            System.out.println("等待客户端的连接。。。");

            while (true) {
                Socket socket = client.accept();
                System.out.println("客户端连接成功！！！");
                ONLINE_USER.submit(new ExecuteClient(socket));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
