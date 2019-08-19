package 笔试.腾讯;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: lidan
 * @date: 2019/8/17 20:03
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        if (n < k) {
            System.out.print("null");
        } else if (n == k) {
            System.out.print("1");
        } else {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            int[] sum = new int[n - k + 1];
            for (int i = 0; i < n - k + 1; i++) {
                int num = 0;
                for (int j = 0; j < k; j++) {
                    num = num + arr[j + i];
                }
                sum[i] = num;
            }
            int key = 0;
            for (int i = 0; i < n - k - 1; i++) {
                key = Math.min(sum[i], sum[i + 1]);
            }
            System.out.println(Arrays.binarySearch(sum, key) + 1);
        }
    }
}
