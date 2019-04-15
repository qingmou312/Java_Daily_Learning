package Kuaishou;

import java.util.Scanner;

/**
 * Author:lidan
 * Created:2019/4/13
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num1 = in.nextInt();
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((num1 & 1) == 1) {
                count = count + 1;
            }
            num1 = (num1 >> 1);
        }
        System.out.println(count);
    }
}
