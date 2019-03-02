//package Multi;
//
//import java.lang.reflect.Array;
//import java.util.ArrayList;
//
///**
// * Author:lidan
// * Created:2019/3/2
// */
//public class Test {
//    public static void main(String[] args) {
//        ChatPersonInfo personInfo = new ChatPersonInfo();
//        personInfo.setUserName("wangwu");
//        personInfo.setPassWord("111");
//        JDBC jdbc = new JDBC();
//        jdbc.sql();
//        //jdbc.addPersonInfo(personInfo);
//      ArrayList<String> info =jdbc.selectPersonInfo("wangwu");
//      for(int i=0;i<info.size();i++) {
//          System.out.println(info.get(i));
//      }
//    }
//


import java.io.*;
import java.net.*;

/**
 * 服务端
 * 负责发送数据
 */
public class Test {
    private static final int PORT = 5209;

    public static void test() {
        ServerSocket server = null;
        Socket socket = null;
        DataOutputStream out = null;
        try {
            server = new ServerSocket(PORT);
            socket = server.accept();
            out = new DataOutputStream(socket.getOutputStream());
            while (true) {
                Thread.sleep(1000);
                out.writeUTF(getRandomStr());
                out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static String getRandomStr() {
        String str = "";
        int ID = (int) (Math.random() * 30);
        int x = (int) (Math.random() * 200);
        int y = (int) (Math.random() * 300);
        int z = (int) (Math.random() * 10);
        str = "ID:" + ID + "/x:" + x + "/y:" + y + "/z:" + z;
        return str;
    }


    public static void main(String[] args) {
        test();
    }
}
