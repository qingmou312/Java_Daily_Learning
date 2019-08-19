package 笔试.科大讯飞;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: lidan
 * @date: 2019/8/16 18:14
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        char[] num = new char[str.length()];
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                System.out.println(str.charAt(i));
                num[i] = str.charAt(i);
            }
        }
        if (num == null) {
            System.out.println("-1");
        } else {
            Arrays.sort(num);
            System.out.println(String.format(String.valueOf(num)));
        }
    }
}
