package 笔试.哔哩哔哩;

import java.util.Scanner;

/**
 * @author: lidan
 * @date: 2019/8/20 19:22
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        if (str.toUpperCase().equals(str)) {
            System.out.println("true");
        } else if (str.toLowerCase().equals(str)) {
            System.out.println("true");
        } else {
            char[] arr = str.toCharArray();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < arr.length; i++) {
                sb.append(String.valueOf(arr[0]).toUpperCase());
                sb.append(arr[i]);
            }
            if (sb.toString().equals(str)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }
    }
}
