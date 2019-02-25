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
        InputStream inputStream;
        try {
            Scanner in = new Scanner(client.getInputStream());
            while (in.hasNext()) {
                System.out.println(in.nextLine());
                if (in.next().equals("bye")) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
