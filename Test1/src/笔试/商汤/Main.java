package 笔试.商汤;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author: lidan
 * @date: 2019/8/19 19:21
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stack str = new Stack();
        String string = in.nextLine();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '+') {
//                int a = (int) str.pop();
//                int b = (char) str.pop();
//                char c = 0;
//                c = (char) (a + b);
//                str.push(c);
//            } else if (string.charAt(i) == '-') {
//                int a = (int) str.pop();
//                int b = (int) str.pop();
//                int c = 0;
//                c = b - a;
//                str.push(c);
//
//            } else if (string.charAt(i) == '*') {
//                int a = (int) str.pop();
//                int b = (int) str.pop();
//                int c = 0;
//                c = a * b;
//                str.push(c);
//
//            } else if (string.charAt(i) == '/') {
//                int a = (int) str.pop();
//                int b = (int) str.pop();
//                int c = 0;
//                c = b / a;
//                str.push(c);

                int a = Integer.parseInt(String.valueOf(str.pop()));
                System.out.println(a);
                int b = Integer.parseInt(String.valueOf(str.pop()));
                System.out.println(b);
                int c = a + b;
                System.out.println(c);
                str.push(c);

            } else {
                str.push(string.charAt(i));
            }
        }
//        System.out.println(str.pop());
    }
}
