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
                settingInfo();
                String line = out.next();
                int quit = 0;
                switch (line) {
                    case "U": {
                        System.out.print("请输入用户名：");
                        String message = out.next();
                        outputStreamWriter.write(message + "\n");
                        outputStreamWriter.flush();
                        break;
                    }
                    case "L": {
                        while (true) {
                            usageInfo();
                            String chouce = out.next();
                            switch (chouce) {
                                case "P": {
                                    System.out.print("请输入私聊的成员，以及聊天内容：");
                                    String privateMessage = out.next();
                                    outputStreamWriter.write(privateMessage + "\n");
                                    outputStreamWriter.flush();
                                    break;
                                }
                                case "G": {
                                    System.out.print("请在群中输入聊天内容：");
                                    String groupMessage = out.next();
                                    outputStreamWriter.write(groupMessage + "\n");
                                    outputStreamWriter.flush();
                                    break;
                                }
                                default: {
                                    String quitMessage = chouce;
                                    outputStreamWriter.write(quitMessage + "\n");
                                    outputStreamWriter.flush();
                                    quit = 1;
                                    break;
                                }
                            }
                            if (quit == 1) {
                                break;
                            }
                        }
                    }
                }
                if (quit == 1) {
                    client.close();
                    break;
                }
            }
        } catch (
                IOException e) {
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
