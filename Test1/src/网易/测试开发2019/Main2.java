package 网易.测试开发2019;

import java.util.Scanner;

/**
 * Author:lidan
 * Created:2019/8/3
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int j = 0; j < t; j++) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            int a = 0, b = 0, c = 0;
            for (int i = 0; i < n; i=i+2) {
                a = arr[i];
                b = arr[i + 1];
                c = arr[i + 2];
                if (b < (a + c)) {
                    System.out.println("YES");
                    continue;
                }else {
                    System.out.println("NO");
                    break;
                }
            }
        }

    }
}
