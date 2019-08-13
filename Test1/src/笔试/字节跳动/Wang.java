package 笔试.字节跳动;

import java.util.Scanner;

/**
 * Author:lidan
 * Created:2019/3/16
 */
public class Wang {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = new String();
        int n = in.nextInt();
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = in.next();
        }

        for (int i = 0; i < n; i++) {
            StringBuffer sb = new StringBuffer(str[i]);
            for (int j = 0; j < str[i].length() - 2; j++) {
                if (sb.substring(i, i + 1).equals(sb.substring(i + 1, i + 2)) && (sb.substring(i + 1, i + 2).equals(sb.substring(i + 2, i + 3)))) {
                    a = sb.delete(i, i + 1).toString();
                }
            }
            for (int k = 0; k < sb.length() - 3; k++) {
                if (sb.substring(k, k + 1).equals(sb.substring(k + 1, k + 2)) && (sb.substring(k + 2, k + 3).equals(sb.substring(k + 3, k + 4)))) {
                    a = sb.delete(k + 2, k + 3).toString();
                }
            }
        }
        System.out.println(a);
    }
}
