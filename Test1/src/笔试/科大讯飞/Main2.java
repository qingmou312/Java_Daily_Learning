package 笔试.科大讯飞;

import java.util.Scanner;

/**
 * @author: lidan
 * @date: 2019/8/16 18:51
 * @Description:
 */
public class Main2 {
//    public static void main(String[] args) {
//        int[] arr = {12,13}
//    }

    public static int binarySearch(int[] arr, int key, int left, int right) {
        int mid = left + (right - left) / 2;
        if (key == arr[mid]) {
            return mid;
        }
        if (key > arr[mid]) {
            right = mid;
        }
        if (key < arr[mid]) {
            left = mid;
        }
        return binarySearch(arr, key, left, right);
    }
}
