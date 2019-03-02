package Multi;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;


/**
 * 从服务器读取数据
 * Author:lidan
 * Created:2019/2/24
 */
public class ReadDataFromServerThread implements Runnable {
    private final Socket client;

    public ReadDataFromServerThread(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = client.getInputStream();
            Scanner in = new Scanner(inputStream);
            while (in.hasNext()) {
                String message = in.nextLine();
                System.out.println(message);
                if(message.equals("bye")){
                    client.close();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}