package Multi;

import java.io.IOException;
import java.net.Socket;

/**
 * Author:lidan
 * Created:2019/2/24
 */
public class MultiThreadClient {
    public static void main(String[] args) {
        try {
            System.out.println("正在连接服务器！！！");
            Socket client = new Socket("127.0.0.1", 6666);
            System.out.println("连接服务器成功！！！");
            new Thread(new ReadDataFromServerThread(client)).start();
            new Thread(new WriteDataToServerThread(client)).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
