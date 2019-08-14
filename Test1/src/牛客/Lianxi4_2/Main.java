package 牛客.Lianxi4_2;

import java.util.Scanner;

/**
 * Author:lidan
 * Created:2019/4/2
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        if (a < 1 || a > 200) {
            System.out.println("您的参数不合法");
        }
        int[] arr = new int[a];
        int x = 0;
        for (int i = 0; i < a; i++) {
            arr[i] = in.nextInt();
        }
        x = in.nextInt();
        for (int j = 0; j < a; j++) {
            if (arr[j] == x) {
                System.out.println(j);
            }
        }
    }
}