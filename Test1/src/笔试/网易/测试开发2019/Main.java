package 笔试.网易.测试开发2019;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Author:lidan
 * Created:2019/8/3
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr1 = new int[n];
        double[] arr2 = new double[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = in.nextInt();
            arr2[i] = arr1[i];
        }
        Arrays.sort(arr1);
        for (int i = 0; i < n; i++) {
            double s = Arrays.binarySearch(arr1, (int) arr2[i]) + 1;
            arr2[i] = Double.parseDouble(String.format("%.6f", (((s - 1) / n)) * 100));
        }
        int q = in.nextInt();
        double[] arr3 = new double[q];
        for (int i = 0; i < q; i++) {
            int a = in.nextInt();
            arr3[i] = arr2[a - 1];
        }
        for (int i = 0; i < q; i++) {
            System.out.println(arr3[i]);
        }
    }
}
