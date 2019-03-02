package Multi;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * 数据写入到服务器
 * Author:lidan
 * Created:2019/2/24
 */
public class WriteDataToServerThread implements Runnable {
    private final Socket client;

    public WriteDataToServerThread(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(client.getOutputStream());
            Scanner out = new Scanner(System.in);
            while (true) {
                String message = out.next();
                outputStreamWriter.write(message + "\n");
                outputStreamWriter.flush();
                if (message.equals("Q")) {
                    break;
                }
            }

        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
