package zijietiaodong;

import java.util.Scanner;

/**
 * Author:lidan
 * Created:2019/3/16
 */
public class N {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n <= 0 || n > 1024) {
            System.out.println("你的输入有误");
        } else {
            int a = 1024 - n;
            int b = a % 1024;
            if (b == 0) {
                System.out.println(a / 1024);
            } else {
                int c = b % 64;
                if (c == 0) {
                    System.out.println(a / 1024 + b / 64);
                } else {
                    int d = c % 16;
                    if (d == 0) {
                        System.out.println(a / 1024 + b / 64 + c / 16);
                    } else {
                        int e = d % 4;
                        if (e == 0) {
                            System.out.println(a / 1024 + b / 64 + c / 16 + d / 4);
                        } else {
                            System.out.println(a / 1024 + b / 64 + c / 16 + d / 4 + d % 4);
                        }
                    }
                }
            }
        }
    }
}