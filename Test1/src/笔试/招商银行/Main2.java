package 笔试.招商银行;

import java.util.Scanner;

/**
 * @author: lidan
 * @date: 2019/9/15 21:41
 * @Description:
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr1 = new int[n + 1];
        int[] arr2 = new int[n];
        for (int i = 0; i < n + 1; i++) {
            arr1[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr2[i] = in.nextInt();
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int a = arr2[i];
            int b = arr1[i] + arr1[i + 1];
            if (b > a) {
                sum = sum + a;
            } else {
                sum = sum + b;
            }
        }

        System.out.println(sum);
    }
}
