package 笔试.哔哩哔哩;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: lidan
 * @date: 2019/8/20 19:38
 * @Description:
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();
        int[][] arr = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 1; i < str2.length() + 1; i++) {
            for (int j = 1; j < str1.length() + 1; j++) {
                if (str2.charAt(i) == str1.charAt(j)) {
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                    System.out.println(str2.charAt(i));
                    System.out.println(str2.charAt(i));
                }
            }
        }
//        Arrays.sort(arr);
//        System.out.println(arr[str1.length() + 1][str2.length() + 1]);
    }
}
