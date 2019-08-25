package com.github.qingmou312.server;

import com.github.qingmou312.util.CommUtils;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: lidan
 * @date: 2019/8/25 8:54
 * @Description: 聊天室服务端
 */
public class MultiThreadServer {
    private static final String IP;
    private static final int PORT;
    //缓存当前服务器所有在线的客户端的信息
    private static Map<String, Socket> clients = new ConcurrentHashMap<>();
    //缓存当前服务器注册的所有群名称以及群好友
    private static Map<String, Set<String>> groups = new ConcurrentHashMap<>();

    //获取加载文件信息
    static {
        java.util.Properties properties = CommUtils.loadProperties("socket.properties");
        IP = properties.getProperty("address");
        PORT = Integer.parseInt(((java.util.Properties) properties).getProperty("port"));
    }

    private static class ExecuteClient implements Runnable {
        private Socket client;
        private Scanner in;
        private PrintStream out;

        public ExecuteClient(Socket client) throws IOException {
            this.client = client;
            this.in = new Scanner(client.getInputStream());
            this.out = new PrintStream(client.getOutputStream(), true, "UTF-8");
        }

        @Override
        public void run() {

        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        ExecutorService executorService = Executors.newFixedThreadPool(50);
        for (int i = 0; i < 50; i++) {
            System.out.println("等待客户端连接...");
            Socket client = serverSocket.accept();
            System.out.println("客户端连接成功，端口号为" + client.getPort());
            executorService.submit(new ExecuteClient(client));
        }
    }
}
