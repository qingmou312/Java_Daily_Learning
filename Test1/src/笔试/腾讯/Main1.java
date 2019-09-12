package 笔试.腾讯;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: lidan
 * @date: 2019/9/1 20:23
 * @Description:
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int k = t;
        while (k > 0) {
            int n = in.nextInt();
            if (n / 2 == 1) {
                return;
            }
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            Arrays.sort(arr);
            for (int i = n; i > 0; i -= 2) {
                int[] newArr = new int[i];
                for (int j = 0; j < 0; j++) {
                    if (arr[j] == arr[j + 1]) {
                        newArr = Arrays.copyOfRange(arr, j - 1, j + 2);
                    }
                }
                if (newArr.length == 2) {
                    if (newArr[0] == newArr[1]) {
                        System.out.println("no");
                    } else {
                        System.out.println("yes");
                    }
                }
            }
            k--;
        }
    }
}
