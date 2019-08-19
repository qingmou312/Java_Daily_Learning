package 笔试.奇虎360;

import java.util.Scanner;

/**
 * @author: lidan
 * @date: 2019/8/15 19:38
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        if (N <= 0 || M <= 0) {
            return;
        }
        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        int shang = N * M;
        int qian = 0;
        int zuo = 0;
        int sum = 0;
        for (int i = 0; i < M; i++) {
            int max = 1;
            for (int j = 0; j < N - 1; j++) {
                 max = Math.max(arr[j][i], arr[j + 1][i]);
            }
            qian += max;
        }
        for (int i = 0; i < N; i++) {
            int max = 1;
            for (int j = 0; j < M - 1; j++) {
                 max = Math.max(arr[i][j], arr[i][j + 1]);
            }
            zuo += max;
        }
        sum = (shang + zuo + qian) * 2;
        System.out.println(sum);
    }
}
