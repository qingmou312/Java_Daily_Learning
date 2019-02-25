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
                String line = out.next();
                settingInfo();
                switch (line){
                    case "U":
                        System.out.print("请输入用户名：");
                        String message=out.next();
                        outputStreamWriter.write(message + "\n");
                        outputStreamWriter.flush();
                    case "L":
                        usageInfo();
                        String chouce=out.next();
                        switch (chouce){
                            case"P":
                            case"G":
                            case"Q":
                        }

                }
                if (line.equals("bye")) {
                    client.close();
                    break;
                }
            }
        } catch (
                IOException e)

        {
            e.printStackTrace();
        }
    }
    //菜单
    public static void settingInfo() {
        System.out.println("*************************************************");
        System.out.println("******        欢迎使用本地聊天系统          ******");
        System.out.println("******      [U] 注册       [L] 登录        ******");
        System.out.println("******         输入:  U L 进入操作         ******");
        System.out.println("*************************************************");
    }

    public static void usageInfo() {
        System.out.println("*************************************************");
        System.out.println("******        欢迎使用本地聊天系统          ******");
        System.out.println("******      [P] 私聊  [G] 群聊  [Q] 退出    ******");
        System.out.println("******        输入:  P G Q 进入操作         ******");
        System.out.println("*************************************************");
    }
}
