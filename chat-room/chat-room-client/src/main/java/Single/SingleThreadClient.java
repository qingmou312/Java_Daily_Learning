package Single;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Author:lidan
 * Created:2019/2/23
 */
public class SingleThreadClient {
    public static void main(String[] args) {
        int port = 6666;
        String host = "127.0.0.1";
        try {
            if (args.length > 0) {
                port = Integer.parseInt(args[0]);
            }
            //创建客户端对象
            Socket client = new Socket(host, port);
            System.out.println("连接服务端成功:" + client.getPort());


            //发送数据
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(client.getOutputStream());
            outputStreamWriter.write("你好，这是客户端的消息。\n");
            outputStreamWriter.flush();


            //接收数据
            Scanner scanner = new Scanner(client.getInputStream());
            System.out.println("接收到来自服务端的消息：" + scanner.next());
            client.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
