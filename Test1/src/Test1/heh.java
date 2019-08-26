package Test1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: lidan
 * @date: 2019/8/26 15:32
 * @Description:
 */
public class heh {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] arr = new int[n][m];
        int[][] arr2 = new int[n][m];
        int k = in.nextInt();
        for (int z = 0; z < k; z++) {
            int x = in.nextInt();
            int y = in.nextInt();
            if (x > n || x < 0 || y > m || y < 0) {
                return;
            }
            if (x == n || y == m) {
                for (int i = 0; i < arr2.length; i++) {
                    for (int j = 0; j < arr2[0].length; j++) {
                        arr[i][j] = arr2[i][j];
                    }
                }
            } else {
                arr2[x][y] = 1;
                for (int i = 0; i < arr2.length; i++) {
                    for (int j = 0; j < arr2[0].length; j++) {
                        arr[i][j] = arr2[i][j];
                    }
                }
            }

            System.out.print(numIslands(arr) + " ");
        }
    }

    public static int numIslands(int[][] arr) {
        int islandNum = 0;//岛屿的数量
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1) {
                    islandNum++;
                    infect(arr, i, j);
                }
            }
        }
        return islandNum;
    }

    public static void infect(int[][] arr, int i, int j) {
        if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length || arr[i][j] != 1) {
            return;
        }

        arr[i][j] = 2;
        infect(arr, i + 1, j);
        infect(arr, i - 1, j);
        infect(arr, i, j + 1);
        infect(arr, i, j - 1);
    }
}
