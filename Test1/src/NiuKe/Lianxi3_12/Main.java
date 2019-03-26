package NiuKe.Lianxi3_12;

import java.util.Scanner;
import java.util.Stack;

/**
 * Author:lidan
 * Created:2019/3/12
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(reverse(str));
    }
//    //1.利用StringBuffer的reverse方法
//    public static String  reverse(String str){
//        StringBuffer str1=new StringBuffer(str);
//        return str1.reverse().toString();
//    }

    //    //2.把字符串放到一个数组里面，前后交换
//    public static String reverse(String str){
//        int left=0;
//        int right=str.length()-1;
//        char[] arr=str.toCharArray();
//        while(left<right){
//            char tmp=arr[left];
//            arr[left]=arr[right];
//            arr[right]=tmp;
//            left++;
//            right--;
//        }
//        return String.valueOf(arr);
//    }
//    //3.利用栈的先进后出特性
//    public static String reverse(String str) {
//        StringBuffer stringBuffer=new StringBuffer();
//        Stack<Character> stack = new Stack<>();
//        for (int i = 0; i < str.length(); i++) {
//            stack.push(str.charAt(i));
//        }
//        for(int j=0;j<str.length();j++){
//            stringBuffer.append(stack.pop());
//        }
//        return stringBuffer.toString();
//    }
//    //4.倒叙遍历字符串
//    public static String reverse(String str) {
//        String string = "";
//        for (int i = 0; i < str.length(); i++) {
//            string = str.charAt(i) + string;
//        }
//        return string;
//    }
//    //5.异或操作
    public static String reverse(String str) {
        char[] arr = str.toCharArray();
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            arr[left] = (char) (arr[left] ^ arr[right]);
            arr[right] = (char) (arr[left] ^ arr[right]);
            arr[left] = (char) (arr[right] ^ arr[left]);
            left++;
            right--;
        }
        return String.valueOf(arr);
    }
}
