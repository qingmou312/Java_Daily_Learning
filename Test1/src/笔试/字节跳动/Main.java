package 笔试.字节跳动;

import java.util.Scanner;

/**
 * @author: lidan
 * @date: 2019/9/8 19:15
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        num(str);
    }

    private static void num(String s) {
        char[] elements = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
                'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        StringBuffer sb = new StringBuffer();
        if (s.equals("0")) {
            return;
        }

        int[] dp = new int[s.length() + 1];
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            sb.append(elements[Integer.parseInt(String.valueOf(arr[i])) - 1]);
        }
        System.out.println(sb.toString());
        for (int i = 2; i < dp.length; i++) {
            int two = arr[i - 1] - 48 + (arr[i - 2] - 48) * 10;
            System.out.println(elements[two-1]);
            if (two < 27 && two > 0 && (arr[i - 2] - 48) > 0) {
                if (arr[i - 1] != 48) {
                    dp[i] = dp[i - 2] + dp[i - 1];
                } else {
                    dp[i] = dp[i - 2];
                }
            } else {
                if (two == 0 || arr[i - 1] == 48) {
                    dp[i] = 0;
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }
    }
}
