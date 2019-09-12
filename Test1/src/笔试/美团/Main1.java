package 笔试.美团;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: lidan
 * @date: 2019/9/11 16:49
 * @Description:
 */
public class Main1 {
    public static String findLCS(String A, String B) {
        List<Character> list = new ArrayList<>();
        for (int i = 1; i < B.length(); i++) {
            int j = 0;
            while (j < A.length()) {
                if (B.charAt(i) == A.charAt(j)) {
                    list.add(A.charAt(i));
                }
            }
        }
        return list.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();
        System.out.println(findLCS(str1, str2));
    }
}
