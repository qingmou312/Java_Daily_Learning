package 笔试.京东;

import java.util.Scanner;

/**
 * @author: lidan
 * @date: 2019/8/24 20:32
 * @Description:
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] > arr[i + 1]) {

            }
            if (arr[i] < arr[i + 1]) {

            }
            if (arr[i] == arr[i]) {

            }
        }
    }
}
