package NiuKe.Lianxi4_23;

import java.util.Scanner;

/**
 * Author:lidan
 * Created:2019/4/23
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String[] strings = str1.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < strings.length; i++) {
            sb.append(strings[strings.length - 1 - i]);
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}
