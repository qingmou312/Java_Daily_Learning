package 笔试.去哪儿网;

import java.util.Scanner;

/**
 * @author: lidan
 * @date: 2019/9/12 15:43
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        int maxnum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                int[] arr1 = new int[arr[0].length];
                for (int w = 0; w < arr[0].length; w++) {
                    sum = 0;
                    for (int k = i; k <= j; k++) {
                        sum = sum + arr[k][w];
                    }
                    arr1[w] = sum;
                }
                maxnum = Math.max(maxsum1(arr1), maxnum);
            }
        }
        System.out.println(maxnum);
    }

    private static int maxsum1(int[] arr) {
        int maxSum = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sum < 0) {
                sum = arr[i];
            } else {
                sum += arr[i];
            }
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }
}