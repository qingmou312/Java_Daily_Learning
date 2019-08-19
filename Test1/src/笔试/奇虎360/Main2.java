package 笔试.奇虎360;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: lidan
 * @date: 2019/8/15 20:33
 * @Description:
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] arr = new int[2][n];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        Arrays.sort(arr[0]);
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr2[i] = arr[1][i];
        }

        for (int i = n; i >= 0; i--) {
            int a = arr[0][i];
            int b = arr2[n - i];
            int c = (a + b) / n;
        }
    }
}
