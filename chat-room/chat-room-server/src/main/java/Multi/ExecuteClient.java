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

    JDBC jdbc = new JDBC();
    ChatPersonInfo person = new ChatPersonInfo();

    public ExecuteClient(Socket currnentClient) {
        this.currnentClient = currnentClient;
    }

    @Override
    public void run() {
        try {

            //接收数据
            Scanner sc = new Scanner(this.currnentClient.getInputStream());

            while (true) {
                sendMessage(this.currnentClient, "*************************************************");
                sendMessage(this.currnentClient, "******        欢迎使用本地聊天系统           ******");
                sendMessage(this.currnentClient, "******      [U] 注册        [L] 登录        ******");
                sendMessage(this.currnentClient, "******    [P] 私聊  [G] 群聊  [Q] 退出      ******");
                sendMessage(this.currnentClient, "******       输入: P G Q U L 进入操作       ******");
                sendMessage(this.currnentClient, "*************************************************");
                String message = sc.next();

                //注册账号
                if (message.equals("U")) {
                    sendMessage(currnentClient, "请输入用户名：");
                    String userName = sc.next();
                    sendMessage(currnentClient, "请输入密码：");
                    String passWord = sc.next();
                    this.registerUser(userName, passWord, currnentClient);
                    continue;
                }

                //登录账号
                if (message.equals("L")) {
                    sendMessage(currnentClient, "请输入用户名：");
                    String userName = sc.next();
                    sendMessage(currnentClient, "请输入密码：");
                    String passWord = sc.next();
                    this.login(userName, passWord, currnentClient);
                    continue;
                }

                //私聊
                if (message.equals("P")) {
                    sendMessage(currnentClient, "请输入私聊成员：");
                    String toUserName = sc.next();
                    sendMessage(currnentClient, "请输入私聊消息：");
                    String toUserMessage = sc.next();
                    this.privateChat(toUserName, toUserMessage);
                    continue;
                }

                //群聊
                if (message.equals("G")) {
                    sendMessage(currnentClient, "请输入群聊消息：");
                    String groupMessage = sc.next();
                    this.groupChat(groupMessage);
                    sendMessage(currnentClient, "消息发送成功！！！");
                    continue;
                }

                //退出
                if (message.equals("Q")) {
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
        String currentUserName = this.currnentClientName();
        System.out.println("用户" + currentUserName + "下线");
        Socket socket = CLIENT_Map.remove(currentUserName);
        this.sendMessage(this.currnentClient, "bye");
        this.printOnlineUser();
    }
    //群聊实现代码

    private void groupChat(String groupMessage) {
        String currentUserName = this.currnentClientName();
        for (Map.Entry<String, Socket> entry : CLIENT_Map.entrySet()) {
            if (!entry.getKey().equals(currentUserName)) {
                this.sendMessage(entry.getValue(), "群消息 from " + currentUserName + " : " + groupMessage);
            }
        }
    }
    //私聊实现代码

    private void privateChat(String toUserName, String toUserMessage) {
        String currentUserName = this.currnentClientName();
        Socket target = CLIENT_Map.get(toUserName);
        if (target != null) {
            this.sendMessage(target, "来自 " + currentUserName + " 的消息: " + toUserMessage + "\n");
            sendMessage(currnentClient, "消息发送成功！！！");
        } else {
            this.sendMessage(currnentClient, "用户不在线,消息发送失败！！！");
        }
    }

    //登录
    private void login(String userName, String passWord, Socket currnentClient) {
        String info = selectInfo(userName, passWord);
        boolean isEmpty = info.isEmpty();//true没找到该用户false找到该用户
        if (isEmpty == false) {
            String name = info.split(",")[0];
            String password = info.split(",")[1];
            if (passWord.equals(password)) {
                if (CLIENT_Map.size() != 0) {
                    for (Map.Entry<String, Socket> entry : CLIENT_Map.entrySet()) {
                        if (entry.getKey().equals(userName)) {
                            sendMessage(this.currnentClient, "该用户已在线，请重新输入账户！！！");
                            break;
                        }
                    }
                    CLIENT_Map.put(userName, this.currnentClient);
                    sendMessage(this.currnentClient, "登录成功！！！");
                }else {
                    CLIENT_Map.put(userName, this.currnentClient);
                    sendMessage(this.currnentClient, "登录成功！！！");
                }
            } else {
                sendMessage(this.currnentClient, "密码错误！！！");
            }
        }
        if (isEmpty == true) {//数据库里没有该账户
            sendMessage(this.currnentClient, "该账户不存在，请注册！！！");
        }
        printOnlineUser();
    }


    //注册实现代码
    private void registerUser(String userName, String passWord, Socket currnentClient) {
        String info = selectInfo(userName, passWord);
        boolean isEmpty = info.isEmpty();//查找数据库的链表里是没有该账户返回true
        if (isEmpty == true) {
            insertInfo(userName, passWord);
            System.out.println(userName + "注册成功！！！" + currnentClient.getRemoteSocketAddress());
            sendMessage(this.currnentClient, "注册成功！！！");
        } else {
            sendMessage(this.currnentClient, "该账户已存在，请重新注册！！！");
        }
    }


//打印在线成员

    private void printOnlineUser() {
        System.out.println("当前在线人数：" + CLIENT_Map.size());
        if (CLIENT_Map.size() != 0) {
            System.out.println("成员列表：");
            for (Map.Entry<String, Socket> entry : CLIENT_Map.entrySet()) {
                System.out.println(entry.getKey());
                System.out.println(this.currnentClient);
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

    private String currnentClientName() {
        String currentName = null;
        for (Map.Entry<String, Socket> entry : CLIENT_Map.entrySet()) {
            if (this.currnentClient.equals(entry.getValue())) {
                currentName = entry.getKey();
                break;
            }
        }
        return currentName;
    }

    //在数据库中查询数据
    private String selectInfo(String userName, String passWord) {
        person.setUserName(userName);
        person.setPassWord(passWord);
        jdbc.sql();
        String info = jdbc.selectPersonInfo(userName);
        return info;
    }

    //在数据库中插入数据
    private void insertInfo(String userName, String passWord) {
        person.setUserName(userName);
        person.setPassWord(passWord);
        jdbc.sql();
        jdbc.addPersonInfo(person);
    }
}
