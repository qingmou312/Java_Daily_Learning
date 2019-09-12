package 笔试.滴滴;

import java.util.Scanner;

/**
 * @author: lidan
 * @date: 2019/8/27 19:42
 * @Description:
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n < 3 || n > 20000) {
            return;
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                max = max + arr[i];
            }
        }
        System.out.println(max);
    }
}
