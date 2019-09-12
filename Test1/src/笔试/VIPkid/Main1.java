package 笔试.VIPkid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author: lidan
 * @date: 2019/9/3 16:23
 * @Description:
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] strings = str.split(",");
        int[] arr = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            arr[i] = Integer.parseInt(strings[i]);
        }
        int count = 0;
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (!list.contains(arr[i])||arr[i]>=Integer.MAX_VALUE||arr[i]<=Integer.MIN_VALUE) {
                list.add(arr[i]);
            }
        }
        int[] arr1 = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr1[i] = list.get(i);
        }
        for (int i = 0; i < arr1.length; i++) {
            for (int j = i + 1; j < arr1.length; j++) {
                if (arr1[i] + arr1[j] == 0) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
