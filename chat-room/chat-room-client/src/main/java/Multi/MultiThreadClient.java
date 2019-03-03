package Multi;

import java.io.IOException;
import java.net.Socket;

/**
 * Author:lidan
 * Created:2019/2/24
 */
public class MultiThreadClient {
    public static void main(String[] args) {
        int port = 6666;
        String host = "127.0.0.1";
        try {
            if (args.length > 0) {
                port = Integer.parseInt(args[0]);
            }
            System.out.println("正在连接服务器！！！");
            Socket client = new Socket(host, port);
            System.out.println("连接服务器成功！！！");
            new Thread(new ReadDataFromServerThread(client)).start();
            new Thread(new WriteDataToServerThread(client)).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
