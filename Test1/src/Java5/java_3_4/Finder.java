package Java5.java_3_4;

import java.util.*;

/**
 * Author:lidan
 * Created:2019/3/3
 */

public class Finder {
    public int findKth(int[] a, int n, int K) {
        int left = a[0];
        int right = a[a.length - 1];
        Finder finder=new Finder();
        finder.sort(a, left, right);
        int c=a[a.length-K+1];
        return c;
    }

    public void sort(int[] a, int low, int high) {
        int start = low;
        int end = high;
        int key = a[low];

        while (end > start) {
            //从后往前比较
            while (end > start && a[end] >= key)
                end--;
            if (a[end] <= key) {
                int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }
            //从前往后比较
            while (end > start && a[start] <= key)
                start++;
            if (a[start] >= key) {
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
        }
        //递归
        if (start > low) sort(a, low, start - 1);
        if (end < high) sort(a, end + 1, high);
    }

    public static void main(String[] args) {
        int[] a = {2, 4, 3, 9, 1, 7};
        Finder finder = new Finder();
        int c = finder.findKth(a, 6, 3);
        System.out.println(c);
    }
}
