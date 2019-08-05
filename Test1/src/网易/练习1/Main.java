package 网易.练习1;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Author:lidan
 * Created:2019/8/2
 * <p>
 * 牛牛找工作
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] arr = new int[n][2];
        TreeMap treeMap = new TreeMap();
        for (int i = 0; i < n; i++) {
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
        }
        Arrays.sort(arr,(e1,e2)->(int)(e1[0]-e2[0]));
    }

}
