package NiuKe.Lianxi4_23;

import java.util.Scanner;

/**
 * Author:lidan
 * Created:2019/4/23
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        if (str1.length() > 100) {
            System.out.println("请重新输入：");
        } else {
            String[] str2 = str1.split("_");
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < str2.length-1; i++) {
                sb.append(0);
                sb.append(str2[i+1].substring(0, 1).toUpperCase() + str2[i+1].substring(1));
            }
            System.out.println(sb.toString());
        }
    }
}