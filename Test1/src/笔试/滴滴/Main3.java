package 笔试.滴滴;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: lidan
 * @date: 2019/8/27 19:28
 * @Description:
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        int sum = 0;
        for (int i = 0; i < m; i++) {
            int[] arr2 = new int[n];
            for (int j = 0; j < n; j++) {
                arr2[j] = arr[j][i];
            }
            Arrays.sort(arr2);
            sum = sum + arr2[n - 1];
        }
        System.out.println(sum);
    }
}
