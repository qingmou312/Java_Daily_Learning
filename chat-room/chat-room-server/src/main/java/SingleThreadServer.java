import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Author:lidan
 * Created:2019/2/23
 */
public class SingleThreadServer {
    public static void main(String[] args) {
        int port=6666;
        try {
            if(args.length>0){
                port=Integer.valueOf(args[0]);
            }
            //创建一个服务端对象
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("等待客户端的连接。。。");
            System.out.println(serverSocket.getLocalSocketAddress());


            //接收客户端连接，创建Socket对象
            Socket client = serverSocket.accept();


            //发送数据
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(client.getOutputStream());
            outputStreamWriter.write("你好，这是来自服务端的消息。\n");
            outputStreamWriter.flush();


            //接收数据
            Scanner clientInput = new Scanner(client.getInputStream());
            System.out.println("接收到来自客户端的消息:" + clientInput.next());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
