package 笔试.CVTE;

import java.util.Arrays;

/**
 * @author: lidan
 * @date: 2019/8/30 19:34
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 200; i > 0; i--) {
            int num = (int) (Math.random() * 100) + 1;
            int j = 200-i;
            int k = Arrays.binarySearch(arr, num);
            if (k >= 0 && k < 100) {
                System.out.println("Day " + (j + 1) + "Pill #" + num);
                arr[j] = num;
            } else {
                System.out.println("Day " + (j + 1) + "Pill #" + num);
            }
        }
    }
}
