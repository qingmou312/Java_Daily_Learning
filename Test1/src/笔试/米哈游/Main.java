package 笔试.米哈游;

import java.util.Scanner;

/**
 * @author: lidan
 * @date: 2019/9/7 18:31
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) <= Integer.MAX_VALUE && str.charAt(i) > 0) {
                for (int j = 0; j <= str.charAt(i); j++) {
                    sb.append(str.charAt(i - 1));
                }
            }
            if (str.charAt(i) == '-') {
//                for(char )
            }
        }
    }
}
