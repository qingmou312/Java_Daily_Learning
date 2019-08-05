//package EverydayTest.day40;
//
//import java.util.Scanner;
//
///**
// * Author:lidan
// * Created:2019/7/20
// */
//public class Main {
//    public String Reverse(String sentence) {
//        String[] str1 = sentence.split(" ");
//        StringBuffer str2 = new StringBuffer();
//        for (int i = str1.length - 1; i >= 0; i--) {
//            System.out.println(str1[i]);
//            str2.append(str1[i]);
//            if (i != 0) {
//                str2.append(" ");
//            }
//        }
//        System.out.println(str2.toString());
//        return str2.toString();
//    }
//
//    public static void main(String[] args) {
//        Main hello = new Main();
//        Scanner in = new Scanner(System.in);
//        String string = in.nextLine();
//        System.out.println(hello.Reverse(string));
//    }
//}
//
//
//public class Solution {
//    public String replaceSpace(StringBuffer str) {
//        char[] chars = str.toString().toCharArray();
//        StringBuffer stringBuffer = new StringBuffer();
//        for (int i = 0; i < str.length(); i++) {
//            String tmp = String.valueOf(chars[i]);
//            if (tmp.equals(" ")) {
//                tmp = "%20";
//            }
//            stringBuffer.append(tmp);
//        }
//        return stringBuffer.toString();
//    }
//}