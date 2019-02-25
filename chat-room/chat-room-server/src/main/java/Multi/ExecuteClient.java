package Multi;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Author:lidan
 * Created:2019/2/24
 */
public class ExecuteClient implements Runnable {
    private final Socket currnentClient;//当前客户端
    private final static Map<String, Socket> CLIENT_Map = new ConcurrentHashMap<String, Socket>();//存储注册的用户

    public ExecuteClient(Socket currnentClient) {
        this.currnentClient = currnentClient;
    }

    @Override
    public void run() {
        try {

            //接收数据
            Scanner sc = new Scanner(this.currnentClient.getInputStream());

            while (true) {

                String message = sc.next();
                //注册账号
                if (message.startsWith("userName")) {
                    String userName = message.split("\\:")[1];
                    this.registerUser(userName, currnentClient);
                    continue;
                }

                //私聊
                if (message.startsWith("private")) {
                    String toUserName = message.split("\\:")[1];
                    String toUserMessage = message.split("\\:")[2];
                    this.privateChat(toUserName, toUserMessage);
                    continue;
                }

                //群聊
                if (message.startsWith("group")) {
                    String groupMessage = message.split("\\:")[1];
                    this.groupChat(groupMessage);
                    continue;
                }

                //退出
                if (message.startsWith("bye")) {
                    this.quit();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //退出程序
    private void quit() {
        String currentUserName = this.currnentClient();
        System.out.println("用户" + currentUserName + "下线");
        Socket socket = CLIENT_Map.remove(currentUserName);
        this.sendMessage(socket, "bye");
        this.printOnlineUser();
    }

    //群聊实现代码
    private void groupChat(String groupMessage) {
        String currentUserName = this.currnentClient();
        for (Map.Entry<String, Socket> entry : CLIENT_Map.entrySet()) {
            if (!entry.getKey().equals(currentUserName)) {
                this.sendMessage(entry.getValue(), currentUserName + "在群里说" + groupMessage);
            }
        }
    }

    //私聊实现代码
    private void privateChat(String toUserName, String toUserMessage) {
        String currentUserName = this.currnentClient();
        Socket target = CLIENT_Map.get(toUserName);
        if (target != null) {
            this.sendMessage(target, currentUserName + "对你说" + toUserMessage);
        }
    }


    //注册实现代码
    private void registerUser(String userName, Socket currnentClient) {
        System.out.println(userName + "注册成功！！！" + currnentClient.getRemoteSocketAddress());
        CLIENT_Map.put(userName, currnentClient);
        sendMessage(this.currnentClient, "系统消息： 注册成功！！！");
        printOnlineUser();
    }

    //打印在线成员
    private void printOnlineUser() {
        System.out.println("当前在线人数：" + CLIENT_Map.size());
        if (CLIENT_Map.size() != 0) {
            System.out.println("成员清单：");
            for (Map.Entry<String, Socket> entry : CLIENT_Map.entrySet()) {
                System.out.println(entry.getKey());
            }
        }
    }

    //发送数据
    private void sendMessage(Socket currnentClient, String s) {
        try {
            OutputStream outputStream = currnentClient.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            outputStreamWriter.write(s + "\n");
            outputStreamWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //返回发消息人的ID
    private String currnentClient() {
        String currentName = "";
        for (Map.Entry<String, Socket> entry : CLIENT_Map.entrySet()) {
            if (this.currnentClient.equals(entry.getValue())) {
                currentName = entry.getKey();
                break;
            }
        }
        return currentName;
    }
}
