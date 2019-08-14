package 牛客.Lianxi3_19;

import java.util.Scanner;

/**
 * Author:lidan
 * Created:2019/3/19
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String b = in.next();

        if (n < 3 || n > 20) {
            System.out.println("您的输入有误：");
        } else {
            double c = Math.ceil((double)n/2)-2;
            for (int i = 0; i < c; i++) {
                System.out.print(b);
                if (i == 0 || i == c - 1) {
                    for (int j = 0; j < n - 2; j++) {
                        System.out.print(b);
                    }
                } else {
                    for (int j = 0; j < n - 2; j++) {
                        System.out.print(" ");
                    }
                }
                System.out.print(b);
                System.out.println();
            }

        }
    }
}