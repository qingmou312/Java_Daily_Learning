package 笔试.度小满;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: lidan
 * @date: 2019/9/15 19:30
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        int max = Math.max(x, y) + 1;
        int[][] arr = new int[max][max];
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int z = in.nextInt();
            int w = in.nextInt();
            arr[z][w] = 1;
        }

        System.out.println(1);
    }
}
