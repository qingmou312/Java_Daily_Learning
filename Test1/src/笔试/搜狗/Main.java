package 笔试.搜狗;

import java.util.Scanner;

/**
 * @author: lidan
 * @date: 2019/9/8 16:51
 * @Description:
 */

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int r = in.nextInt();
        String[] strings = new String[r];
        for (int i = 0; i < r; i++) {
            strings[i] = in.nextLine();
        }
        for (int i = 0; i < strings.length; i++) {
            String str = strings[i];
            String[] strings1 = str.split(" ");
        }
    }
}
